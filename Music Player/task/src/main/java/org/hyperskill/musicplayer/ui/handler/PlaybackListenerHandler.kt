package org.hyperskill.musicplayer.ui.handler

import org.hyperskill.musicplayer.base.ui.event.EventHandler
import org.hyperskill.musicplayer.ui.listener.PlaybackEventListener
import org.hyperskill.musicplayer.presentation.model.PlaybackStatus
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel

class PlaybackListenerHandler(
    private val playerViewModel: MusicPlayerViewModel
): EventHandler {

    override fun getEventHandler(): PlaybackEventListener = object : PlaybackEventListener {
        override fun onPlaybackComplete() {
            playerViewModel.setPlaybackModel(0, PlaybackStatus.FINISH)
        }

        override fun onPlaybackStart(): Int {
            return (playerViewModel.getCurrentPlayBack()?.currentPosition ?: 0).toInt()
        }

        override fun onPlaybackPause(position: Long) {
            playerViewModel.setPlaybackModel(position, PlaybackStatus.PAUSE)
        }

        override fun onPlaybackContinue(position: Long) {
            playerViewModel.setPlaybackModel(position, PlaybackStatus.CONTINUE)
        }

        override fun onPlaybackStop(position: Long) {
            playerViewModel.setPlaybackModel(0, PlaybackStatus.FINISH)
        }
    }
}