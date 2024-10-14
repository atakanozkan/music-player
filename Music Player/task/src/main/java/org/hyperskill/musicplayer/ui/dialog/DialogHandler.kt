package org.hyperskill.musicplayer.ui.dialog

import android.content.Context
import android.app.AlertDialog
import org.hyperskill.musicplayer.R
import org.hyperskill.musicplayer.common.constant.Constants.ALL_SONGS
import org.hyperskill.musicplayer.presentation.model.SongPresentationModel
import org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel
import org.hyperskill.musicplayer.ui.model.ActionUiState
import org.hyperskill.musicplayer.ui.model.SongPlayMode

class DialogHandler(
    private val context: Context,
    private val playlistViewModel: MusicPlaylistViewModel,
    private val selectorViewModel: MusicSelectorViewModel,
    private val playerViewModel: MusicPlayerViewModel
) {

    private val onSetCurrentSong: (SongPresentationModel, SongPlayMode) -> Unit = { song, playMode ->
        playerViewModel.setCurrentMusic(
            SongTrackPresentationModel(
                song,
                playMode
            )
        )
    }

    fun showDeletePlaylistDialog() {
        val allSongsPlaylist = playlistViewModel.allSongs
        val playLists = playlistViewModel.playlists.keys.filter{ it != allSongsPlaylist.title }
        val dialogBuilder = AlertDialog.Builder(context)
        val dialog = dialogBuilder
            .setTitle(context.getString(R.string.alert_delete_playlist))
            .setItems(playLists.toTypedArray()) { _, i ->
                val selectedPlaylist = playlistViewModel.playlists[playLists[i]]
                selectedPlaylist?.let {
                    playlistViewModel.deletePlaylist(it.id)
                    if(selectorViewModel.isPlaylistSame(it.id)){
                        selectorViewModel.setAllSelector(
                            allSongsPlaylist.id,
                            allSongsPlaylist.title,
                            allSongsPlaylist.songs
                        )
                    }
                }

            }
            .setNegativeButton(context.getString(R.string.alert_dialog_cancel), null)
            .setCancelable(true)
            .create()
        dialog.show()
    }

    fun showLoadPlaylistDialog() {
        val playLists = playlistViewModel.playlists
        val playListKeys = playLists.keys.toList()
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder
            .setTitle(context.getString(R.string.alert_load_playlist))
            .setItems(playListKeys.toTypedArray()){
                    _, i ->
                val title = playListKeys[i]
                val selectedPlaylist = playLists[title] ?: return@setItems

                if(playlistViewModel.uiState.value == ActionUiState.ADD_PLAYLIST){
                    selectorViewModel.setCurrentSelectors(selectedPlaylist.songs)
                    selectorViewModel.setAllSelector(selectedPlaylist.id,selectedPlaylist.title,selectedPlaylist.songs)
                }
                else{
                    val currentTrack = playerViewModel.getCurrentTrack()
                    if(title != ALL_SONGS){
                        playlistViewModel.loadPlaylistFromDb(title)
                    }
                    else{
                        playlistViewModel.checkForAutoLoadAll()
                    }
                    playlistViewModel.setCurrentPlaylist(
                        selectedPlaylist.id,
                        currentTrack,
                        onSetCurrentSong
                    )
                }
            }
            .setNegativeButton(context.getString(R.string.alert_dialog_cancel), null)
            .setCancelable(true)
            .create()
            .show()
    }
}
