package org.hyperskill.musicplayer

import android.Manifest
import android.app.AlertDialog
import android.graphics.Color
import android.widget.*
import org.hyperskill.musicplayer.internals.AddPlaylistScreen
import org.hyperskill.musicplayer.internals.AddPlaylistScreen.Companion.ID_ADD_PLAYLIST_BTN_OK
import org.hyperskill.musicplayer.internals.AddPlaylistScreen.Companion.ID_SONG_SELECTOR_ITEM_CHECKBOX
import org.hyperskill.musicplayer.internals.CustomMediaPlayerShadow
import org.hyperskill.musicplayer.internals.CustomShadowAsyncDifferConfig
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.ID_MAIN_BUTTON_SEARCH
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.mainMenuItemIdAddPlaylist
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.mainMenuItemIdDeletePlaylist
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.mainMenuItemIdLoadPlaylist
import org.hyperskill.musicplayer.internals.MusicPlayerUnitTests
import org.hyperskill.musicplayer.internals.PlayMusicScreen
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_CONTROLLER_BTN_PLAY_PAUSE
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_CONTROLLER_BTN_STOP
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE
import org.hyperskill.musicplayer.ui.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.concurrent.TimeUnit

// version 2.0
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Config(shadows = [CustomMediaPlayerShadow::class, CustomShadowAsyncDifferConfig::class])
@RunWith(RobolectricTestRunner::class)
class Stage2UnitTest : MusicPlayerUnitTests<MainActivity>(MainActivity::class.java){

    @Before
    fun setUp() {
        setupContentProvider(songFakeList)
        shadowActivity.grantPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
        CustomMediaPlayerShadow.setFakeSong(songFakeList[0])
        CustomMediaPlayerShadow.acceptRawWisdom = true
    }


    @Test
    fun test00_checkSongListAfterInitialClickOnSearch() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            mainSongList.assertListItems(
                songFakeList,
                "on init after clicking on $ID_MAIN_BUTTON_SEARCH"
            ) { itemViewSupplier, _, songFake ->
                val itemView = itemViewSupplier()
                assertSongItem("Wrong data after search.", itemView, songFake)

                val songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemView)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "When a song from the song list is stopped " +
                            "the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should be R.drawable.ic_play",
                    R.drawable.ic_play
                )
            }
        }
        Unit
    }

    @Test
    fun test01_checkSongListItemChangesImageOnImageButtonClick() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            val songFakeIndex = 3
            CustomMediaPlayerShadow.setFakeSong(songFakeList[songFakeIndex])

            mainSongList.assertSingleListItem(
                songFakeIndex,
                "on init after clicking on $ID_MAIN_BUTTON_SEARCH"
            ) { itemViewSupplier ->
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "When a song from the song list is stopped " +
                            "the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should be R.drawable.ic_play",
                    R.drawable.ic_play
                )

                songItemImgBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a stopped song " +
                            "the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )

                songItemImgBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a playing song " +
                            "the image displayed should change to R.drawable.ic_play",
                    R.drawable.ic_play
                )
            }
        }
        Unit
    }

    @Test
    fun test02_checkWhenCurrentTrackChangesAndOldCurrentTrackIsPlayingImageChangesToPaused()  = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            val songFakeIndexBefore = 5
            val songFakeIndexAfter = 7

            CustomMediaPlayerShadow.setFakeSong(songFakeList[songFakeIndexBefore])
            mainSongList.assertSingleListItem(songFakeIndexBefore) { itemViewSupplierBefore ->
                var songItemImgBtnPlayPauseBefore =
                    songItemImgBtnPlayPauseSupplier(itemViewSupplierBefore)
                songItemImgBtnPlayPauseBefore.drawable.assertCreatedFromResourceId(
                    "When a song from the song list is stopped " +
                            "the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should be R.drawable.ic_play",
                    R.drawable.ic_play
                )

                songItemImgBtnPlayPauseBefore.clickAndRun()
                songItemImgBtnPlayPauseBefore =
                    songItemImgBtnPlayPauseSupplier(itemViewSupplierBefore)

                songItemImgBtnPlayPauseBefore.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a stopped song" +
                            " the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )

                CustomMediaPlayerShadow.setFakeSong(songFakeList[songFakeIndexAfter])
                shadowLooper.idleFor(10_000L, TimeUnit.MILLISECONDS)
                mainSongList.assertSingleListItem(songFakeIndexAfter) { itemViewSupplierAfter ->
                    var songItemImgBtnPlayPauseAfter =
                        songItemImgBtnPlayPauseSupplier(itemViewSupplierAfter)
                    songItemImgBtnPlayPauseAfter.drawable.assertCreatedFromResourceId(
                        "When a song from the song list is stopped " +
                                "the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should be R.drawable.ic_play",
                        R.drawable.ic_play
                    )

                    songItemImgBtnPlayPauseAfter.clickAndRun()
                    songItemImgBtnPlayPauseAfter =
                        songItemImgBtnPlayPauseSupplier(itemViewSupplierAfter)

                    songItemImgBtnPlayPauseAfter.drawable.assertCreatedFromResourceId(
                        "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a paused song " +
                                "the image displayed should change to R.drawable.ic_pause",
                        R.drawable.ic_pause
                    )

                }
                songItemImgBtnPlayPauseBefore =
                    songItemImgBtnPlayPauseSupplier(itemViewSupplierBefore)

                songItemImgBtnPlayPauseBefore.drawable.assertCreatedFromResourceId(
                    "After changing the currentTrack with the old currentTrack playing" +
                            "the image displayed on the old currentTrack should change to R.drawable.ic_play",
                    R.drawable.ic_play
                )
            }
        }
        Unit
    }


    @Test
    fun test03_checkWhenCurrentTrackChangesAndOldCurrentTrackIsNotPlayingImageRemains() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            val songFakeIndexBefore = 5
            val songFakeIndexAfter = 7

            CustomMediaPlayerShadow.setFakeSong(songFakeList[songFakeIndexBefore])
            mainSongList.assertSingleListItem(songFakeIndexBefore) { itemViewSupplierBefore ->
                var songItemImgBtnPlayPauseBefore =
                    songItemImgBtnPlayPauseSupplier(itemViewSupplierBefore)

                songItemImgBtnPlayPauseBefore.drawable.assertCreatedFromResourceId(
                    "When a song from the song list is paused the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE " +
                            "should be R.drawable.ic_play",
                    R.drawable.ic_play
                )

                songItemImgBtnPlayPauseBefore.clickAndRun()
                songItemImgBtnPlayPauseBefore =
                    songItemImgBtnPlayPauseSupplier(itemViewSupplierBefore)

                songItemImgBtnPlayPauseBefore.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a paused song " +
                            "the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )

                songItemImgBtnPlayPauseBefore.clickAndRun()
                songItemImgBtnPlayPauseBefore =
                    songItemImgBtnPlayPauseSupplier(itemViewSupplierBefore)

                songItemImgBtnPlayPauseBefore.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a playing song " +
                            "the image displayed should change to R.drawable.ic_play",
                    R.drawable.ic_play
                )

                CustomMediaPlayerShadow.setFakeSong(songFakeList[songFakeIndexAfter])
                mainSongList.assertSingleListItem(songFakeIndexAfter) { itemViewSupplierAfter ->
                    var songItemImgBtnPlayPauseAfter =
                        songItemImgBtnPlayPauseSupplier(itemViewSupplierAfter)

                    songItemImgBtnPlayPauseAfter.drawable.assertCreatedFromResourceId(
                        "When a song from the song list is paused " +
                                "the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should be R.drawable.ic_play",
                        R.drawable.ic_play
                    )

                    songItemImgBtnPlayPauseAfter.clickAndRun()
                    songItemImgBtnPlayPauseAfter =
                        songItemImgBtnPlayPauseSupplier(itemViewSupplierAfter)

                    songItemImgBtnPlayPauseAfter.drawable.assertCreatedFromResourceId(
                        "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a paused song " +
                                "the image displayed should change to R.drawable.ic_pause",
                        R.drawable.ic_pause
                    )
                }

                songItemImgBtnPlayPauseBefore =
                    songItemImgBtnPlayPauseSupplier(itemViewSupplierBefore)
                songItemImgBtnPlayPauseBefore.drawable.assertCreatedFromResourceId(
                    "After changing the currentTrack with the old currentTrack not playing " +
                            "the image displayed should remain being R.drawable.ic_play",
                    R.drawable.ic_play
                )
            }
        }
        Unit
    }

    @Test
    fun test04_checkAfterInitialSearchFirstListItemIsCurrentTrackAndRespondToControllerPlayPauseButton() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            mainSongList.assertSingleListItem(0) { itemViewSupplier ->

                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "When a song from the song list is paused " +
                            "the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should be R.drawable.ic_play",
                    R.drawable.ic_play
                )

                songItemImgBtnPlayPause.clickAndRun()

                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a paused song" +
                            " the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )

                controllerBtnPlayPause.clickAndRun()

                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a playing song" +
                            " the image displayed should change to R.drawable.ic_play",
                    R.drawable.ic_play
                )
            }
        }
        Unit
    }

    @Test
    fun test05_checkCurrentTrackImgChangeAfterControllerStopButtonClickWithCurrentTrackPlaying() = testActivity {
        PlayMusicScreen(this).apply {
            val songFakeIndex = 4
            mainButtonSearch.clickAndRun()

            CustomMediaPlayerShadow.setFakeSong(songFakeList[songFakeIndex])
            mainSongList.assertSingleListItem(songFakeIndex) { itemViewSupplier ->

                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)


                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "When a song from the song list is stopped " +
                            "the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should be R.drawable.ic_play",
                    R.drawable.ic_play
                )

                songItemImgBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a stopped song " +
                            "the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )

                controllerBtnStop.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_CONTROLLER_BTN_STOP on a playing song " +
                            "the image displayed should change to R.drawable.ic_play",
                    R.drawable.ic_play
                )

                songItemImgBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a stopped song " +
                            "the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )

                songItemImgBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a playing song" +
                            "the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should change to R.drawable.ic_play",
                    R.drawable.ic_play
                )

                controllerBtnStop.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_CONTROLLER_BTN_STOP on a paused song " +
                            "the image displayed should remain R.drawable.ic_play",
                    R.drawable.ic_play
                )

                controllerBtnStop.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_CONTROLLER_BTN_STOP on a stopped song " +
                            "the image displayed should remain R.drawable.ic_play",
                    R.drawable.ic_play
                )
            }
        }
        Unit
    }

    @Test
    fun test06_checkListItemImgChangeMixedClicks() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch
            mainFragmentContainer

            val songFakeIndex = 6

            mainButtonSearch.clickAndRun()

            CustomMediaPlayerShadow.setFakeSong(songFakeList[songFakeIndex])
            mainSongList.assertSingleListItem(songFakeIndex) { itemViewSupplier ->

                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                for (i in 1..10) {
                    /*
                        1 - paused -> songItemImgBtnPlayPause -> playing
                        2 - playing -> controllerBtnPlayPause -> paused
                        3 - paused -> controllerBtnPlayPause -> playing
                        4 - playing -> songItemImgBtnPlayPause -> paused
                        5 - paused -> controllerBtnPlayPause -> playing
                        6 - playing -> controllerBtnStop -> paused
                        7 - paused -> songItemImgBtnPlayPause -> playing
                        8 - playing -> controllerBtnPlayPause -> paused
                        9 - paused -> controllerBtnPlayPause -> playing
                        10 - playing -> songItemImgBtnPlayPause -> paused
                     */

                    val buttonClickedId = if (i == 6) {
                        controllerBtnStop.clickAndRun()
                        songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "After clicking on $ID_CONTROLLER_BTN_STOP on a playing song the image displayed should change to R.drawable.ic_play",
                            R.drawable.ic_play
                        )
                        continue
                    } else if (i % 3 == 1) {
                        songItemImgBtnPlayPause.clickAndRun()
                        songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                        ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE
                    } else {
                        controllerBtnPlayPause.clickAndRun()
                        songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                        ID_CONTROLLER_BTN_PLAY_PAUSE
                    }

                    if (i % 2 == 1) {
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "After clicking on $buttonClickedId on a paused song the image displayed should change to R.drawable.ic_pause",
                            R.drawable.ic_pause
                        )
                    } else {
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "After clicking on $buttonClickedId on a playing song the image displayed should change to R.drawable.ic_play",
                            R.drawable.ic_play
                        )
                    }
                }
            }
        }
        Unit
    }

    @Test
    fun test07_checkAddPlaylistStateTriggeredByMenuItem() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            val caseDescription = "On addPlaylist after clicking $mainMenuItemIdAddPlaylist"
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, song ->
                SongSelectorItemBindings(itemViewSupplier).apply {
                    assertSongSelectorInfo(
                        caseDescription,
                        song
                    )
                    assertEquals(
                        "No $ID_SONG_SELECTOR_ITEM_CHECKBOX " +
                                "should be checked after click on $mainMenuItemIdAddPlaylist",
                        false,
                        songSelectorItemCheckBox.isChecked
                    )
                    itemView.assertBackgroundColor(
                        errorMessage = "The backgroundColor for all songSelectorItems " +
                                "should be Color.WHITE after click on $mainMenuItemIdAddPlaylist",
                        expectedBackgroundColor = Color.WHITE
                    )
                }
                //
            }
        }
        Unit
    }

    @Test
    fun test08_checkAddingPlaylistWithEmptyListAddedToastErrorEmptyListMessage() = testActivity {
        val playlistName = "My Playlist"
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylistEtPlaylistName.setText(playlistName)
            addPlaylistButtonOk.clickAndRun()
            assertLastToastMessageEquals(
                errorMessage = "When there is no song selected a toast message is expected after click on $ID_ADD_PLAYLIST_BTN_OK",
                expectedMessage = "Add at least one song to your playlist"
            )
        }
        Unit
    }

    @Test
    fun test09_checkAddingPlaylistWithBothEmptyListAndEmptyPlaylistNameToastErrorEmptyListMessage() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch
            mainSongList

            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylistButtonOk.clickAndRun()
            assertLastToastMessageEquals(
                errorMessage = "When there is no song selected a toast message is expected after click on $ID_ADD_PLAYLIST_BTN_OK",
                expectedMessage = "Add at least one song to your playlist"
            )
        }
        Unit
    }

    @Test
    fun test10_checkAddingPlaylistWithReservedPlaylistNameAllSongsToastErrorReservedNameMessage() = testActivity {
        val playlistName = "All Songs"

        PlayMusicScreen(this).apply {
            mainButtonSearch
            mainSongList

            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            mainSongList.assertSingleListItem(0) {
                it().clickAndRun()
            }
            addPlaylistEtPlaylistName.setText(playlistName)
            addPlaylistButtonOk.clickAndRun()
            assertLastToastMessageEquals(
                errorMessage = "All Songs should be a reserved name. A toast was expected with message",
                expectedMessage = "All Songs is a reserved name choose another playlist name"
            )
        }
        Unit
    }

    @Test
    fun test11_checkLoadPlaylistInPlayMusicStateAfterAddingPlaylistWithMainMenuItem() = testActivity {
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val testedItemsOneBasedIndexes = listOf(2, 4, 7)
        val playlistName = "My Playlist"

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = testedItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
                testEmptyName = true
            )
        }
        PlayMusicScreen(this).apply {
            CustomMediaPlayerShadow.setFakeSong(songFakeList[testedItemsZeroBasedIndexes[0]])
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )

            val playlistSongFake = songFakeList.filter { it.id in testedItemsOneBasedIndexes }
            val caseDescription = "On PLAY_MUSIC state after playlist $playlistName is loaded."
            mainSongList.assertListItems(playlistSongFake, caseDescription) { itemViewSupplier, _, song ->

                assertSongItem(
                    "$caseDescription Wrong list item.",
                    itemViewSupplier(),
                    song
                )
                CustomMediaPlayerShadow.setFakeSong(song)

                // check image changes after playlist loaded
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "When a song from the song list is paused the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should be R.drawable.ic_play",
                    R.drawable.ic_play
                )

                songItemImgBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a paused song the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )


                controllerBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_CONTROLLER_BTN_PLAY_PAUSE on a playing song the image displayed should change to R.drawable.ic_play",
                    R.drawable.ic_play
                )

                controllerBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_CONTROLLER_BTN_PLAY_PAUSE on a paused song the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )

                controllerBtnStop.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_CONTROLLER_BTN_STOP on a playing song the image displayed should change to R.drawable.ic_play",
                    R.drawable.ic_play
                )
            }
        }
        Unit
    }

    @Test
    fun test12_checkLoadPlaylistInPlayMusicStateAfterAddingPlaylistWithLongClick() = testActivity {
        val testedItemsZeroBasedIndexes = listOf(4, 7, 8)
        val testedItemsOneBasedIndexes = testedItemsZeroBasedIndexes.map { it + 1 }
        val longClickItemZeroBasedIndex = 5
        val longClickItemOneBasedIndex = longClickItemZeroBasedIndex + 1
        val playlistName = "My Playlist"

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            mainSongList.assertSingleListItem(longClickItemZeroBasedIndex) {
                it().clickLongAndRun()
            }
        }

        AddPlaylistScreen(this).apply {
            // check long click item is checked and deselect item
            val caseDescription = "After long click on item with index $longClickItemZeroBasedIndex"
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, item ->
                when (item.id) {
                    longClickItemOneBasedIndex -> {
                        SongSelectorItemBindings(itemViewSupplier).apply {
                            assertEquals(
                                "On the item that received a long click $ID_SONG_SELECTOR_ITEM_CHECKBOX should be check.",
                                true,
                                songSelectorItemCheckBox.isChecked
                            )
                            itemView.assertBackgroundColor(
                                "On the item that received a long click background color should be Color.LT_GRAY.",
                                Color.LTGRAY
                            )
                            itemView.clickAndRun()  // deselect
                        }
                    }

                    else -> {}
                }
            }
            //
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = testedItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
                testEmptyName = true
            )
        }
        PlayMusicScreen(this).apply {
            CustomMediaPlayerShadow.setFakeSong(songFakeList[testedItemsZeroBasedIndexes.first()])
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )

            val playlistSongFake = songFakeList.filter { it.id in testedItemsOneBasedIndexes }
            val caseDescription = "On PLAY_MUSIC state after playlist $playlistName is loaded."
            mainSongList.assertListItems(playlistSongFake, caseDescription) { itemViewSupplier, _, song ->
                assertSongItem(
                    "$caseDescription Wrong list item.",
                    itemViewSupplier(),
                    song
                )
                CustomMediaPlayerShadow.setFakeSong(song)

                // check image changes after load
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "When a song from the song list is paused the image of $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE should be R.drawable.ic_play",
                    R.drawable.ic_play
                )

                songItemImgBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a paused song the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )

                controllerBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_CONTROLLER_BTN_PLAY_PAUSE on a playing song the image displayed should change to R.drawable.ic_play",
                    R.drawable.ic_play
                )

                controllerBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_CONTROLLER_BTN_PLAY_PAUSE on a paused song the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )

                controllerBtnStop.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_CONTROLLER_BTN_STOP on a playing song the image displayed should change to R.drawable.ic_play",
                    R.drawable.ic_play
                )
                //
            }
        }
        Unit
    }

    @Test
    fun test13_checkLoadPlaylistOnPlayMusicStateWithCurrentTrackKeepsCurrentTrack() = testActivity {
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val selectedSongZeroIndex = testedItemsZeroBasedIndexes[1]
        val playlistName = "My Playlist"

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            CustomMediaPlayerShadow.setFakeSong(songFakeList[selectedSongZeroIndex])
            mainSongList.assertSingleListItem(selectedSongZeroIndex) { itemViewSupplier ->
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )
            }

            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = testedItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer
            )
        }
        PlayMusicScreen(this).apply {

            // check item keeps selected state after list add
            val caseDescription = "On PLAY_MUSIC state after adding a playlist with name $playlistName"
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, item ->
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                if (item.id == selectedSongZeroIndex + 1) {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The selected song should remain selected after adding a playlist",
                        R.drawable.ic_pause
                    )

                    controllerBtnPlayPause.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The selected song should remain responding to $ID_CONTROLLER_BTN_PLAY_PAUSE clicks after adding a playlist",
                        R.drawable.ic_play
                    )

                    songItemImgBtnPlayPause.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The selected song should remain responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after adding a playlist",
                        R.drawable.ic_pause
                    )

                    controllerBtnStop.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The selected song should remain responding to $ID_CONTROLLER_BTN_STOP clicks after adding a playlist",
                        R.drawable.ic_play
                    )

                    songItemImgBtnPlayPause.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The selected song should remain responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after adding a playlist",
                        R.drawable.ic_pause
                    )

                } else {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "A unselected song should remain unselected after adding a playlist",
                        R.drawable.ic_play
                    )
                }
            }
            //

            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )

            // check item keeps selected state after list load
            val caseDescription2 = "On PLAY_MUSIC state after playlist $playlistName is loaded."
            mainSongList.assertListItems(
                testedItemsZeroBasedIndexes.map { songFakeList[it] }, caseDescription2
            ) { itemViewSupplier, _, item ->
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                if (item.id == selectedSongZeroIndex + 1) {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The selected song should remain selected after loading a playlist",
                        R.drawable.ic_pause
                    )

                    controllerBtnPlayPause.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The selected song should remain responding to $ID_CONTROLLER_BTN_PLAY_PAUSE clicks after loading a playlist",
                        R.drawable.ic_play
                    )

                    songItemImgBtnPlayPause.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The selected song should remain responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after loading a playlist",
                        R.drawable.ic_pause
                    )

                    controllerBtnStop.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The selected song should remain responding to $ID_CONTROLLER_BTN_STOP clicks after loading a playlist",
                        R.drawable.ic_play
                    )

                    songItemImgBtnPlayPause.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The selected song should remain responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after loading a playlist",
                        R.drawable.ic_pause
                    )

                } else {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "A unselected song should remain unselected after loading a playlist",
                        R.drawable.ic_play
                    )
                }
            }
            //
        }
        Unit
    }

    @Test
    fun test14_checkLoadPlaylistOnPlayMusicStateWithoutCurrentTrackChangesCurrentTrack() {

        testActivity {
            val playlistName = "muZics"
            val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
            val selectedSongZeroIndex = 8

            PlayMusicScreen(this).apply {
                mainButtonSearch.clickAndRun()
                CustomMediaPlayerShadow.setFakeSong(songFakeList[selectedSongZeroIndex])
                mainSongList.assertSingleListItem(selectedSongZeroIndex) { itemViewSupplier ->
                    var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                    songItemImgBtnPlayPause.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE the image displayed should change to R.drawable.ic_pause",
                        R.drawable.ic_pause
                    )
                }

                activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
            }
            AddPlaylistScreen(this).apply {
                addPlaylist(
                    playlistName = playlistName,
                    selectedItemsIndex = testedItemsZeroBasedIndexes,
                    songListView = mainSongList,
                    fragmentContainer = mainFragmentContainer
                )
            }
            PlayMusicScreen(this).apply {
                val caseDescription = "On PLAY_MUSIC state after adding a playlist with name $playlistName"
                // check item keeps selected state after list add
                mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, item ->
                    var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                    if (item.id == selectedSongZeroIndex + 1) {
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "The selected song should remain selected after adding a playlist",
                            R.drawable.ic_pause
                        )

                        controllerBtnPlayPause.clickAndRun()
                        songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "The selected song should remain responding to $ID_CONTROLLER_BTN_PLAY_PAUSE clicks after adding a playlist",
                            R.drawable.ic_play
                        )

                        songItemImgBtnPlayPause.clickAndRun()
                        songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "The selected song should remain responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after adding a playlist",
                            R.drawable.ic_pause
                        )

                        controllerBtnStop.clickAndRun()
                        songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "The selected song should remain responding to $ID_CONTROLLER_BTN_STOP clicks after adding a playlist",
                            R.drawable.ic_play
                        )

                        songItemImgBtnPlayPause.clickAndRun()
                        songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "The selected song should remain responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after adding a playlist",
                            R.drawable.ic_pause
                        )

                    } else {
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "A unselected song should remain unselected after adding a playlist",
                            R.drawable.ic_play
                        )
                    }
                }
                //

                CustomMediaPlayerShadow.setFakeSong(songFakeList[testedItemsZeroBasedIndexes.first()])
                loadPlaylist(
                    menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                    expectedPlaylistNameList = listOf("All Songs", playlistName),
                    playlistToLoadIndex = 1
                )

                // check default item selected after list load
                val caseDescription2 = "On PLAY_MUSIC state after playlist $playlistName is loaded."
                mainSongList.assertListItems(
                    testedItemsZeroBasedIndexes.map { songFakeList[it] }, caseDescription2
                ) { itemViewSupplier, position, _ ->
                    var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                    if (position == 0) {
                        controllerBtnPlayPause.clickAndRun()
                        songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "The first song should be the currentTrack after loading a playlist " +
                                    "without the old currentTrack and respond to $ID_CONTROLLER_BTN_PLAY_PAUSE clicks",
                            R.drawable.ic_pause
                        )

                        controllerBtnStop.clickAndRun()
                        songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "The currentTrack should remain responding " +
                                    "to $ID_CONTROLLER_BTN_STOP clicks after loading a playlist",
                            R.drawable.ic_play
                        )

                        songItemImgBtnPlayPause.clickAndRun()
                        songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "The currentTrack should remain responding " +
                                    "to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after loading a playlist",
                            R.drawable.ic_pause
                        )

                    } else {
                        songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                            "A track that is not the currentTrack should remain not being the currentTrack",
                            R.drawable.ic_play
                        )
                    }
                }
                //
            }
        }
    }

    @Test
    fun test15_checkLoadPlaylistInAddPlaylistStateKeepsSelectedItemsById() {

        testActivity {
            val playlistAItemsZeroBasedIndexes = listOf(0, 3, 6, 7, 8, 9)
            val playlistAItemsOneBasedIndexes = playlistAItemsZeroBasedIndexes.map { it + 1 }
            val playlistBItemsZeroBasedIndexes =
                playlistAItemsZeroBasedIndexes.filter { it % 3 == 0 }
            val playlistBItemsOneBasedIndexes = playlistBItemsZeroBasedIndexes.map { it + 1 }
            val playlistName = "Weird Sounds"

            PlayMusicScreen(this).apply {
                mainButtonSearch.clickAndRun()
                activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
            }
            AddPlaylistScreen(this).apply {
                addPlaylist(
                    playlistName = playlistName,
                    selectedItemsIndex = playlistAItemsZeroBasedIndexes,
                    songListView = mainSongList,
                    fragmentContainer = mainFragmentContainer,
                )
            }
            PlayMusicScreen(this).apply {
                activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
            }

            AddPlaylistScreen(this).apply {
                // check default playlist "All Songs" in ADD_PLAYLIST state and select items
                val caseDescription = "On ADD_PLAYLIST state after playlist $playlistName was added and $mainMenuItemIdAddPlaylist was clicked."
                mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, item ->
                    var songSelectorItemBindings = SongSelectorItemBindings(itemViewSupplier)
                    assertEquals(
                        "No songSelectorItemCheckBox should be checked after click on mainMenuItemIdAddPlaylist",
                        false,
                        songSelectorItemBindings.songSelectorItemCheckBox.isChecked
                    )

                    if (item.id in playlistBItemsOneBasedIndexes) {
                        songSelectorItemBindings.itemView.clickAndRun()
                        songSelectorItemBindings = SongSelectorItemBindings(itemViewSupplier)

                        assertEquals(
                            "$ID_SONG_SELECTOR_ITEM_CHECKBOX should be checked after click on list item",
                            true,
                            songSelectorItemBindings.songSelectorItemCheckBox.isChecked
                        )
                    }
                }
                //

                loadPlaylist(
                    menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                    expectedPlaylistNameList = listOf("All Songs", playlistName),
                    playlistToLoadIndex = 1
                )

                // check loaded playlist in ADD_PLAYLIST state keeps selected items
                val caseDescription2 = "On ADD_PLAYLIST state after playlist $playlistName is loaded."
                mainSongList.assertListItems(
                    songFakeList.filter { it.id in playlistAItemsOneBasedIndexes },
                    caseDescription2
                ) { itemViewSupplier, _, item ->

                    val checkBox =
                        itemViewSupplier().findViewByString<CheckBox>("songSelectorItemCheckBox")

                    if (item.id in playlistBItemsOneBasedIndexes) {
                        assertEquals(
                            "songSelectorItemCheckBox should remain isChecked value" +
                                    " after list loaded on ADD_PLAYLIST state",
                            true,
                            checkBox.isChecked
                        )
                    } else {
                        assertEquals(
                            "songSelectorItemCheckBox should remain isChecked value" +
                                    " after list loaded on ADD_PLAYLIST state",
                            false,
                            checkBox.isChecked
                        )
                    }
                }
                //
            }
        }
    }

    @Test
    fun test16_checkLoadPlaylistInAddPlaylistStateKeepsCurrentTrackWhenReturningToPlayMusicState() = testActivity {
        val playlistItemsZeroBasedIndexes = listOf(0, 3, 6, 7, 8, 9)
        val selectedItem = 1
        val playlistName = "Party Songs"

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            CustomMediaPlayerShadow.setFakeSong(songFakeList[selectedItem])
            mainSongList.assertSingleListItem(selectedItem) { itemViewSupplier ->
                songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    .clickAndRun()
            }

            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = playlistItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
            )
        }
        PlayMusicScreen(this).apply {
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )
            addPlaylistBtnCancel.clickAndRun()
        }
        PlayMusicScreen(this).apply {
            val caseDescription = "The currentPlaylist in PLAY_MUSIC state should not change " +
                    "after loading a playlist in ADD_PLAYLIST state"
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, position, song ->
                assertSongItem(
                    caseDescription,
                    itemViewSupplier(), song
                )
                val songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                if (position == selectedItem) {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The currentTrack should keep its playing state " +
                                "after loading a playlist on ADD_PLAYLIST state and returning to PLAY_MUSIC state",
                        R.drawable.ic_pause
                    )
                } else {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "A track that is not the currentTrack should not be playing",
                        R.drawable.ic_play
                    )
                }
            }
        }
        Unit
    }

    @Test
    fun test17_checkPlaylistSavedAfterSelectingSongsAfterLoadingPlaylistInAddPlaylistState() = testActivity {
        val playlistOne = listOf(1, 2, 3)
        val selectItemsOne = listOf(0, 1)
        val selectItemsTwo = listOf(2, 3)
        val playlistName1 = "playlist1"
        val playlistName2 = "playlist2"
        val loadPlaylistOneSongs = songFakeList.filter { it.id - 1 in playlistOne }

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName1,
                selectedItemsIndex = playlistOne,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer
            )
        }
        PlayMusicScreen(this).apply {
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            val caseDescription = "On ADD_PLAYLIST state after playlist $playlistName1 was added and $mainMenuItemIdAddPlaylist was clicked."
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, item ->
                if (item.id - 1 in selectItemsOne) {
                    itemViewSupplier().clickAndRun()
                }
            }
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName1),
                playlistToLoadIndex = 1
            )
            val caseDescription2 = "On ADD_PLAYLIST state after playlist $playlistName1 was loaded."
            mainSongList.assertListItems(loadPlaylistOneSongs, caseDescription2) { itemViewSupplier, _, item ->
                if (item.id - 1 in selectItemsTwo) {
                    itemViewSupplier().clickAndRun()
                }
            }
            addPlaylistEtPlaylistName.setText(playlistName2)
            addPlaylistButtonOk.clickAndRun()
        }
        PlayMusicScreen(this).apply {
            CustomMediaPlayerShadow.setFakeSong(songFakeList[playlistOne.first()])
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName1, playlistName2),
                playlistToLoadIndex = 2
            )
            val messageItemsSaved =
                "The playlist saved should contain the selected items when clicking addPlaylistBtnOk"
            val caseDescription = "On PLAY_MUSIC state after playlist $playlistName2 is loaded."
            mainSongList.assertListItems(loadPlaylistOneSongs, caseDescription) { itemViewSupplier, _, song ->
                assertSongItem(messageItemsSaved, itemViewSupplier(), song)
            }
        }
        Unit
    }

    @Test
    fun test18_checkCancellingAddPlaylistKeepsCurrentPlaylist() = testActivity {
        val playlistAItemsZeroBasedIndexes = listOf(3, 7, 8)
        val playlistAItemsOneBasedIndexes = playlistAItemsZeroBasedIndexes.map { it + 1 }
        val playlistName = "Cool Songs"
        val playlistSongFake =
            songFakeList.filter { it.id in playlistAItemsOneBasedIndexes }

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = playlistAItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
                testEmptyName = true
            )
        }
        PlayMusicScreen(this).apply {
            CustomMediaPlayerShadow.setFakeSong(songFakeList[playlistAItemsZeroBasedIndexes[0]])
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )

            // check loaded items
            val caseDescription = "On PLAY_MUSIC state after playlist $playlistName is loaded."
            mainSongList.assertListItems(playlistSongFake, caseDescription) { itemViewSupplier, _, song ->
                assertSongItem(
                    "$caseDescription Wrong list item.",
                    itemViewSupplier(),
                    song
                )
            }
            //
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylistBtnCancel.clickAndRun()
        }
        PlayMusicScreen(this).apply {

            // check loaded items remains
            val caseDescription = "On PLAY_MUSIC state after playlist $playlistName is loaded and a new playlist addition was canceled."
            mainSongList.assertListItems(playlistSongFake, caseDescription) { itemViewSupplier, _, item ->
                val messageWrongListItemAfterCancel =
                    "$caseDescription Playlist loaded should remain after addPlaylistBtnCancel clicked"
                assertSongItem(messageWrongListItemAfterCancel, itemViewSupplier(), item)
            }
            //
        }
        Unit
    }

    @Test
    fun test19_checkCancelingAddPlaylistKeepsCurrentTrackPlayingState() = testActivity {
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val selectedSongZeroIndex = testedItemsZeroBasedIndexes[1]

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            CustomMediaPlayerShadow.setFakeSong(songFakeList[selectedSongZeroIndex])
            mainSongList.assertSingleListItem(selectedSongZeroIndex) { itemViewSupplier ->
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.clickAndRun()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "After clicking on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE " +
                            "the image displayed should change to R.drawable.ic_pause",
                    R.drawable.ic_pause
                )
            }

            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylistBtnCancel.clickAndRun()
        }
        PlayMusicScreen(this).apply {
            // check item keeps selected state after cancel add list
            val caseDescription = "On PLAY_MUSIC state new playlist addition was canceled."
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, item ->
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                if (item.id == selectedSongZeroIndex + 1) {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The currentTrack should remain being the currentTrack " +
                                "after canceling adding a playlist",
                        R.drawable.ic_pause
                    )
                    controllerBtnPlayPause.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The currentTrack should remain responding to $ID_CONTROLLER_BTN_PLAY_PAUSE clicks " +
                                "after canceling adding a playlist",
                        R.drawable.ic_play
                    )

                    songItemImgBtnPlayPause.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The currentTrack should remain responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks " +
                                "after canceling adding a playlist",
                        R.drawable.ic_pause
                    )

                    controllerBtnStop.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The currentTrack should remain responding to $ID_CONTROLLER_BTN_STOP clicks " +
                                "after canceling adding a playlist",
                        R.drawable.ic_play
                    )

                    songItemImgBtnPlayPause.clickAndRun()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "The currentTrack should remain responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks " +
                                "after canceling adding a playlist",
                        R.drawable.ic_pause
                    )

                } else {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "A track that is not the currentTrack should remain not being " +
                                "the currentTrack after canceling adding a playlist",
                        R.drawable.ic_play
                    )
                }
            }
            //
        }
        Unit
    }

    @Test
    fun test20_checkDeletePlaylistOnPlayMusicStateDeletingPlaylistThatIsNotCurrentPlaylist() = testActivity {
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val playlistName = "My Playlist"
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = testedItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer
            )
        }
        PlayMusicScreen(this).apply {
            // delete playlist
            activity.clickMenuItemAndRun(mainMenuItemIdDeletePlaylist)

            getLastAlertDialogWithShadow(
                "An AlertDialog should be displayed after click on mainMenuItemDeletePlaylist"
            ).also { (_, shadowDialog) ->
                val dialogItems = shadowDialog.items.map { it.toString() }

                assertEquals(
                    "Wrong list displayed on AlertDialog after click on mainMenuItemDeletePlaylist",
                    listOf(playlistName),
                    dialogItems
                )
                shadowDialog.clickAndRunOnItem(0)
            }
            //

            // check delete dialog don't display deleted playlist
            activity.clickMenuItemAndRun(mainMenuItemIdDeletePlaylist)

            getLastAlertDialogWithShadow(
                "An AlertDialog should be displayed after click on mainMenuItemDeletePlaylist"
            ).also { (dialog, shadowDialog) ->
                val dialogItems = shadowDialog.items.map { it.toString() }

                assertEquals(
                    "Wrong list displayed on AlertDialog after click on mainMenuItemDeletePlaylist",
                    listOf<String>(),
                    dialogItems
                )

                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).clickAndRun()
            }
            //

            // check load dialog don't display deleted playlist
            activity.clickMenuItemAndRun(mainMenuItemIdLoadPlaylist)

            getLastAlertDialogWithShadow(
                "An AlertDialog should be displayed after click on mainMenuItemLoadPlaylist"
            ).also { (dialog, shadowDialog) ->
                val dialogItems = shadowDialog.items.map { it.toString() }

                assertEquals(
                    "Wrong list displayed on AlertDialog after click on mainMenuItemLoadPlaylist",
                    listOf("All Songs"),
                    dialogItems
                )

                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).clickAndRun()
            }
            //

            //check currentPlaylist remains
            val caseDescription = "On PLAY_MUSIC state after playlist $playlistName is deleted."
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, song ->
                assertSongItem(
                    "$caseDescription Deleting a playlist that is not the currentPlaylist " +
                            "should not change the currentPlaylist",
                    itemViewSupplier(), song
                )
            }
        }
        Unit
    }

    @Test
    fun test21_checkDeletePlaylistOnPlayMusicStateWithCurrentPlaylistBeingDeleted() = testActivity {
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val testedItemsOneBasedIndexes = testedItemsZeroBasedIndexes.map { it + 1 }
        val playlistName = "zZz"

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = testedItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer
            )
        }
        PlayMusicScreen(this).apply {
            CustomMediaPlayerShadow.setFakeSong(songFakeList[testedItemsZeroBasedIndexes.first()])
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )

            // check loaded items
            val playlistSongFake = songFakeList.filter { it.id in testedItemsOneBasedIndexes }
            val caseDescription = "On PLAY_MUSIC state after playlist $playlistName is loaded."
            mainSongList.assertListItems(playlistSongFake, caseDescription) { itemViewSupplier, _, item ->
                val messageWrongListItemAfterPlaylistLoaded =
                    "$caseDescription Wrong list item after playlist loaded."
                assertSongItem(
                    messageWrongListItemAfterPlaylistLoaded,
                    itemViewSupplier(),
                    item
                )
            }
            //

            // delete playlist
            activity.clickMenuItemAndRun(mainMenuItemIdDeletePlaylist)

            getLastAlertDialogWithShadow(
                "An AlertDialog should be displayed after click on mainMenuItemDeletePlaylist"
            ).also { (_, shadowDialog) ->
                val dialogItems = shadowDialog.items.map { it.toString() }

                assertEquals(
                    "Wrong list displayed on AlertDialog after click on mainMenuItemDeletePlaylist",
                    listOf(playlistName),
                    dialogItems
                )
                shadowDialog.clickAndRunOnItem(0)
            }
            //

            //check items
            val caseDescription2 = "on PLAY_MUSIC state after deleting current playlist with name $playlistName"
            mainSongList.assertListItems(songFakeList, caseDescription2) { itemViewSupplier, _, item ->
                val messageWrongItem =
                    "Wrong list item found after deleting current playlist, " +
                            "expected \"All songs\" playlist to be loaded"
                assertSongItem(messageWrongItem, itemViewSupplier(), item)
            }

            // check delete dialog don't display deleted playlist
            activity.clickMenuItemAndRun(mainMenuItemIdDeletePlaylist)

            getLastAlertDialogWithShadow(
                "An AlertDialog should be displayed after click on mainMenuItemDeletePlaylist"
            ).also { (dialog, shadowDialog) ->
                val dialogItems = shadowDialog.items.map { it.toString() }

                assertEquals(
                    "Wrong list displayed on AlertDialog after click on mainMenuItemDeletePlaylist",
                    listOf<String>(),
                    dialogItems
                )

                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).clickAndRun()
            }
            //

            // check load dialog don't display deleted playlist
            activity.clickMenuItemAndRun(mainMenuItemIdLoadPlaylist)

            getLastAlertDialogWithShadow(
                "An AlertDialog should be displayed after click on mainMenuItemLoadPlaylist"
            ).also { (dialog, shadowDialog) ->
                val dialogItems = shadowDialog.items.map { it.toString() }

                assertEquals(
                    "Wrong list displayed on AlertDialog after click on mainMenuItemLoadPlaylist",
                    listOf("All Songs"),
                    dialogItems
                )

                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).clickAndRun()
            }
            //
        }
        Unit
    }

    @Test
    fun test22_checkDeletePlaylistOnAddPlaylistStateDeletingPlaylistThatIsNotDisplayingAndNotCurrentPlaylist() {
        val playlistName = "My Playlist"
        testActivity {
            val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
            PlayMusicScreen(this).apply {
                mainButtonSearch.clickAndRun()
                activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
            }
            AddPlaylistScreen(this).apply {
                addPlaylist(
                    playlistName = playlistName,
                    selectedItemsIndex = testedItemsZeroBasedIndexes,
                    songListView = mainSongList,
                    fragmentContainer = mainFragmentContainer
                )
            }
            PlayMusicScreen(this).apply {
                activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
            }
            AddPlaylistScreen(this).apply {
                // delete playlist
                activity.clickMenuItemAndRun(mainMenuItemIdDeletePlaylist)

                getLastAlertDialogWithShadow(
                    "An AlertDialog should be displayed after click on mainMenuItemDeletePlaylist"
                ).also { (_, shadowDialog) ->
                    val dialogItems = shadowDialog.items.map { it.toString() }

                    assertEquals(
                        "Wrong list displayed on AlertDialog after click on mainMenuItemDeletePlaylist",
                        listOf(playlistName),
                        dialogItems
                    )
                    shadowDialog.clickAndRunOnItem(0)
                }
                //

                // check delete dialog don't display deleted playlist
                activity.clickMenuItemAndRun(mainMenuItemIdDeletePlaylist)

                getLastAlertDialogWithShadow(
                    "An AlertDialog should be displayed after click on mainMenuItemDeletePlaylist"
                ).also { (dialog, shadowDialog) ->
                    val dialogItems = shadowDialog.items.map { it.toString() }

                    assertEquals(
                        "Wrong list displayed on AlertDialog after click on mainMenuItemDeletePlaylist",
                        listOf<String>(),
                        dialogItems
                    )

                    dialog.getButton(AlertDialog.BUTTON_NEGATIVE).clickAndRun()
                }
                //

                // check load dialog don't display deleted playlist
                activity.clickMenuItemAndRun(mainMenuItemIdLoadPlaylist)

                getLastAlertDialogWithShadow(
                    "An AlertDialog should be displayed after click on mainMenuItemLoadPlaylist"
                ).also { (dialog, shadowDialog) ->
                    val dialogItems = shadowDialog.items.map { it.toString() }

                    assertEquals(
                        "Wrong list displayed on AlertDialog after click on mainMenuItemLoadPlaylist",
                        listOf("All Songs"),
                        dialogItems
                    )

                    dialog.getButton(AlertDialog.BUTTON_NEGATIVE).clickAndRun()
                }
                //

                // check SongSelector items remains
                val caseDescription = "After deleting in ADD_PLAYLIST state a playlist that is not displaying " +
                        "the playlist that is displaying should remain"
                mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, song ->
                    SongSelectorItemBindings(itemViewSupplier).apply {
                        assertSongSelectorInfo(caseDescription, song)
                    }
                }
                addPlaylistBtnCancel.clickAndRun()
            }
            PlayMusicScreen(this).apply {
                //check currentPlaylist remains
                val caseDescription =
                    "After deleting in ADD_PLAYLIST state a playlist that is not the currentPlaylist" +
                            "the currentPlaylist on PLAY_MUSIC state should remain"
                mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, song ->
                    assertSongItem(caseDescription, itemViewSupplier(), song)
                }
            }
            Unit
        }
    }

    @Test
    fun test23_checkDeletePlaylistOnAddPlaylistStateWithCurrentDisplayingAndCurrentPlaylistBeingDeleted()  = testActivity {
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val playlistName = "My Playlist"
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = testedItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer
            )
        }
        PlayMusicScreen(this).apply {
            // load list in PLAY_MUSIC state
            CustomMediaPlayerShadow.setFakeSong(songFakeList[testedItemsZeroBasedIndexes.first()])
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )

            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            // load list in ADD_PLAYLIST state
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )

            CustomMediaPlayerShadow.setFakeSong(songFakeList.first())
            // delete playlist
            activity.clickMenuItemAndRun(mainMenuItemIdDeletePlaylist)

            getLastAlertDialogWithShadow(
                "An AlertDialog should be displayed after click on mainMenuItemDeletePlaylist"
            ).also { (_, shadowDialog) ->
                val dialogItems = shadowDialog.items.map { it.toString() }

                assertEquals(
                    "Wrong list displayed on AlertDialog after click on mainMenuItemDeletePlaylist",
                    listOf(playlistName),
                    dialogItems
                )
                shadowDialog.clickAndRunOnItem(0)
            }
            //

            // check delete dialog don't display deleted playlist
            activity.clickMenuItemAndRun(mainMenuItemIdDeletePlaylist)

            getLastAlertDialogWithShadow(
                "An AlertDialog should be displayed after click on mainMenuItemDeletePlaylist"
            ).also { (dialog, shadowDialog) ->
                val dialogItems = shadowDialog.items.map { it.toString() }

                assertEquals(
                    "Wrong list displayed on AlertDialog after click on mainMenuItemDeletePlaylist",
                    listOf<String>(),
                    dialogItems
                )

                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).clickAndRun()
            }
            //

            // check load dialog don't display deleted playlist
            activity.clickMenuItemAndRun(mainMenuItemIdLoadPlaylist)

            getLastAlertDialogWithShadow(
                "An AlertDialog should be displayed after click on mainMenuItemLoadPlaylist"
            ).also { (dialog, shadowDialog) ->
                val dialogItems = shadowDialog.items.map { it.toString() }

                assertEquals(
                    "Wrong list displayed on AlertDialog after click on mainMenuItemLoadPlaylist",
                    listOf("All Songs"),
                    dialogItems
                )

                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).clickAndRun()
            }
            //

            // check SongSelector changes to "All Songs"
            val  caseDescription = "After deleting in ADD_PLAYLIST state a playlist that is displaying " +
                    "the playlist that is displaying should change to \"All Songs\""
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, song ->
                SongSelectorItemBindings(itemViewSupplier).apply {
                    assertSongSelectorInfo(caseDescription, song)
                }
            }

            addPlaylistBtnCancel.clickAndRun()
        }
        PlayMusicScreen(this).apply {
            //check currentPlaylist changes to "All Songs"
            val caseDescription =
                "After deleting in ADD_PLAYLIST state a playlist that is the currentPlaylist" +
                        "the currentPlaylist should change to \"All Songs\""
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, song ->
                assertSongItem(caseDescription, itemViewSupplier(), song)
            }
        }
        Unit
    }

    @Test
    fun test24_checkSearchInPlayMusicStateChangeCurrentPlaylistToAllSongs()  = testActivity {
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val playlistName = "My Playlist"

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = testedItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
                testEmptyName = true
            )
        }
        PlayMusicScreen(this).apply {
            CustomMediaPlayerShadow.setFakeSong(songFakeList[testedItemsZeroBasedIndexes[0]])
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )

            mainButtonSearch.clickAndRun()
            val caseDescription = "On PLAY_MUSIC state after clicking $ID_MAIN_BUTTON_SEARCH expected All Songs playlist to be loaded"
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, song ->
                assertSongItem(
                    "$caseDescription Wrong list item after search button clicked",
                    itemViewSupplier(),
                    song
                )
            }
        }
        Unit
    }

    @Test
    fun test25_checkSearchInAddPlaylistStateDisplaysAllSongsOnAddPlaylistStateAndKeepsCurrentPlaylistInPlayMusicState()  = testActivity {
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val playlistName = "My Playlist"
        val playlist = testedItemsZeroBasedIndexes.map { songFakeList[it] }

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)

        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = testedItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
                testEmptyName = true
            )
        }
        PlayMusicScreen(this).apply {
            CustomMediaPlayerShadow.setFakeSong(songFakeList[testedItemsZeroBasedIndexes[0]])
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )

            mainButtonSearch.clickAndRun()
            val caseDescription =
                "After mainButtonSearch is clicked on ADD_PLAYLIST state " +
                        "the \"All Songs\" playlist should be displaying"
            mainSongList.assertListItems(songFakeList, caseDescription) { itemViewSupplier, _, song ->
                SongSelectorItemBindings(itemViewSupplier).apply {
                    assertSongSelectorInfo(caseDescription, song)
                }
            }
            addPlaylistBtnCancel.clickAndRun()
        }
        PlayMusicScreen(this).apply {
            val caseDescription = "After mainButtonSearch is clicked on ADD_PLAYLIST state " +
                    "the currentPlaylist in PLAY_MUSIC state should not change."
            mainSongList.assertListItems(playlist, caseDescription) { itemViewSupplier, _, song ->
                assertSongItem(
                    caseDescription,
                    itemViewSupplier(), song
                )
            }
        }
        Unit
    }
}