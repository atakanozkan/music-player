package org.hyperskill.musicplayer.ui.model

import org.hyperskill.musicplayer.presentation.model.SongSelectorPresentationModel

data class SelectorUiModel(
    var playlistTitle: String,
    var selectorModel: List<SongSelectorPresentationModel>
)