package org.hyperskill.musicplayer.presentation.model

data class PlaybackPresentationModel (
    val song: SongPresentationModel,
    val currentPosition: Long,
    val status: PlaybackStatus
)