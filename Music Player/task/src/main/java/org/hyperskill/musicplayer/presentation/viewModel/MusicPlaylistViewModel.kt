package org.hyperskill.musicplayer.presentation.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.videochat.architecture.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.hyperskill.musicplayer.common.constant.Constants
import org.hyperskill.musicplayer.data.db.MusicPlayerDatabase
import org.hyperskill.musicplayer.domain.usecase.GetSongFromMediaByIdUseCase
import org.hyperskill.musicplayer.domain.usecase.RetrieveAllSongsFromMediaUseCase
import org.hyperskill.musicplayer.presentation.mapper.SongDomainToPresentationMapper
import org.hyperskill.musicplayer.presentation.model.PlaylistPresentationModel
import org.hyperskill.musicplayer.presentation.model.SongPresentationModel
import org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel
import org.hyperskill.musicplayer.ui.model.ActionUiState
import org.hyperskill.musicplayer.ui.model.SongPlayMode
import java.util.UUID

class MusicPlaylistViewModel(
    private val musicPlayerDatabase : MusicPlayerDatabase,
    private val retrieveAllSongsFromMediaUseCase: RetrieveAllSongsFromMediaUseCase,
    private val getSongFromMediaByIdUseCase: GetSongFromMediaByIdUseCase,
    private val songMapper: SongDomainToPresentationMapper
) : BaseViewModel<ActionUiState>(ActionUiState.PLAY_MUSIC) {
    val allSongs = PlaylistPresentationModel(generateUniqueID(), Constants.ALL_SONGS, mutableListOf())

    val playlists = mutableMapOf<String,PlaylistPresentationModel>()

    private val _currentPlaylist = MutableStateFlow<PlaylistPresentationModel?>(null)
    val currentPlaylist: StateFlow<PlaylistPresentationModel?>
        get() = _currentPlaylist.asStateFlow()

    fun loadAllPlaylistsFromDb() {
        viewModelScope.launch(Dispatchers.IO){
            val allPlaylistEntries = musicPlayerDatabase.getAllPlaylistsGrouped()
            playlists[Constants.ALL_SONGS] = allSongs
            allPlaylistEntries.forEach { (playlistName, songIds) ->
                val songModels = songIds.mapNotNull { id ->
                    getSongFromMediaByIdUseCase.execute(id).getOrNull()
                }.map {
                    songMapper.map(it)
                }.toMutableList()
                val playlist = PlaylistPresentationModel(
                    id = generateUniqueID(),
                    title = playlistName,
                    songs = songModels
                )
                playlists[playlistName] = playlist
            }
        }
    }

    fun loadPlaylistFromDb(playlistName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val playlistEntries = musicPlayerDatabase.getPlaylist(playlistName)
            val existPlaylist = playlists[playlistName]


            val playlist = PlaylistPresentationModel(
                id = existPlaylist?.id ?: generateUniqueID(),
                title = playlistName,
                songs = mutableListOf()
            )
            playlistEntries.forEach { (_, songId) ->
                val songModel = getSongFromMediaByIdUseCase.execute(songId).getOrNull()
                if (songModel != null){
                    playlist.songs.add(songMapper.map(songModel))
                }
            }
            if (playlist.songs.isNotEmpty()){
                playlists[playlistName] = playlist
            }
        }
    }

    fun checkForAutoLoadAll() {
        if (allSongs.songs.isEmpty()) {
            val addedSongIds = mutableSetOf<Long>()
            val allPlaylists = playlists.values
            allPlaylists.forEach { playlist ->
                playlist.songs.forEach { song ->
                    if (!addedSongIds.contains(song.id)) {
                        viewModelScope.launch(Dispatchers.IO){
                            val modelResult = async {
                                val songModel = getSongFromMediaByIdUseCase.execute(song.id).getOrNull()
                                songModel
                            }.await()
                            withContext(Dispatchers.Main){
                                if (modelResult != null) {
                                    allSongs.songs.add(songMapper.map(modelResult))
                                }
                                addedSongIds.add(song.id)
                            }
                        }
                    }
                }
            }
        }
    }

    fun createPlaylist(playlistName: String, songList: List<SongPresentationModel>){
        val existPlaylist = playlists[playlistName]
        val playlist = PlaylistPresentationModel(
            id = existPlaylist?.id ?: generateUniqueID(),
            title = playlistName,
            songs = songList.toMutableList()
        )
        playlists[playlistName] = playlist
        musicPlayerDatabase.addPlaylist(
            playlistName,
            songList.map { it.id }
        )
    }

    fun deletePlaylist(id : UUID){
        val foundPlaylist = playlists.values.find{ it.id == id }
        val currentPlaylist = currentPlaylist.value
        foundPlaylist?.let {
            if(it.title == Constants.ALL_SONGS){
                return
            }
            if (currentPlaylist != null) {
                if(currentPlaylist.id == it.id){
                    _currentPlaylist.value = allSongs
                }
            }
            playlists.remove(it.title)
            musicPlayerDatabase.removePlaylist(it.title)
        }
    }

    fun getSongFromCurrentPlaylist(id: Long): SongPresentationModel?{
        return _currentPlaylist.value?.songs?.find { it.id == id }
    }

    fun setAllSongs() {
        try {
            viewModelScope.launch (Dispatchers.IO) {
                val result = async {
                    val resultList = retrieveAllSongsFromMediaUseCase.execute(
                        input = Unit
                    ).getOrThrow()
                    resultList
                }.await()
                withContext(Dispatchers.Main){
                    allSongs.songs = songMapper.mapList(result).toMutableList()
                    playlists[Constants.ALL_SONGS] = allSongs
                }
            }
        }
        catch (e: Exception){
            Log.e("MusicPlayerViewModel",e.message.toString())
        }
    }

    fun setCurrentPlaylist(id : UUID,currentSong: SongTrackPresentationModel?, onSetCurrentSong: ( SongPresentationModel,SongPlayMode) -> Unit){
        val playlistChosen =  playlists.values.find { it.id == id }
        val songOnCurrentPlay = currentSong?.song
        if (playlistChosen== null || playlistChosen.songs.isEmpty())
            return
        if (songOnCurrentPlay == null ){
            playlistChosen.let {
                _currentPlaylist.value =it
                onSetCurrentSong(
                    it.songs.first(),
                    SongPlayMode.STOP
                )
            }
        }
        else{
            playlistChosen.let {
                _currentPlaylist.value =it
                if (!it.songs.contains(songOnCurrentPlay))
                    if (it.songs.isNotEmpty()) {
                        onSetCurrentSong(
                            it.songs.first(),
                            SongPlayMode.STOP
                        )
                    }
            }
        }
    }

    private fun generateUniqueID(): UUID{
        return UUID.randomUUID()
    }

}