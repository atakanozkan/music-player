package org.hyperskill.musicplayer.ui.binder

import com.videochat.architecture.ui.binder.ViewStateBinder
import org.hyperskill.musicplayer.ui.holder.MainAddPlaylistViewsHolder
import org.hyperskill.musicplayer.ui.model.ActionUiState
import org.hyperskill.musicplayer.ui.provider.MainAddPlaylistViewsProvider

class MainAddPlaylistFragmentBinder(
    private val mainPlayerControllerViewsHolder : MainAddPlaylistViewsHolder
) : ViewStateBinder<ActionUiState, MainAddPlaylistViewsProvider> {

    override fun bind(viewState: ActionUiState) {
        mainPlayerControllerViewsHolder.bindState(viewState)
    }

    override fun MainAddPlaylistViewsProvider.bindState(viewState: ActionUiState) {

    }

}