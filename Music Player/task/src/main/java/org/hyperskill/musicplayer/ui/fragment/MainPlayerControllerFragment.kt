package org.hyperskill.musicplayer.ui.fragment

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.videochat.architecture.ui.view.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.hyperskill.musicplayer.common.extension.formatDuration
import org.hyperskill.musicplayer.databinding.MainPlayerControllerFragmentBinding
import org.hyperskill.musicplayer.presentation.model.PlaybackStatus
import org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel
import org.hyperskill.musicplayer.ui.adapter.SongAdapter
import org.hyperskill.musicplayer.ui.binder.MainPlayerControllerFragmentBinder
import org.hyperskill.musicplayer.ui.holder.MainPlayerControllerViewsHolder
import org.hyperskill.musicplayer.ui.mapper.SongToUiMapper
import org.hyperskill.musicplayer.ui.model.ActionUiState
import org.hyperskill.musicplayer.ui.model.SongPlayMode
import org.hyperskill.musicplayer.ui.model.SongTrackUiModel
import org.hyperskill.musicplayer.ui.provider.MainPlayerControllerViewsProvider
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainPlayerControllerFragment : BaseFragment<ActionUiState,MainPlayerControllerViewsProvider,MainPlayerControllerFragmentBinding>() {

    private lateinit var viewHolder: MainPlayerControllerViewsHolder
    override lateinit var viewStateBinder: MainPlayerControllerFragmentBinder

    override val viewModel: MusicPlayerViewModel by sharedViewModel()
    private val songToUiMapper: SongToUiMapper by inject()

    var adapter:SongAdapter? = null

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainPlayerControllerFragmentBinding {
        val binding = MainPlayerControllerFragmentBinding.inflate(inflater, container, false)
        viewHolder = MainPlayerControllerViewsHolder(binding.root)
        viewStateBinder = MainPlayerControllerFragmentBinder(viewHolder)
        return binding
    }

    override fun View.bindViews() {
        setupViews()
    }

    override fun setupViews() {
        setControllerBtnStop()
        setControllerBtnPlayPause()
        setCurrentChangeOnTrack()
        setSeekBar()
        setObserverOnWorker()
    }

    private fun setControllerBtnPlayPause() {
        binding.controllerBtnPlayPause.setOnClickListener {
            val currentSong = viewModel.getCurrentTrack()
            currentSong?.let {
                val mode = if(currentSong.songPlayMode == SongPlayMode.PLAYING)
                    SongPlayMode.PAUSE
                else if(currentSong.songPlayMode == SongPlayMode.STOP) SongPlayMode.PLAYING
                else SongPlayMode.PLAYING
                viewModel.setCurrentMusic(SongTrackPresentationModel(currentSong.song,mode))
                val trackModel = SongTrackUiModel(songToUiMapper.map(currentSong.song),mode)
                adapter?.setCurrentTrack(trackModel)
            }
        }
    }

    private fun setControllerBtnStop() {
        binding.controllerBtnStop.setOnClickListener {
            viewModel.setCurrentMusic(
                viewModel.getCurrentTrack()?.apply {
                    songPlayMode = SongPlayMode.STOP
                }
            )
            updateSeekBarAndTime(0)
            adapter?.changeCurrentTrackMode(SongPlayMode.STOP)
        }
    }

    private fun setCurrentChangeOnTrack() {
        lifecycleScope.launchWhenStarted {
            launch {
                viewModel.currentSong.collect { track ->
                    track?.let {
                        setControllerTvTotalTime(it.song.duration)
                        setMaxDuration(it.song.duration)
                    }
                }
            }
        }
    }

    private fun setControllerTvTotalTime(value: Long){
        val tvText = formatDuration(value)
        binding.controllerTvTotalTime.text = tvText
    }

    private fun setSeekBar() {
        binding.controllerSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    binding.controllerTvCurrentTime.text = formatDurationInSeconds(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                val seekToPosition = (seekBar?.progress ?: 0) * 1000
                viewModel.seekPosition(seekToPosition)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val progressValue = seekBar?.progress ?: 0
                val seekToPosition = (progressValue) * 1000
                viewModel.seekPosition(seekToPosition)
                viewModel.getCurrentPlayBack().let {
                    if (it != null) {
                        viewModel.setPlaybackModel(seekToPosition.toLong(), it.status)
                    }
                }
            }
        })
    }

    private fun setObserverOnWorker(){
        lifecycleScope.launchWhenStarted {
            viewModel.currentPlayBack.collect {
                playback ->
                    if (playback != null) {
                        when(playback.status){
                            PlaybackStatus.CONTINUE ->{
                                updateSeekBarAndTime(playback.currentPosition)
                            }
                            PlaybackStatus.FINISH -> {
                                val currentTrack = viewModel.getCurrentTrack()
                                currentTrack?.let {
                                    viewModel.setCurrentMusic(
                                        it.apply {
                                            songPlayMode = SongPlayMode.STOP
                                        }
                                    )
                                    val track = SongTrackUiModel(songToUiMapper.map(it.song), SongPlayMode.STOP)
                                    adapter?.setCurrentTrack(track)
                                }
                                updateSeekBarAndTime(playback.currentPosition)
                            }
                            PlaybackStatus.PAUSE -> updateSeekBarAndTime(playback.currentPosition)
                            PlaybackStatus.LAND ->  updateSeekBarAndTime(playback.currentPosition)
                        }
                    }
            }
        }

    }

    private fun updateSeekBarAndTime(currentPosition: Long) {
        val progressPos: Int = (currentPosition / 1000).toInt()
        Log.d("Player",currentPosition.toString())
        binding.controllerSeekBar.progress = progressPos
        binding.controllerTvCurrentTime.text = formatDurationInSeconds(progressPos)
    }

    private fun setMaxDuration(duration: Long) {
        binding.controllerSeekBar.max = (duration.div(1000)).toInt()
    }

    @SuppressLint("DefaultLocale")
    private fun formatDurationInSeconds(durationInSeconds: Int): String {
        val minutes = durationInSeconds / 60
        val seconds = durationInSeconds % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}