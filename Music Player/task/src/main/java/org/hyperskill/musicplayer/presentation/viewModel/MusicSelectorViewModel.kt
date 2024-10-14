package org.hyperskill.musicplayer.presentation.viewModel

import com.videochat.architecture.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.hyperskill.musicplayer.presentation.model.SelectorPresentationalModel
import org.hyperskill.musicplayer.presentation.model.SongPresentationModel
import org.hyperskill.musicplayer.presentation.model.SongSelectorPresentationModel
import org.hyperskill.musicplayer.ui.model.ActionUiState
import java.util.UUID

class MusicSelectorViewModel : BaseViewModel<ActionUiState>(ActionUiState.ADD_PLAYLIST) {
    private val _currentSelectedSongs = MutableStateFlow<MutableList<SongPresentationModel>>(
        mutableListOf()
    )
    val currentSelectedSongs: StateFlow<MutableList<SongPresentationModel>>
        get() = _currentSelectedSongs.asStateFlow()

    private val _allSelectorSongs = MutableStateFlow<SelectorPresentationalModel?>(
        null
    )
    val allSelectorSongs: StateFlow<SelectorPresentationalModel?>
        get() = _allSelectorSongs.asStateFlow()

    fun addSelectedMusic(song: SongPresentationModel){
        _currentSelectedSongs.value.add(song)
    }

    fun removeSelectedMusic(song: SongPresentationModel){
        _currentSelectedSongs.value.remove(song)
    }

    fun clearSelectedMusics(){
        _currentSelectedSongs.value.clear()
    }

    fun doesSongExistInSelector(song: SongPresentationModel): Boolean{
        return _currentSelectedSongs.value.contains(song)
    }

    fun isPlaylistSame(playlistId: UUID): Boolean{
        return (_allSelectorSongs.value?.playlistId ?: false) == playlistId
    }

    fun setCurrentSelectors(playList: List<SongPresentationModel>){
        val currentList = _currentSelectedSongs.value
        val setList = currentList.filter {
            playList.contains(it)
        }
        _currentSelectedSongs.value = setList.toMutableList()
    }

    fun setAllSelector(playlistId: UUID, title:String, list: List<SongPresentationModel>){
        val selectorSongList = list.map {
            SongSelectorPresentationModel(
                it,
                doesSongExistInSelector(it)
            )
        }
        val model =
            SelectorPresentationalModel(
                playlistId,
                title,
                selectorSongList
            )
        _allSelectorSongs.value = model
    }

    fun clearAllSelector(){
        _allSelectorSongs.value = null
    }

}