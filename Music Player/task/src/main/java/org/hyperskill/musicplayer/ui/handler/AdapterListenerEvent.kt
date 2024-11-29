package org.hyperskill.musicplayer.ui.handler

import org.hyperskill.musicplayer.base.ui.event.EventHandler
import org.hyperskill.musicplayer.ui.listener.SongClickListener
import org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel
import org.hyperskill.musicplayer.ui.adapter.SongAdapter
import org.hyperskill.musicplayer.ui.mapper.SongTrackToUiMapper
import org.hyperskill.musicplayer.ui.model.SongPlayMode

class AdapterListenerEvent(
    private val playerViewModel: MusicPlayerViewModel,
    private val playlistViewModel: MusicPlaylistViewModel,
    private val selectorViewModel: MusicSelectorViewModel,
    private val mapper: SongTrackToUiMapper,
    private val songAdapter: SongAdapter,
    private val longClickEvent: () -> Unit
): EventHandler{

    override fun getEventHandler(): SongClickListener = object :
        SongClickListener {
        override fun onClick(id: Long) {
            val song = playlistViewModel.getSongFromCurrentPlaylist(id)
            song?.let {
                val currentSong = playerViewModel.getCurrentTrack()
                if(currentSong == null || currentSong.song.id != it.id){
                    val songTrack = SongTrackPresentationModel(it, SongPlayMode.PLAYING)
                    playerViewModel.setCurrentMusic(songTrack)
                    songAdapter.setCurrentTrack(mapper.map(songTrack))
                }
                else{
                    val mode = if(currentSong.songPlayMode == SongPlayMode.PLAYING) SongPlayMode.PAUSE else SongPlayMode.PLAYING
                    val songTrack  = SongTrackPresentationModel(it, mode)
                    songAdapter.setCurrentTrack(mapper.map(songTrack))
                    playerViewModel.setCurrentMusic(songTrack)
                }
            }
        }

        override fun onLongClick(id: Long) {
            val song = playlistViewModel.getSongFromCurrentPlaylist(id)
            song?.let {
                if (!selectorViewModel.doesSongExistInSelector(it)) {
                    selectorViewModel.addSelectedMusic(it)
                }
            }
            longClickEvent()
        }
    }

}