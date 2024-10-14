package org.hyperskill.musicplayer.presentation.model

data class SongPresentationModel(
    val id : Long,
    val title: String,
    val artist: String,
    var duration: Long
)