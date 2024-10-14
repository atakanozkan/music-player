package org.hyperskill.musicplayer.presentation.model

import org.hyperskill.musicplayer.ui.model.SongPlayMode

data class SongTrackPresentationModel (
    val song: SongPresentationModel,
    var songPlayMode: SongPlayMode
)