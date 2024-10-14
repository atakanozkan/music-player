package org.hyperskill.musicplayer

import android.app.AlertDialog
import org.hyperskill.musicplayer.internals.CustomMediaPlayerShadow
import org.hyperskill.musicplayer.internals.CustomShadowAsyncDifferConfig
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.mainMenuItemIdAddPlaylist
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.mainMenuItemIdDeletePlaylist
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.mainMenuItemIdLoadPlaylist
import org.hyperskill.musicplayer.internals.MusicPlayerUnitTests
import org.hyperskill.musicplayer.internals.PlayMusicScreen
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_CONTROLLER_BTN_PLAY_PAUSE
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_CONTROLLER_BTN_STOP
import org.hyperskill.musicplayer.internals.PlayMusicScreen.Companion.ID_CONTROLLER_SEEKBAR
import org.hyperskill.musicplayer.ui.MainActivity
import org.junit.Assert.assertEquals
import org.junit.FixMethodOrder
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config

// version 2.0
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner::class)
@Config(shadows = [CustomMediaPlayerShadow::class, CustomShadowAsyncDifferConfig::class])
class Stage1UnitTestB : MusicPlayerUnitTests<MainActivity>(MainActivity::class.java){

    @Test
    fun test00_checkMainActivityComponentsExist() = testActivity {
        MusicPlayerBaseScreen(this).apply {
            mainButtonSearch
            mainSongList
            mainFragmentContainer
        }
        Unit
    }

    @Test
    fun test01_checkPlayerControllerFragmentComponentsExist() = testActivity {
        PlayMusicScreen(this, initAssertions = true).apply {
            controllerTvCurrentTime // assert exists
            controllerTvTotalTime
            controllerSeekBar
            controllerBtnPlayPause
            controllerBtnStop
        }
        Unit
    }

    @Ignore
    @Test
    fun test02_checkSearchButtonNoSongsFound() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            assertLastToastMessageEquals(
                "wrong toast message after click to mainButtonSearch",
                "no songs found"
            )
        }
        Unit
    }

    @Test
    fun test03_checkMenuItemAddPlaylist() = testActivity {
        PlayMusicScreen(this).apply {
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
            assertLastToastMessageEquals(
                "wrong toast message after click to mainMenuItemIdAddPlaylist",
                "no songs loaded, click search to load songs"
            )
        }
        Unit
    }

    @Test
    fun test04_checkMenuItemLoadPlaylist() = testActivity {
        PlayMusicScreen(this).apply {
            activity.clickMenuItemAndRun(mainMenuItemIdLoadPlaylist)

            val (alertDialog, shadowAlertDialog) = getLastAlertDialogWithShadow(
                errorMessageNotFound = "No Dialog was shown after click on mainMenuLoadPlaylist."
            )

            val actualTitle = shadowAlertDialog.title.toString().lowercase()
            val messageWrongTitle =
                "Wrong title found on dialog shown after click on mainMenuLoadPlaylist"
            val expectedTitle = "choose playlist to load"
            assertEquals(messageWrongTitle, expectedTitle, actualTitle)


            alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).clickAndRun()
        }
        Unit
    }

    @Test
    fun test05_checkMenuItemDeletePlaylist() = testActivity {
        PlayMusicScreen(this).apply {
            activity.clickMenuItemAndRun(mainMenuItemIdDeletePlaylist)

            val (alertDialog, shadowAlertDialog) = getLastAlertDialogWithShadow(
                errorMessageNotFound = "No Dialog was shown after click on mainMenuDeletePlaylist."
            )

            val actualTitle = shadowAlertDialog.title.toString().lowercase()
            val messageWrongTitle =
                "Wrong title found on dialog shown after click on mainMenuDeletePlaylist"
            val expectedTitle = "choose playlist to delete"
            assertEquals(messageWrongTitle, expectedTitle, actualTitle)


            alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).clickAndRun()
        }
        Unit
    }

    @Test
    fun test06_checkControllerStopButtonBeforeSearch() = testActivity {
        PlayMusicScreen(this).apply {
            try { controllerBtnStop.clickAndRun() }
            catch (t: Throwable) {
                throw AssertionError("Click on $ID_CONTROLLER_BTN_STOP before " +
                        "search should not throw exception",
                    t
                )
            }
        }
        Unit
    }

    @Test
    fun test07_checkControllerSeekBarBeforeSearch() = testActivity {
        PlayMusicScreen(this).apply {
            if (Shadows.shadowOf(controllerSeekBar).onSeekBarChangeListener != null) {
                try { controllerSeekBar.setProgressAsUser(1) }
                catch (t: Throwable) {
                    throw AssertionError("Dragging $ID_CONTROLLER_SEEKBAR before " +
                            "search should not throw exception",
                        t
                    )
                }
            } else {
                // ok
            }
        }
        Unit
    }

    @Test
    fun test08_checkControllerPlayPauseButtonBeforeSearch() = testActivity {
        PlayMusicScreen(this).apply {
            try { controllerBtnPlayPause.clickAndRun() }
            catch (t: Throwable) {
                throw AssertionError("Click on $ID_CONTROLLER_BTN_PLAY_PAUSE before " +
                        "search should not throw exception",
                    t
                )
            }
        }
        Unit
    }
}