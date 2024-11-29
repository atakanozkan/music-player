package org.hyperskill.musicplayer.ui.handler

import org.hyperskill.musicplayer.base.ui.event.EventHandler
import org.hyperskill.musicplayer.controller.ui.FragmentTransactionController
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel
import org.hyperskill.musicplayer.ui.adapter.SongAdapter
import org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter
import org.hyperskill.musicplayer.ui.listener.ActionStateEventListener

class MainEventHandler(
    private val fragmentTransactionController: FragmentTransactionController,
    private val playlistViewModel: MusicPlaylistViewModel,
    private val selectorViewModel: MusicSelectorViewModel,
    private val songAdapter: SongAdapter,
    private val songSelectorAdapter: SongSelectorAdapter
) : EventHandler {

    override fun getEventHandler(): ActionStateEventListener = object :
        ActionStateEventListener {
        override fun onPlayMusic() {
            fragmentTransactionController.attachMainPlayerControllerFragment(songAdapter)
        }

        override fun onAddPlaylist() {
            resetAllSongsOnAdd()
            fragmentTransactionController.attachMainAddPlaylistFragment(songAdapter,songSelectorAdapter)
        }

        fun resetAllSongsOnAdd(){
            playlistViewModel.allSongs.let {
                selectorViewModel.setAllSelector(it.id,it.title,it.songs)
            }
        }
    }
}