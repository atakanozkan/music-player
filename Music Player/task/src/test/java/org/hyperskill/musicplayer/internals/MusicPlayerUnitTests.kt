package org.hyperskill.musicplayer.internals


import android.app.Activity
import android.content.pm.ProviderInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.SystemClock
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import androidx.annotation.ColorInt
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView
import org.hyperskill.musicplayer.internals.AddPlaylistScreen.Companion.ID_ADD_PLAYLIST_BTN_OK
import org.hyperskill.musicplayer.internals.AddPlaylistScreen.Companion.ID_ADD_PLAYLIST_ET_PLAYLIST_NAME
import org.hyperskill.musicplayer.internals.AddPlaylistScreen.Companion.ID_SONG_SELECTOR_ITEM_CHECKBOX
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_CONTROLLER_BTN_PLAY_PAUSE
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.robolectric.Robolectric
import org.robolectric.Shadows
import org.robolectric.shadows.ShadowAlertDialog
import org.robolectric.shadows.ShadowMediaPlayer
import java.time.Duration
import java.util.Collections.max
import java.util.concurrent.TimeUnit

// version 2.0
open class MusicPlayerUnitTests<T : Activity>(clazz: Class<T>): AbstractUnitTest<T>(clazz) {

    init {
        CustomMediaPlayerShadow.setCreateListener(::onMediaPlayerCreated)
    }

    val songFakeList = (1..10).map { idNum ->
        SongFake(
            id = idNum,
            artist = "artist$idNum",
            title = "title$idNum",
            duration = 215_000
        )
    }

    private var playerPrivate: MediaPlayer? = null
    private var shadowPlayerPrivate: ShadowMediaPlayer? = null

    protected var player: MediaPlayer
        get() {
            assertNotNull("No MediaPlayer was found", playerPrivate)
            return this.playerPrivate!!
        }
        set(_) {}

    protected var shadowPlayer: ShadowMediaPlayer
        get() {
            assertNotNull("No MediaPlayer was found", playerPrivate)
            shadowPlayer.invalidStateBehavior = ShadowMediaPlayer.InvalidStateBehavior.ASSERT
            return this.shadowPlayerPrivate!!
        }
        set(_) {}

    fun isPlayerNull(): Boolean {
        return playerPrivate == null
    }

    private fun onMediaPlayerCreated(player: MediaPlayer, shadow: ShadowMediaPlayer) {
        playerPrivate = player
        shadowPlayerPrivate = shadow
    }

    fun setupContentProvider(fakeSongResult: List<SongFake>){
        val info = ProviderInfo().apply {
            authority = MediaStore.AUTHORITY
        }
        Robolectric.buildContentProvider(FakeContentProvider::class.java).create(info)
        FakeContentProvider.fakeSongResult = fakeSongResult
    }

    fun ShadowAlertDialog.clickAndRunOnItem(itemIndex: Int, millis: Long = 500): Int {
        val timeBeforeClick = SystemClock.currentGnssTimeClock().millis()
        this.clickOnItem(itemIndex) // might or might not increase clock time
        val timeAfterClick = SystemClock.currentGnssTimeClock().millis()
        shadowLooper.idleFor(Duration.ofMillis(millis - (timeAfterClick - timeBeforeClick)))
        val timeAfterIdle = SystemClock.currentGnssTimeClock().millis()

        assertTrue(
            "After click on AlertDialog item the dialog should be dismissed",
            this.hasBeenDismissed()
        )

        return (timeAfterIdle - timeBeforeClick).toInt()
    }


    fun Int.timeString(): String {
        return "%02d:%02d".format(this / 60_000, this % 60_000 / 1000)
    }

    fun View.assertBackgroundColor(errorMessage:String, @ColorInt expectedBackgroundColor: Int, ) {

        assertTrue("Expected background to be ColorDrawable but was not. $errorMessage", this.background is ColorDrawable)

        val actualBackgroundColor = (this.background as ColorDrawable).color

        assertTrue(errorMessage, expectedBackgroundColor == actualBackgroundColor)
    }

    fun Drawable.assertCreatedFromResourceId(errorMessage: String, expectedId:  Int) {
        val actualId = Shadows.shadowOf(this).createdFromResId
        assertTrue(errorMessage, expectedId == actualId)
    }

    fun List<Int>.clickSongSelectorListItems(listView: RecyclerView, caseDescription: String = ""): Int {
        val timeBefore = SystemClock.currentGnssTimeClock().millis()

        val maxIndex = max(this)

        assertNotNull("Your recycler view adapter should not be null", listView.adapter)

        val expectedMinSize = maxIndex + 1

        val actualSize = listView.adapter!!.itemCount
        assertTrue(
            "RecyclerView was expected to contain item with index $maxIndex, but its size was $actualSize",
            actualSize >= expectedMinSize
        )

        if(actualSize >= expectedMinSize) {

            val maxItemWidth = (0 until expectedMinSize)
                .asSequence()
                .mapNotNull { listView.findViewHolderForAdapterPosition(it)?.itemView?.width }
                .maxOrNull()
                ?: throw AssertionError("$caseDescription No item is being displayed on RecyclerView, is it big enough to display one item?")
            val listWidth = maxItemWidth * (actualSize + 1)

            val maxItemHeight = (0 until actualSize)
                .asSequence()
                .mapNotNull { listView.findViewHolderForAdapterPosition(it)?.itemView?.height }
                .maxOrNull()
                ?: throw AssertionError("$caseDescription No item is being displayed on RecyclerView, is it big enough to display one item?")
            val listHeight = maxItemHeight * (actualSize + 1)
            listView.layout(0,0, listHeight, listWidth)  // may increase clock time

            this.forEach { i ->
                // setting height to ensure that all items are inflated

                listView.layout(0,0, listWidth, listHeight)
                listView.scrollToPosition(i)
                shadowLooper.idleFor(5, TimeUnit.MILLISECONDS)

                var itemView = listView.findViewHolderForAdapterPosition(i)?.itemView
                    ?: throw AssertionError("$caseDescription Could not find list item with index $i")

                var checkBox =
                    itemView.findViewByString<CheckBox>(ID_SONG_SELECTOR_ITEM_CHECKBOX)

                assertEquals(
                    "$ID_SONG_SELECTOR_ITEM_CHECKBOX should not be checked after clicks on mainMenuItemIdAddPlaylist",
                    false,
                    checkBox.isChecked
                )

                itemView.clickAndRun(5)

                itemView = listView.findViewHolderForAdapterPosition(i)!!.itemView
                checkBox = itemView.findViewByString<CheckBox>(ID_SONG_SELECTOR_ITEM_CHECKBOX)

                assertEquals(
                    "$ID_SONG_SELECTOR_ITEM_CHECKBOX should be checked after clicks on the list item",
                    true,
                    checkBox.isChecked
                )

                itemView.assertBackgroundColor(
                    "SongSelector list items should change color to Color.LTGRAY when item is selected",
                    Color.LTGRAY
                )
            }

            val timeAfter = SystemClock.currentGnssTimeClock().millis()
            return (timeAfter - timeBefore).toInt()

        } else {
            throw IllegalStateException("size assertion was not effective")
        }
    }

    fun assertViewStateIsPlayMusicState(
        songList: RecyclerView,
        fragmentContainer: FragmentContainerView,
        caseDescription: String = ""
    ) {

        songList.assertSingleListItem(0){ itemView ->
            itemView().findViewByStringOrNull<ImageButton>(ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE)
                ?: throw AssertionError("$caseDescription could not find $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE")
        }
        fragmentContainer.findViewByStringOrNull<Button>(ID_CONTROLLER_BTN_PLAY_PAUSE)
            ?: throw AssertionError("$caseDescription could not find $ID_CONTROLLER_BTN_PLAY_PAUSE")
    }

    fun addPlaylist(
        playlistName: String,
        selectedItemsIndex: List<Int>,
        songListView: RecyclerView,
        fragmentContainer: FragmentContainerView,
        testEmptyName: Boolean = false
    ): Int {
        val timeBefore = SystemClock.currentGnssTimeClock().millis()
        selectedItemsIndex.clickSongSelectorListItems(songListView) // might or might not increase clock time

        val addPlaylistButtonOk =
            fragmentContainer.findViewByString<Button>(ID_ADD_PLAYLIST_BTN_OK)

        if(testEmptyName) {
            addPlaylistButtonOk.clickAndRun(0) // might or might not increase clock time

            assertLastToastMessageEquals(
                errorMessage = "When $ID_ADD_PLAYLIST_ET_PLAYLIST_NAME is empty a toast message is expected after " +
                        "click on $ID_ADD_PLAYLIST_BTN_OK",
                expectedMessage = "Add a name to your playlist"
            )
        }

        val addPlaylistEtPlaylistName =
            fragmentContainer.findViewByString<EditText>(ID_ADD_PLAYLIST_ET_PLAYLIST_NAME)
        addPlaylistEtPlaylistName.setText(playlistName)

        addPlaylistButtonOk.clickAndRun(0) // might or might not increase clock time
        assertViewStateIsPlayMusicState(songListView, fragmentContainer,
            "After clicking $ID_ADD_PLAYLIST_BTN_OK to add playlist $playlistName " +
                    "expected to navigate to PLAY_MUSIC state"
        )
        val timeAfter = SystemClock.currentGnssTimeClock().millis()
        return (timeAfter - timeBefore).toInt()
    }

    fun loadPlaylist(menuItemIdLoadPlaylist: String, expectedPlaylistNameList: List<String>, playlistToLoadIndex: Int): Int {
        val timeBefore = SystemClock.currentGnssTimeClock().millis()
        activity.clickMenuItemAndRun(menuItemIdLoadPlaylist) // might or might not increase clock time

        getLastAlertDialogWithShadow(
            "An AlertDialog should be displayed after click on mainMenuItemLoadPlaylist"
        ).also { (dialog, shadowDialog) ->
            val dialogItems = shadowDialog.items.map { it.toString() }

            assertEquals("Wrong list displayed on AlertDialog after click on mainMenuItemLoadPlaylist",
                expectedPlaylistNameList,
                dialogItems
            )
            shadowDialog.clickAndRunOnItem(playlistToLoadIndex, millis = 0) // might or might not increase clock time
        }
        val timeAfter = SystemClock.currentGnssTimeClock().millis()
        return (timeAfter - timeBefore).toInt()
    }

    fun adjustPlayerPositionToAvoidSyncIssues(): Int {
        // tests can have sync problems with solutions depending on which position the player is paused
        // to avoid issues we adjust player position before pausing if the player position can be in inconvenient position
        // this is only needed if playingTime had some change without hardcoded values

        val syncAdjustment = 1000 - (player.currentPosition % 1000) + 200
        shadowLooper.idleFor(Duration.ofMillis(syncAdjustment.toLong()))
        return syncAdjustment
    }
}