package org.hyperskill.musicplayer.presentation.viewModel

import android.content.ContentUris
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.viewModelScope
import com.videochat.architecture.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel
import org.hyperskill.musicplayer.controller.player.PlayerController
import org.hyperskill.musicplayer.presentation.model.PlaybackPresentationModel
import org.hyperskill.musicplayer.presentation.model.PlaybackStatus
import org.hyperskill.musicplayer.ui.model.ActionUiState
import org.hyperskill.musicplayer.ui.model.SongPlayMode

class MusicPlayerViewModel: BaseViewModel<ActionUiState>(ActionUiState.PLAY_MUSIC) {
    private val _currentSong = MutableSharedFlow<SongTrackPresentationModel?>(
        replay = 2)
    val currentSong: SharedFlow<SongTrackPresentationModel?>
        get() = _currentSong.asSharedFlow()

    private val _currentPlayBack = MutableSharedFlow<PlaybackPresentationModel?>(
        replay = 1)
    val currentPlayBack: SharedFlow<PlaybackPresentationModel?>
        get() = _currentPlayBack.asSharedFlow()

    private var playerController: PlayerController? = null

    fun getCurrentTrack(): SongTrackPresentationModel?{
        if(currentSong.replayCache.isEmpty()) return null
        if(currentSong.replayCache.count() == 1) return currentSong.replayCache.first()
        return currentSong.replayCache[1]
    }

    fun getCurrentPlayBack(): PlaybackPresentationModel?{
        if(currentPlayBack.replayCache.isEmpty()) return null
        if(currentPlayBack.replayCache.count() == 1) return currentPlayBack.replayCache.first()
        return null
    }

    fun setCurrentMusic(song: SongTrackPresentationModel?){
        viewModelScope.launch {
            _currentSong.emit(song)
            setPlaybackModel(0,PlaybackStatus.LAND)
        }
    }

    fun getPreviousTrack() : SongTrackPresentationModel?{
        if(currentSong.replayCache.isEmpty() || currentSong.replayCache.count() != 2) return null
        return currentSong.replayCache[0]
    }

    fun setPlayer(manager: PlayerController?) {
        playerController = manager
    }

    override fun onCleared() {
        super.onCleared()
        playerController?.stopMusic()
    }

    private fun playMusic() {
        playerController?.startPlaying()
    }

    private fun pauseMusic(){
        playerController?.pauseMusic()
    }

    private fun stopMusic(){
        playerController?.stopMusic()
    }

    fun seekPosition(pos: Int){
        playerController?.seek(pos)
    }

    fun setCurrentChangeOnTrack() {
        viewModelScope.launch {
            currentSong.collect{
                if (it != null) {
                    checkChangeToNewMusic(it.song.id,it)
                    when (it.songPlayMode) {
                        SongPlayMode.PLAYING -> {
                            playMusic()
                        }
                        SongPlayMode.PAUSE -> {
                            pauseMusic()
                        }

                        SongPlayMode.STOP -> {
                            stopMusic()
                        }
                    }
                }
            }
        }
    }

    fun setPlaybackModel(currentPos: Long,playbackStatus: PlaybackStatus){
        viewModelScope.launch {
            getCurrentTrack()?.let{
                val playback = PlaybackPresentationModel(it.song,currentPos,playbackStatus)
                _currentPlayBack.emit(playback)
            }
        }
    }

    private fun checkChangeToNewMusic(id: Long,song: SongTrackPresentationModel) {
        getPreviousTrack()?.let {
            val uri = getUri(id)
            if (it.song.id != id) {
                setPlaybackModel(0,PlaybackStatus.LAND)
                playerController?.playSong(uri)
                return
            }
            if (it.songPlayMode == SongPlayMode.STOP && song.songPlayMode!= SongPlayMode.STOP){
                setPlaybackModel(0,PlaybackStatus.LAND)
                playerController?.playSong(uri)
                return
            }
        }
    }

    private fun getUri(id: Long) : Uri{
        return ContentUris.withAppendedId(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            id)
    }
}