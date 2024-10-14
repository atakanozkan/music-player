package org.hyperskill.musicplayer.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.videochat.architecture.ui.view.BaseFragment
import org.hyperskill.musicplayer.R
import org.hyperskill.musicplayer.common.constant.Constants
import org.hyperskill.musicplayer.databinding.MainAddPlaylistFragmentBinding
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel
import org.hyperskill.musicplayer.ui.adapter.SongAdapter
import org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter
import org.hyperskill.musicplayer.ui.binder.MainAddPlaylistFragmentBinder
import org.hyperskill.musicplayer.ui.holder.MainAddPlaylistViewsHolder
import org.hyperskill.musicplayer.ui.model.ActionUiState
import org.hyperskill.musicplayer.ui.provider.MainAddPlaylistViewsProvider
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainAddPlaylistFragment : BaseFragment<ActionUiState, MainAddPlaylistViewsProvider,MainAddPlaylistFragmentBinding>() {
    private lateinit var viewHolder: MainAddPlaylistViewsHolder
    override lateinit var viewStateBinder: MainAddPlaylistFragmentBinder

    override val viewModel: MusicPlaylistViewModel by sharedViewModel()
    private val selectorViewModel: MusicSelectorViewModel by sharedViewModel()

    var selectorAdapterFragment: SongSelectorAdapter? = null
    var songAdapterFragment: SongAdapter? = null

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainAddPlaylistFragmentBinding {
        val binding = MainAddPlaylistFragmentBinding.inflate(inflater, container, false)
        viewHolder = MainAddPlaylistViewsHolder(binding.root)
        viewStateBinder = MainAddPlaylistFragmentBinder(viewHolder)
        return binding
    }

    override fun View.bindViews() {
        setupViews()
    }

    override fun setupViews() {
        setPlaylistCancelButton()
        setAddPlaylistBtn()
        displayToastIfEmpty()
    }

    fun setPlaylistCancelButton(){
        binding.addPlaylistBtnCancel.setOnClickListener {
            changeBackPlayer()
        }
    }

    fun setAddPlaylistBtn(){
        binding.addPlaylistBtnOk.setOnClickListener {
            val list = selectorAdapterFragment?.getAdapterList()?.filter { it.isSelected }?.toList()
            val playlistName = binding.addPlaylistEtPlaylistName.text.toString()
            if (list != null) {
                println(list.size)
            }
            if (playlistName == Constants.ALL_SONGS){
                context?.let {
                    Toast.makeText(it,it.getString(R.string.playlist_choose_name_all_warn),Toast.LENGTH_SHORT).show()
                }
            }
            else if(!list.isNullOrEmpty()){
                if (playlistName.isEmpty() || playlistName.isBlank()){
                    context?.let {
                        Toast.makeText(it,it.getString(R.string.playlist_choose_name_empty_warn),Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    val modelListIds = list.map { it.song.id }.toList()
                    val modelList = viewModel.allSongs.songs.filter{
                        modelListIds.contains(it.id)}
                    viewModel.createPlaylist(playlistName,modelList)
                    changeBackPlayer()
                }
            }
            else{
                context?.let {
                    Toast.makeText(it,it.getString(R.string.playlist_add_song_empty_warn),Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun displayToastIfEmpty(){
        selectorAdapterFragment?.let {
            if(it.getItemCount() == 0){
                context?.let {
                    Toast.makeText(it,it.getString(R.string.no_songs_loaded_click_search),Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    fun changeBackPlayer(){
        viewModel.uiState.value = ActionUiState.PLAY_MUSIC
        selectorViewModel.clearSelectedMusics()
        selectorViewModel.clearAllSelector()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(
                R.id.mainFragmentContainer,
                MainPlayerControllerFragment().apply {
                    adapter = songAdapterFragment
                }
            )
            .commit()
    }
}