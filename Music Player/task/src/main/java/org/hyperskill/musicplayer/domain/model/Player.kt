package org.hyperskill.musicplayer.domain

import org.hyperskill.musicplayer.presentation.model.SongPresentationModel


interface Player {
    fun playSong(song: SongPresentationModel)
    fun seek(ms: Long)
    fun pauseOrPlay()
    fun stop()
    fun dispose()
    fun prepare(input: SongPresentationModel, playAfter: Boolean)
}