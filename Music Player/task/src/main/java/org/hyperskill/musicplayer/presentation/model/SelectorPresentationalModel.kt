package org.hyperskill.musicplayer.presentation.model

import java.util.UUID

data class SelectorPresentationalModel (
    var playlistId: UUID,
    var playlistTitle: String,
    var songSelector: List<SongSelectorPresentationModel>
)