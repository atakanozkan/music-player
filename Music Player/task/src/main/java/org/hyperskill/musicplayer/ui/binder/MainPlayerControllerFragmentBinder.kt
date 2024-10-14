package org.hyperskill.musicplayer.ui.binder

import com.videochat.architecture.ui.binder.ViewStateBinder
import org.hyperskill.musicplayer.ui.holder.MainPlayerControllerViewsHolder
import org.hyperskill.musicplayer.ui.model.ActionUiState
import org.hyperskill.musicplayer.ui.provider.MainPlayerControllerViewsProvider

class MainPlayerControllerFragmentBinder(
    private val mainPlayerControllerViewsHolder : MainPlayerControllerViewsHolder
) : ViewStateBinder<ActionUiState,MainPlayerControllerViewsProvider> {

    override fun MainPlayerControllerViewsProvider.bindState(viewState: ActionUiState) {

    }

    override fun bind(viewState: ActionUiState) {
        mainPlayerControllerViewsHolder.bindState(viewState)
    }

}