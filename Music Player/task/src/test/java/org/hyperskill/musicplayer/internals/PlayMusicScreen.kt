package org.hyperskill.musicplayer.internals

import android.media.MediaPlayer
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import org.hyperskill.musicplayer.ui.MainActivity
import org.junit.Assert
import org.junit.Assert.assertEquals
import kotlin.math.abs

// version 2.0
class PlayMusicScreen(
    private val test: MusicPlayerUnitTests<MainActivity>,
    val initAssertions: Boolean = false
) : MusicPlayerBaseScreen(test) {
    companion object {
        const val ID_CONTROLLER_TV_CURRENT_TIME = "controllerTvCurrentTime"
        const val ID_CONTROLLER_TV_TOTAL_TIME = "controllerTvTotalTime"
        const val ID_CONTROLLER_SEEKBAR = "controllerSeekBar"
        const val ID_CONTROLLER_BTN_PLAY_PAUSE = "controllerBtnPlayPause"
        const val ID_CONTROLLER_BTN_STOP = "controllerBtnStop"
        const val ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE = "songItemImgBtnPlayPause"
        const val ID_SONG_ITEM_TV_ARTIST = "songItemTvArtist"
        const val ID_SONG_ITEM_TV_TITLE = "songItemTvTitle"
        const val ID_SONG_ITEM_TV_DURATION = "songItemTvDuration"
    }

    val controllerTvCurrentTime by lazy {
        with(test) {
            val controllerTvCurrentTime = mainFragmentContainer
                .findViewByString<TextView>(ID_CONTROLLER_TV_CURRENT_TIME)
            if(initAssertions) {
                val actualCurrentTime = controllerTvCurrentTime.text.toString()
                val expectedCurrentTime = "00:00"
                val messageWrongInitialCurrentTime =
                    "Wrong initial value for $ID_CONTROLLER_TV_CURRENT_TIME"
                assertEquals(
                    messageWrongInitialCurrentTime,
                    expectedCurrentTime,
                    actualCurrentTime
                )
            }
            controllerTvCurrentTime
        }
    }

    val controllerTvTotalTime by lazy {
        with(test) {
            val controllerTvTotalTime = mainFragmentContainer
                .findViewByString<TextView>(ID_CONTROLLER_TV_TOTAL_TIME)
            if(initAssertions) {
                val actualTotalTime = controllerTvTotalTime.text.toString()
                val expectedTotalTime = "00:00"
                val messageWrongInitialTotalTime =
                    "Wrong initial value for $ID_CONTROLLER_TV_TOTAL_TIME"
                assertEquals(
                    messageWrongInitialTotalTime,
                    expectedTotalTime,
                    actualTotalTime
                )
            }
            controllerTvTotalTime
        }
    }

    val controllerSeekBar by lazy {
        with(test) {
            mainFragmentContainer
                .findViewByString<SeekBar>(ID_CONTROLLER_SEEKBAR)
        }
    }

    val controllerBtnPlayPause by lazy {
        with(test) {
            val controllerBtnPlayPause = mainFragmentContainer
                .findViewByString<Button>(ID_CONTROLLER_BTN_PLAY_PAUSE)
            if(initAssertions) {
                val actualBtnPlayPauseText = controllerBtnPlayPause.text.toString().lowercase()
                val expectedBtnPlayPauseText = "play/pause"
                val messageWrongInitialBtnPlayPauseText =
                    "Wrong initial value for $ID_CONTROLLER_BTN_PLAY_PAUSE"
                assertEquals(
                    messageWrongInitialBtnPlayPauseText,
                    expectedBtnPlayPauseText,
                    actualBtnPlayPauseText
                )
            }
            controllerBtnPlayPause
        }
    }

    val controllerBtnStop by lazy {
        with(test) {
            val controllerBtnStop = mainFragmentContainer
                .findViewByString<Button>(ID_CONTROLLER_BTN_STOP)
            val actualBtnStopText = controllerBtnStop.text.toString().lowercase()
            val expectedBtnStopText = "stop"
            val messageWrongInitialBtnStopText = "Wrong initial value for $ID_CONTROLLER_BTN_STOP"
            assertEquals(
                messageWrongInitialBtnStopText,
                expectedBtnStopText,
                actualBtnStopText
            )
            controllerBtnStop
        }
    }

    fun songItemImgBtnPlayPauseSupplier(itemViewSupplier: () -> View) = with(test){
        itemViewSupplier().findViewByString<ImageButton>(ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE)
    }

    fun songItemImgBtnPlayPauseSupplier(itemView: View) = with(test){
        itemView.findViewByString<ImageButton>(ID_SONG_ITEM_IMG_BTN_PLAY_PAUSE)
    }

    fun assertSongItem(errorMessage: String, itemView: View, song: SongFake) = with(test) {
        val songItemTvArtist = itemView.findViewByStringOrNull<TextView>(ID_SONG_ITEM_TV_ARTIST)
            ?: throw AssertionError("$errorMessage Could not find view $ID_SONG_ITEM_TV_ARTIST")
        val songItemTvTitle = itemView.findViewByStringOrNull<TextView>(ID_SONG_ITEM_TV_TITLE)
            ?: throw AssertionError("$errorMessage Could not find view $ID_SONG_ITEM_TV_TITLE")
        val songItemTvDuration = itemView.findViewByStringOrNull<TextView>(ID_SONG_ITEM_TV_DURATION)
            ?: throw AssertionError("$errorMessage Could not find view $ID_SONG_ITEM_TV_DURATION")

        assertEquals("$errorMessage Wrong text on $ID_SONG_ITEM_TV_ARTIST", song.artist, songItemTvArtist.text.toString())
        assertEquals("$errorMessage Wrong text $ID_SONG_ITEM_TV_TITLE", song.title, songItemTvTitle.text.toString())
        assertEquals(
            "$errorMessage Wrong text on $ID_SONG_ITEM_TV_DURATION",
            song.duration.timeString(),
            songItemTvDuration.text.toString()
        )
    }

    fun assertControllerState(
        errorMessage: String, songFake: SongFake, expectedPosition: Int
    ) = with(test) {
        val messageTotalTimeTv = "$errorMessage On controllerTvTotalTime text"
        assertEquals(messageTotalTimeTv, songFake.duration.timeString(), controllerTvTotalTime.text.toString())

        val messageSeekBar = "$errorMessage On controllerSeekBar progress"
        assertEquals(messageSeekBar, expectedPosition / 1000, controllerSeekBar.progress)

        val messageCurrentTimeTv = "$errorMessage On controllerTvCurrentTime text"
        assertEquals(messageCurrentTimeTv, expectedPosition.timeString(), controllerTvCurrentTime.text.toString())
    }

    fun MediaPlayer.assertControllerPlay(errorMessage: String, expectedPosition: Int) {
        assertController(errorMessage, expectedPosition, expectedIsPlaying = true)
    }

    fun MediaPlayer.assertControllerPause(errorMessage: String, expectedPosition: Int) {
        assertController(errorMessage, expectedPosition, expectedIsPlaying = false)
    }

    fun MediaPlayer.assertControllerStop(errorMessage: String) {
        assertController(errorMessage, expectedPosition = 0, expectedIsPlaying = false)
    }

    private fun MediaPlayer.assertController(
        errorMessage: String,
        expectedPosition: Int,
        expectedIsPlaying: Boolean
    ) = with(test) {
        assertEquals("$errorMessage On mediaPlayer isPlaying", expectedIsPlaying, isPlaying)

        val messageCurrentPosition = "$errorMessage On mediaPlayer currentPosition expected: $expectedPosition found: $currentPosition"
        Assert.assertTrue(messageCurrentPosition, abs(expectedPosition - currentPosition) < 100)

        val messageSeekBar = "$errorMessage On controllerSeekBar progress"
        assertEquals(messageSeekBar, expectedPosition / 1000, controllerSeekBar.progress)

        val messageCurrentTimeTv = "$errorMessage On controllerTvCurrentTime text"
        assertEquals(messageCurrentTimeTv, expectedPosition.timeString(), controllerTvCurrentTime.text.toString())
    }
}