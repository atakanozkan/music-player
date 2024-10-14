package org.hyperskill.musicplayer.ui.handler

import org.hyperskill.musicplayer.architecture.ui.event.EventHandler
import org.hyperskill.musicplayer.ui.listener.SongSelectListener
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel

class AdapterSelectListenerEvent(
    private val playlistViewModel: MusicPlaylistViewModel,
    private val selectorViewModel: MusicSelectorViewModel,
): EventHandler {

    override fun getEventHandler(): SongSelectListener = object : SongSelectListener {
        override fun onClick(id: Long,isSelected: Boolean) {
            val selectedSong = playlistViewModel.getSongFromCurrentPlaylist(id)
            if (isSelected){
                selectedSong?.let {
                    if(!selectorViewModel.doesSongExistInSelector(it)){
                        selectorViewModel.addSelectedMusic(it)
                    }
                }
            }
            else{
                selectedSong?.let {
                    selectorViewModel.removeSelectedMusic(it)
                }
            }
        }
    }
}