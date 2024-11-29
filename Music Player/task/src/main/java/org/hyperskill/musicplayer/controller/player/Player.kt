package org.hyperskill.musicplayer.controller.player

import android.media.MediaPlayer
import android.net.Uri

interface Player {
    fun playSong(uri: Uri): MediaPlayer?
    fun startPlaying()
    fun prepareMediaPlayer(uri: Uri): MediaPlayer?
    fun seek(ms: Int)
    fun pauseMusic()
    fun stopMusic()
    fun dispose()
}