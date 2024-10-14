package org.hyperskill.musicplayer.ui.model

import org.hyperskill.musicplayer.presentation.model.SongPresentationModel
import java.util.UUID

data class PlaylistUiModel(
    val id: UUID,
    val title: String,
    var songs : MutableList<SongPresentationModel>
)