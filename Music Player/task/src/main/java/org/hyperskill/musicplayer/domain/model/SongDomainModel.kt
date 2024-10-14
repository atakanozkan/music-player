package org.hyperskill.musicplayer.domain.model

data class SongDomainModel(
    val id : Long,
    val title: String,
    val artist: String,
    val duration: Long
)