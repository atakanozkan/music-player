package org.hyperskill.musicplayer.ui.model

sealed class ActionUiState {
    object PLAY_MUSIC : ActionUiState()
    object ADD_PLAYLIST : ActionUiState()
}