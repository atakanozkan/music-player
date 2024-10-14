package org.hyperskill.musicplayer

import android.Manifest
import android.os.Handler
import android.os.SystemClock
import org.hyperskill.musicplayer.internals.AddPlaylistScreen
import org.hyperskill.musicplayer.internals.AddPlaylistScreen.Companion.ID_ADD_PLAYLIST_BTN_CANCEL
import org.hyperskill.musicplayer.internals.CustomMediaPlayerShadow
import org.hyperskill.musicplayer.internals.CustomShadowAsyncDifferConfig
import org.hyperskill.musicplayer.internals.CustomShadowCountDownTimer
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.ID_MAIN_BUTTON_SEARCH
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.mainMenuItemIdAddPlaylist
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.mainMenuItemIdLoadPlaylist
import org.hyperskill.musicplayer.internals.MusicPlayerUnitTests
import org.hyperskill.musicplayer.internals.PlayMusicScreen
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_CONTROLLER_BTN_PLAY_PAUSE
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_CONTROLLER_BTN_STOP
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_CONTROLLER_SEEKBAR
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE
import org.hyperskill.musicplayer.ui.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.lang.AssertionError
import java.time.Duration

// version 2.0
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Config(shadows = [CustomMediaPlayerShadow::class, CustomShadowCountDownTimer::class, CustomShadowAsyncDifferConfig::class])
@RunWith(RobolectricTestRunner::class)
class Stage3UnitTest : MusicPlayerUnitTests<MainActivity>(MainActivity::class.java) {

    @Before
    fun setUp() {
        CustomShadowCountDownTimer.handler = Handler(activity.mainLooper)
        setupContentProvider(songFakeList)
        shadowActivity.grantPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
        CustomMediaPlayerShadow.setFakeSong(songFakeList[0])
        CustomMediaPlayerShadow.acceptRawWisdom = true
    }

    @Test
    fun test00_checkControllerTriggersMediaPlayerOnDefaultItem() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            if(isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH no MediaPlayer should be playing"
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }
            var playTime = 0

            playTime += controllerBtnPlayPause.clickAndRun(1_200) // play
            val messagePlayerShouldStartPlay =
                "After click on $ID_CONTROLLER_BTN_PLAY_PAUSE right after $ID_MAIN_BUTTON_SEARCH " +
                        "the default song item should start playing."
            player.assertControllerPlay(messagePlayerShouldStartPlay, expectedPosition = playTime)

            controllerBtnPlayPause.clickAndRun(20_000) // pause
            val messagePlayingShouldPauseOnClick =
                "After click on $ID_CONTROLLER_BTN_PLAY_PAUSE on a playing song the mediaPlayer should pause."
            player.assertControllerPause(messagePlayingShouldPauseOnClick,  expectedPosition = playTime)

            playTime += controllerBtnPlayPause.clickAndRun(10_100) // play
            val messagePlayingShouldResumeOnClick =
                "After click on $ID_CONTROLLER_BTN_PLAY_PAUSE on a paused song the mediaPlayer should resume playing."
            player.assertControllerPlay(messagePlayingShouldResumeOnClick,  expectedPosition = playTime)
            assertEquals(messagePlayingShouldResumeOnClick, true, player.isPlaying)

            controllerBtnStop.clickAndRun(10_000)  // stop
            val messagePlayingShouldStopOnStopClick =
                "After click on $ID_CONTROLLER_BTN_STOP the player should stop."
            player.assertControllerStop(messagePlayingShouldStopOnStopClick)
        }
        Unit
    }

    @Test
    fun test01_checkImgButtonTriggersMediaPlayerOnListItem() = testActivity {
        var playingTime = 0
        val selectedItemIndex = 1

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            if (isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH no MediaPlayer should be playing"
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }

            CustomMediaPlayerShadow.setFakeSong(songFakeList[selectedItemIndex])
            mainSongList.assertSingleListItem(selectedItemIndex) { itemViewSupplier ->
                // invoking itemViewSupplier increase clock time

                // state stopped
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier) //play

                playingTime += songItemImgBtnPlayPause.clickAndRun(1_200)
                // state playing

                // refresh reference to songItemImgBtnPlayPause
                val timeBefore1 = SystemClock.currentGnssTimeClock().millis()
                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                val timeAfter1 = SystemClock.currentGnssTimeClock().millis()

                playingTime += (timeAfter1 - timeBefore1).toInt()

                val messagePlayerShouldStartPlay =
                    "After click on songItemImgBtnPlayPause the song item should start playing."
                player.assertControllerPlay(
                    messagePlayerShouldStartPlay,
                    expectedPosition = playingTime
                )

                songItemImgBtnPlayPause.clickAndRun(20_000)
                // state paused

                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                val messagePlayingShouldPauseOnClick =
                    "After click on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a playing song the mediaPlayer should pause."
                player.assertControllerPause(
                    messagePlayingShouldPauseOnClick, expectedPosition = playingTime
                )

                playingTime += songItemImgBtnPlayPause.clickAndRun(10_100)
                // state playing

                val messagePlayingShouldResumeOnClick =
                    "After click on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a paused song the mediaPlayer should resume playing."
                player.assertControllerPlay(
                    messagePlayingShouldResumeOnClick,
                    expectedPosition = playingTime
                )

                controllerBtnStop.clickAndRun(10_000)
                // state stopped

                val messagePlayingShouldStopOnStopClick =
                    "After click on $ID_CONTROLLER_BTN_STOP the player should stop."
                player.assertControllerStop(messagePlayingShouldStopOnStopClick)
            }
        }
        Unit
    }

    @Test
    fun test02_checkSeekBarChangeWhilePlaying() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            if (isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH MediaPlayer should not be playing"
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }

            var playingTime = 0
            playingTime += controllerBtnPlayPause.clickAndRun(1_200)  // play
            val messagePlayerShouldStartPlay =
                "After click on $ID_CONTROLLER_BTN_PLAY_PAUSE right after " +
                        "$ID_MAIN_BUTTON_SEARCH the default song item should start playing."
            player.assertControllerPlay(
                messagePlayerShouldStartPlay,
                expectedPosition = playingTime
            )

            controllerSeekBar.setProgressAsUser(100)  // seek with play
            shadowLooper.idleFor(Duration.ofMillis(100))
            playingTime = 100_100

            val errorSeekBarChange =
                "After changing $ID_CONTROLLER_SEEKBAR progress as user on a playing song " +
                        "the mediaPlayer should update its currentPosition and remain playing."
            player.assertControllerPlay(
                errorSeekBarChange,
                expectedPosition = playingTime
            )

            controllerBtnPlayPause.clickAndRun()  // pause
            val messagePauseAfterSeekBarChange =
                "It should be possible to pause a song after changing $ID_CONTROLLER_SEEKBAR."
            player.assertControllerPause(
                messagePauseAfterSeekBarChange,  expectedPosition = playingTime
            )
        }
        Unit
    }

    @Test
    fun test03_checkSeekBarBeforePlaying() = testActivity {
        var playingTime = 0
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            if (isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH MediaPlayer should not be playing."
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }


            try {
                controllerSeekBar.setProgressAsUser(100) // seek with stop
                shadowLooper.idleFor(Duration.ofMillis(100))
                playingTime = 100_000
            } catch (ex: NullPointerException) {
                val messageSeekBarChangeBeforePlayingException =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH and changing $ID_CONTROLLER_SEEKBAR progress as user before playing a song " +
                            "the application should not crash. Make sure to have a song already loaded. Failed with $ex"
                throw AssertionError(messageSeekBarChangeBeforePlayingException, ex)
            }

            val messageSeekBarChangeBeforePlaying = "After initial click on $ID_MAIN_BUTTON_SEARCH and changing $ID_CONTROLLER_SEEKBAR progress as user before playing a song " +
                    "the mediaPlayer should update its currentPosition and remain paused"

            player.assertControllerPause(
                messageSeekBarChangeBeforePlaying,  expectedPosition = playingTime
            )

            playingTime += controllerBtnPlayPause.clickAndRun(10_400) // play

            val messagePlayAfterSeekBarChangeBeforePlaying =
                "It should be possible to play a song after " +
                        "changing $ID_CONTROLLER_SEEKBAR progress as user before playing a song."
            player.assertControllerPlay(
                messagePlayAfterSeekBarChangeBeforePlaying,
                expectedPosition = playingTime
            )
        }
        Unit
    }

    @Test
    fun test04_checkSeekBarAfterStop() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            if (isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH MediaPlayer should not be playing."
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }

            controllerBtnPlayPause.clickAndRun(10_000) // play
            controllerBtnStop.clickAndRun() // stop

            controllerSeekBar.setProgressAsUser(100) // seek with stop
            shadowLooper.idleFor(Duration.ofMillis(1_000))

            val messageSeekBarChangeAfterStop =
                "After changing $ID_CONTROLLER_SEEKBAR progress as user with a stopped song " +
                        "the mediaPlayer should update its currentPosition and remain paused."
            player.assertControllerPause(
                messageSeekBarChangeAfterStop,  expectedPosition = 100_000
            )
        }
        Unit
    }

    @Test
    fun test05_checkSeekBarAfterPause() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            if (isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH MediaPlayer should not be playing."
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }

            controllerBtnPlayPause.clickAndRun(10_000) // play
            controllerBtnPlayPause.clickAndRun()  // pause

            controllerSeekBar.setProgressAsUser(50) // seek with pause
            shadowLooper.idleFor(Duration.ofMillis(1_000))

            val messageSeekBarChangeAfterPause =
                "After changing $ID_CONTROLLER_SEEKBAR progress as user with a paused song " +
                        "the mediaPlayer should update its currentPosition and remain paused."
            player.assertControllerPause(
                messageSeekBarChangeAfterPause,  expectedPosition = 50_000
            )
        }
        Unit
    }

    @Test
    fun test06_checkMusicEnd() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            if (isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH MediaPlayer should not be playing."
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }

            controllerSeekBar.setProgressAsUser(210) // seek with stop
            controllerBtnPlayPause.clickAndRun(10_000)  // play until end

            val messageSeekBarChangeAfterStop = "When a song ends the player should stop playing."
            player.assertControllerStop(messageSeekBarChangeAfterStop)

            mainSongList.assertSingleListItem(0) { itemViewSupplier ->
                val songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                    "When the song is finished the image should change to R.drawable.ic_play.",
                    R.drawable.ic_play
                )
            }
        }
        Unit
    }

    @Test
    fun test07_checkSeekBarChangeAfterMusicEnd() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            if (isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH MediaPlayer should not be playing."
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }

            controllerSeekBar.setProgressAsUser(210)  // seek with stop
            controllerBtnPlayPause.clickAndRun(10_400)  // play until end

            val messageSeekBarChangeAfterStop =
                "When a song ends the player should stop playing."
            player.assertControllerStop(messageSeekBarChangeAfterStop)

            controllerSeekBar.setProgressAsUser(200) // seek with stop
            var playingTime = 200_000
            playingTime += controllerBtnPlayPause.clickAndRun(10_400) // play
            val messagePlayAfterSeekBarChangeAfterMusicEnd =
                "It should be possible to change $ID_CONTROLLER_SEEKBAR progress as user " +
                        "after a music ends and resume playing the song."
            player.assertControllerPlay(
                messagePlayAfterSeekBarChangeAfterMusicEnd,
                expectedPosition = playingTime
            )
        }
        Unit
    }

    @Test
    fun test08_checkPlayAfterMusicEnd() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            if (isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH MediaPlayer should not be playing."
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }

            controllerSeekBar.setProgressAsUser(210) // seek with stop
            controllerBtnPlayPause.clickAndRun(10_000) // play until end

            val messageSeekBarChangeAfterStop =
                "When a song ends the player should stop playing."
            player.assertControllerStop(messageSeekBarChangeAfterStop)

            val playingTime = controllerBtnPlayPause.clickAndRun(10_400) // play
            val messagePlayAfterSeekBarChangeAfterMusicEnd =
                "It should be possible to play again a song after song end."
            player.assertControllerPlay(
                messagePlayAfterSeekBarChangeAfterMusicEnd,
                expectedPosition = playingTime
            )
        }
        Unit
    }

    @Test
    fun test09_checkImgButtonPlayAfterMusicEnd() = testActivity {
        val selectedItemIndex = 2
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            if (isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH MediaPlayer should not be playing."
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }

            CustomMediaPlayerShadow.setFakeSong(songFakeList[selectedItemIndex])
            mainSongList.assertSingleListItem(selectedItemIndex) { itemViewSupplier ->
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                songItemImgBtnPlayPause.clickAndRun() // play
                controllerSeekBar.setProgressAsUser(210)  // seek with play
                shadowLooper.idleFor(Duration.ofMillis(20_000)) // play until end

                val messageSeekBarChangeAfterStop =
                    "When a song ends the player should stop playing."
                player.assertControllerStop(messageSeekBarChangeAfterStop)

                songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                val playingTime = songItemImgBtnPlayPause.clickAndRun(10_400)  // play
                val messagePlayAfterSeekBarChangeAfterMusicEnd =
                    "It should be possible to play again a song after song end."
                player.assertControllerPlay(
                    messagePlayAfterSeekBarChangeAfterMusicEnd,
                    expectedPosition = playingTime
                )
            }
        }
        Unit
    }


    @Test
    fun test10_checkSongChange() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            if (isPlayerNull().not()) {
                val messagePlayerPlayingOnSearchClick =
                    "After initial click on $ID_MAIN_BUTTON_SEARCH MediaPlayer should not be playing."
                assertEquals(messagePlayerPlayingOnSearchClick, false, player.isPlaying)
            }

            CustomMediaPlayerShadow.wasResetOrRecreated = true  // consider first as already created
            mainSongList.assertListItems(songFakeList) { itemViewSupplier, position, song ->
                CustomMediaPlayerShadow.setFakeSong(song)
                val songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                val playingTime = songItemImgBtnPlayPause.clickAndRun(2_200)  // play

                val messageSongChange =
                    "After click on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE on a different songItem the current song should change."
                assertTrue(messageSongChange, CustomMediaPlayerShadow.wasResetOrRecreated)

                val messagePlaySongItem =
                    "After first click on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE that song should play."
                player.assertControllerPlay(
                    messagePlaySongItem,
                    expectedPosition = playingTime
                )

                controllerBtnPlayPause.clickAndRun()  // pause

                val messagePauseSongItem =
                    "After click on $ID_CONTROLLER_BTN_PLAY_PAUSE " +
                            "with a playing song that song should be paused."
                player.assertControllerPause(messagePauseSongItem, expectedPosition = playingTime)

                controllerBtnStop.clickAndRun()  // stop

                val messageStopSongItem =
                    "After click on $ID_CONTROLLER_BTN_STOP the song should be stopped"
                player.assertControllerStop(messageStopSongItem)

                CustomMediaPlayerShadow.wasResetOrRecreated = false
            }
        }
        Unit
    }

    @Test
    fun test11_checkCancelAddPlaylistKeepsPlayingCurrentSelectedSong() = testActivity {
        var playingTime = 0
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val selectedSongZeroIndex = testedItemsZeroBasedIndexes[1]

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            CustomMediaPlayerShadow.setFakeSong(songFakeList[selectedSongZeroIndex])
            mainSongList.assertSingleListItem(selectedSongZeroIndex) { itemViewSupplier ->

                val songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                playingTime += songItemImgBtnPlayPause.clickAndRun(3200) // play

                player.assertControllerPlay(
                    "A song should start playing after click on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE",
                    expectedPosition = playingTime
                )
            }

            playingTime += activity.clickMenuItemAndRun(
                mainMenuItemIdAddPlaylist,
                millis = 1_000
            )
        }
        AddPlaylistScreen(this).apply {
            playingTime += addPlaylistBtnCancel.clickAndRun(1_000)
        }
        PlayMusicScreen(this).apply {
            // give time to controller components to update values
            shadowLooper.idleFor(Duration.ofMillis(1_100))
            playingTime += 1_100
            //

            // check item keeps selected item state after list add
            mainSongList.assertListItems(songFakeList) { itemViewSupplier, position, item, elapsedTime ->
                // invoking itemViewSupplier might increase clock

                val timeBefore = SystemClock.currentGnssTimeClock().millis()
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                val timeAfter = SystemClock.currentGnssTimeClock().millis()
                playingTime += elapsedTime + (timeAfter - timeBefore).toInt()

                if (item.id == selectedSongZeroIndex + 1) {


                    playingTime += adjustPlayerPositionToAvoidSyncIssues()

                    player.assertControllerPlay(
                        "A song should remain playing " +
                                "after list load if present on the loaded list.",
                        expectedPosition = playingTime
                    )

                    controllerBtnPlayPause.clickAndRun(2_000)  // pause
                    player.assertControllerPause(
                        "A selected song item should remain " +
                                "responding to $ID_CONTROLLER_BTN_PLAY_PAUSE after list loaded.",
                        expectedPosition = playingTime
                    )
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    playingTime += songItemImgBtnPlayPause.clickAndRun(1_200) // play
                    player.assertControllerPlay(
                        "The selected song should remain " +
                                "responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after adding a playlist",
                        expectedPosition = playingTime
                    )

                    controllerBtnStop.clickAndRun() // stop
                    player.assertControllerStop(
                        "The selected song should remain responding to $ID_CONTROLLER_BTN_STOP clicks after adding a playlist"
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
    fun test12_checkLoadPlaylistKeepsPlayingCurrentSelectedSong() = testActivity {
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val selectedSongZeroIndex = testedItemsZeroBasedIndexes[1]
        var playingTime = 0
        val playlistName = "My Playlist"

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            CustomMediaPlayerShadow.setFakeSong(songFakeList[selectedSongZeroIndex])
            mainSongList.assertSingleListItem(selectedSongZeroIndex) { itemViewSupplier ->
                val songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                playingTime += songItemImgBtnPlayPause.clickAndRun(3200)   // play

                player.assertControllerPlay(
                    "A song should start playing after click on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE",
                    expectedPosition = playingTime
                )
            }

            playingTime += activity.clickMenuItemAndRun(
                mainMenuItemIdAddPlaylist,
                millis = 3_000
            )
        }
        AddPlaylistScreen(this).apply {

            playingTime += addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = testedItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer
            )
        }
        PlayMusicScreen(this).apply {
            // give time to controller components to update values
            shadowLooper.idleFor(Duration.ofMillis(1_100))
            playingTime += 1_100
            //

            // check item keeps selected item state after list add
            mainSongList.assertListItems(songFakeList) { itemViewSupplier, position, item, elapsedTime ->
                playingTime += elapsedTime

                val timeBefore = SystemClock.currentGnssTimeClock().millis()
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                val timeAfter = SystemClock.currentGnssTimeClock().millis()
                playingTime += (timeAfter - timeBefore).toInt()

                if (item.id == selectedSongZeroIndex + 1) {


                    playingTime += adjustPlayerPositionToAvoidSyncIssues()

                    player.assertControllerPlay(
                        "A song should remain playing after list load if present on the loaded list.",
                        expectedPosition = playingTime
                    )

                    controllerBtnPlayPause.clickAndRun(2_000) // pause
                    player.assertControllerPause(
                        "A selected song item should remain " +
                                "responding to $ID_CONTROLLER_BTN_PLAY_PAUSE after list loaded.",
                        expectedPosition = playingTime
                    )

                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    playingTime += songItemImgBtnPlayPause.clickAndRun(1_200)  // play
                    player.assertControllerPlay(
                        "The selected song should remain responding " +
                                "to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after adding a playlist",
                        expectedPosition = playingTime
                    )

                    controllerBtnStop.clickAndRun()  // stop
                    player.assertControllerStop(
                        "The selected song should remain responding to $ID_CONTROLLER_BTN_STOP clicks after adding a playlist"
                    )

                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    playingTime = songItemImgBtnPlayPause.clickAndRun(1_200)  // play
                    player.assertControllerPlay(
                        "The selected song should remain responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after adding a playlist",
                        expectedPosition = playingTime
                    )

                } else {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "A unselected song should remain unselected after loading a playlist",
                        R.drawable.ic_play
                    )
                }
            }
            //

            playingTime += loadPlaylist(
                menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                expectedPlaylistNameList = listOf("All Songs", playlistName),
                playlistToLoadIndex = 1
            )

            // give time to controller components to update values
            shadowLooper.idleFor(Duration.ofMillis(1_100))
            playingTime += 1_100
            //

            // check item keeps selected item state after list load
            mainSongList.assertListItems(
                testedItemsZeroBasedIndexes.map { songFakeList[it] }) { itemViewSupplier, position, item, elapsedTime ->

                playingTime += elapsedTime

                val timeBefore = SystemClock.currentGnssTimeClock().millis()
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                val timeAfter = SystemClock.currentGnssTimeClock().millis()
                playingTime += (timeAfter - timeBefore).toInt()

                if (item.id == selectedSongZeroIndex + 1) {

                    playingTime += adjustPlayerPositionToAvoidSyncIssues()

                    player.assertControllerPlay(
                        "A song should remain playing after list load if present on the loaded list.",
                        expectedPosition = playingTime
                    )

                    controllerBtnPlayPause.clickAndRun(2_000)  // pause
                    player.assertControllerPause(
                        "A selected song item should remain responding " +
                                "to $ID_CONTROLLER_BTN_PLAY_PAUSE after playlist loaded.",
                        expectedPosition = playingTime
                    )

                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    playingTime += songItemImgBtnPlayPause.clickAndRun(1_200)  // play
                    player.assertControllerPlay(
                        "The selected song should remain responding to " +
                                "$ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after playlist loaded.",
                        expectedPosition = playingTime
                    )

                    controllerBtnStop.clickAndRun()  // stop
                    player.assertControllerStop(
                        "The selected song should remain responding to $ID_CONTROLLER_BTN_STOP " +
                                "clicks after playlist loaded."
                    )

                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    playingTime = songItemImgBtnPlayPause.clickAndRun(1_200)  // play
                    player.assertControllerPlay(
                        "The selected song should remain responding to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after playlist loaded.",
                        expectedPosition = playingTime
                    )

                } else {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "A unselected song should remain unselected after playlist loaded.",
                        R.drawable.ic_play
                    )
                }
            }
            //
        }
        Unit
    }

    @Test
    fun test13_checkLoadPlaylistChangesSongIfCurrentSelectedSongNotInPlaylist() = testActivity {
        val testedItemsZeroBasedIndexes = listOf(1, 3, 6)
        val selectedSongZeroIndex = 8
        val playlistName = "Yes Playlist"
        var playingTime = 0

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            CustomMediaPlayerShadow.setFakeSong(songFakeList[selectedSongZeroIndex])
            mainSongList.assertSingleListItem(selectedSongZeroIndex) { itemViewSupplier ->
                // invoking itemViewSupplier increase clock

                // state stopped
                val songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                playingTime += songItemImgBtnPlayPause.clickAndRun(3200)
                // state playing

                player.assertControllerPlay(
                    "A song should start playing after click on $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE.",
                    expectedPosition = playingTime
                )
            }

            playingTime += activity.clickMenuItemAndRun(
                mainMenuItemIdAddPlaylist,
                millis = 3_000
            )
        }
        AddPlaylistScreen(this).apply {
            playingTime += addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = testedItemsZeroBasedIndexes,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer
            )
        }
        PlayMusicScreen(this).apply {
            // give time to controller components to update values
            shadowLooper.idleFor(Duration.ofMillis(1_100))
            playingTime += 1_100
            //

            // check item keeps selected item state after list add
            mainSongList.assertListItems(songFakeList) { itemViewSupplier, position, item, elapsedTime ->
                playingTime += elapsedTime

                val timeBefore = SystemClock.currentGnssTimeClock().millis()
                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                val timeAfter = SystemClock.currentGnssTimeClock().millis()
                playingTime += (timeAfter - timeBefore).toInt()

                if (item.id == selectedSongZeroIndex + 1) {

                    playingTime += adjustPlayerPositionToAvoidSyncIssues()

                    player.assertControllerPlay(
                        "A song should remain playing after adding playlist.",
                        expectedPosition = playingTime
                    )

                    controllerBtnPlayPause.clickAndRun(2_000)  // pause
                    player.assertControllerPause(
                        "A selected song item should remain responding " +
                                "to $ID_CONTROLLER_BTN_PLAY_PAUSE after playlist added.",
                        expectedPosition = playingTime
                    )
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    playingTime += songItemImgBtnPlayPause.clickAndRun(1_200)  // play
                    player.assertControllerPlay(
                        "The selected song should remain responding " +
                                "to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after adding a playlist.",
                        expectedPosition = playingTime
                    )

                    controllerBtnStop.clickAndRun()  // stop
                    player.assertControllerStop(
                        "The selected song should remain responding " +
                                "to $ID_CONTROLLER_BTN_STOP clicks after adding a playlist."
                    )

                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    playingTime = songItemImgBtnPlayPause.clickAndRun(3_100)  // play
                    player.assertControllerPlay(
                        "The selected song should remain responding " +
                                "to $ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after adding a playlist.",
                        expectedPosition = playingTime
                    )

                } else {
                    songItemImgBtnPlayPause.drawable.assertCreatedFromResourceId(
                        "A unselected song should remain unselected after adding a playlist.",
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
            ) // stop currentTrack because new list does not contain currentTrack

            // give time to controller components to update values
            shadowLooper.idleFor(Duration.ofMillis(1_100))
            //


            // check item keeps selected item state after list load
            mainSongList.assertListItems(
                testedItemsZeroBasedIndexes.map { songFakeList[it] }) { itemViewSupplier, position, item, elapsedTime ->

                var songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)

                if (position == 0) {


                    assertControllerState(
                        "After loading a playlist without the current selected song" +
                                " the first item of the loaded list should be selected.",
                        item, 0
                    )

                    playingTime = controllerBtnPlayPause.clickAndRun(1_100)  // play

                    player.assertControllerPlay(
                        "If the selected song is not present in the playlist loaded " +
                                "the first item of the list should be selected and " +
                                "react to clicks on $ID_CONTROLLER_BTN_PLAY_PAUSE",
                        expectedPosition = playingTime
                    )

                    val timeBefore = SystemClock.currentGnssTimeClock().millis()
                    songItemImgBtnPlayPause = songItemImgBtnPlayPauseSupplier(itemViewSupplier)
                    val timeAfter = SystemClock.currentGnssTimeClock().millis()
                    playingTime += (timeAfter - timeBefore).toInt()

                    songItemImgBtnPlayPause.clickAndRun(2_000)  // pause
                    player.assertControllerPause(
                        "The selected song item should respond to " +
                                "$ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE clicks after playlist loaded.",
                        expectedPosition = playingTime
                    )

                    controllerBtnStop.clickAndRun()  // stop
                    player.assertControllerStop(
                        "The selected song should remain responding to" +
                                " $ID_CONTROLLER_BTN_STOP clicks after playlist loaded"
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
    fun test14_checkControllerKeepsStateAfterCancelAddPlaylist() = testActivity {
        var playingTime = 0

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()

            mainFragmentContainer.also {
                controllerSeekBar.setProgressAsUser(100)  // seek with stop
                playingTime = 100_000
                playingTime += controllerBtnPlayPause.clickAndRun(1_100) // play

                val messageWrongStateAfterPlay =
                    "Wrong state of controller view after click on $ID_CONTROLLER_BTN_PLAY_PAUSE " +
                            "after $ID_CONTROLLER_SEEKBAR change."
                assertControllerState(
                    messageWrongStateAfterPlay, songFakeList[0], playingTime
                )
            }

            playingTime += activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist, 3_000)
        }
        AddPlaylistScreen(this).apply {
            playingTime += addPlaylistBtnCancel.clickAndRun(1_000)
        }
        PlayMusicScreen(this).apply {
            mainFragmentContainer.also {
                playingTime += adjustPlayerPositionToAvoidSyncIssues()
                val messageWrongStateAfterPlay =
                    "Wrong state of controller view after click on $ID_ADD_PLAYLIST_BTN_CANCEL"
                assertControllerState(
                    messageWrongStateAfterPlay, songFakeList[0], playingTime
                )
            }
        }
        Unit
    }
}