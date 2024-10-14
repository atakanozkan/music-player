package org.hyperskill.musicplayer.ui.binder

import com.videochat.architecture.ui.binder.ViewStateBinder
import org.hyperskill.musicplayer.ui.listener.ActionStateEventListener
import org.hyperskill.musicplayer.ui.holder.MainActivityViewsHolder
import org.hyperskill.musicplayer.ui.model.ActionUiState
import org.hyperskill.musicplayer.ui.provider.MainActivityViewsProvider

class MainActivityBinder (
    private val mainActivityViewsHolder: MainActivityViewsHolder,
    private val actionStateEventListener: ActionStateEventListener
) : ViewStateBinder<ActionUiState, MainActivityViewsProvider>, ActionStateEventListener by actionStateEventListener{

    override fun MainActivityViewsProvider.bindState(viewState: ActionUiState){
        when (viewState) {
            is ActionUiState.PLAY_MUSIC -> {
                onPlayMusic()
            }
            is ActionUiState.ADD_PLAYLIST-> {
                onAddPlaylist()
            }
        }
    }

    override fun bind(viewState: ActionUiState) {
        mainActivityViewsHolder.bindState(viewState)
    }
}