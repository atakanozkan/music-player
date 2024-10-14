package org.hyperskill.musicplayer.presentation.model

import java.util.UUID

data class PlaylistPresentationModel(
    val id: UUID,
    val title: String,
    var songs : MutableList<SongPresentationModel>
)