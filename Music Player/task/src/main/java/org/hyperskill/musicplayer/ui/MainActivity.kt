package org.hyperskill.musicplayer.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collectLatest
import org.hyperskill.musicplayer.R
import org.hyperskill.musicplayer.common.constant.Constants.REQUEST_CODE_READ_EXTERNAL_STORAGE
import org.hyperskill.musicplayer.databinding.ActivityMainBinding
import org.hyperskill.musicplayer.ui.dialog.DialogHandler
import org.hyperskill.musicplayer.controller.ui.FragmentTransactionController
import org.hyperskill.musicplayer.ui.handler.AdapterListenerEvent
import org.hyperskill.musicplayer.ui.handler.MainEventHandler
import org.hyperskill.musicplayer.controller.player.PlayerController
import org.hyperskill.musicplayer.ui.handler.AdapterSelectListenerEvent
import org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel
import org.hyperskill.musicplayer.ui.adapter.SongAdapter
import org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter
import org.hyperskill.musicplayer.ui.binder.MainActivityBinder
import org.hyperskill.musicplayer.ui.handler.PlaybackListenerHandler
import org.hyperskill.musicplayer.ui.holder.MainActivityViewsHolder
import org.hyperskill.musicplayer.ui.mapper.SongSelectorToUiMapper
import org.hyperskill.musicplayer.ui.mapper.SongToUiMapper
import org.hyperskill.musicplayer.ui.mapper.SongTrackToUiMapper
import org.hyperskill.musicplayer.ui.model.ActionUiState
import org.hyperskill.musicplayer.ui.model.SongPlayMode
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewStateBinder : MainActivityBinder
    private lateinit var viewsHolder: MainActivityViewsHolder

    private val viewModel: MusicPlaylistViewModel by viewModel()
    private val selectorViewModel: MusicSelectorViewModel by viewModel()
    private val playerViewModel: MusicPlayerViewModel by viewModel()

    private val songToUiMapper: SongToUiMapper by inject()
    private val songSelectorToUiMapper: SongSelectorToUiMapper by inject()
    private val songTrackToUiMapper: SongTrackToUiMapper by inject()

    private lateinit var fragmentTransactionController: FragmentTransactionController
    private lateinit var dialogHandler: DialogHandler
    private lateinit var playerController: PlayerController

    private lateinit var mainEventHandler: MainEventHandler
    private lateinit var adapterListenerEvent: AdapterListenerEvent
    private lateinit var adapterSelectListenerEvent: AdapterSelectListenerEvent
    private lateinit var playbackListenerHandler: PlaybackListenerHandler

    private lateinit var songAdapter: SongAdapter
    private lateinit var songSelectorAdapter: SongSelectorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        viewsHolder = MainActivityViewsHolder(binding.root)
        setContentView(binding.root)

        dialogHandler = DialogHandler(this, viewModel, selectorViewModel, playerViewModel)

        fragmentTransactionController = FragmentTransactionController(supportFragmentManager)

        songAdapter = SongAdapter(emptyList(),null)
        songSelectorAdapter = SongSelectorAdapter(emptyList())

        setEventHandlers()

        playerController = PlayerController(this,playbackListenerHandler)

        playerViewModel.setCurrentChangeOnTrack()
        playerViewModel.setPlayer(playerController)
        viewModel.loadAllPlaylistsFromDb()

        setSearchButton()
        setAdapterListeners()
        setCurrentPlaylistListener()
        setAllSelectorListener()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mainMenuAddPlaylist -> {
                if (viewModel.uiState.value == ActionUiState.PLAY_MUSIC){
                    applyActionState(ActionUiState.ADD_PLAYLIST)
                }
                true
            }
            R.id.mainMenuLoadPlaylist -> {
                dialogHandler.showLoadPlaylistDialog()
                true
            }
            R.id.mainMenuDeletePlaylist -> {
                dialogHandler.showDeletePlaylistDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setEventHandlers(){
        adapterListenerEvent = AdapterListenerEvent(
            playerViewModel,
            viewModel,
            selectorViewModel,
            songTrackToUiMapper,
            songAdapter,
            longClickEvent = {applyActionState(ActionUiState.ADD_PLAYLIST)}
        )

        adapterSelectListenerEvent= AdapterSelectListenerEvent(
            viewModel,
            selectorViewModel
        )
        playbackListenerHandler = PlaybackListenerHandler(playerViewModel)

        val songClickListener = adapterListenerEvent.getEventHandler()
        val songSelectListener = adapterSelectListenerEvent.getEventHandler()

        songAdapter.setClickListener(songClickListener)
        songSelectorAdapter.setSongSelectListener(songSelectListener)

        fragmentTransactionController.attachMainPlayerControllerFragment(songAdapter)

        mainEventHandler = MainEventHandler(
            fragmentTransactionController,
            viewModel,
            selectorViewModel,
            songAdapter,
            songSelectorAdapter
        )

        val actionStateEventListener = mainEventHandler.getEventHandler()
        viewStateBinder = MainActivityBinder(viewsHolder, actionStateEventListener)
    }

    private fun setSearchButton() {
        viewsHolder.mainButtonSearch.setOnClickListener {
            val playlistAllSongs = viewModel.allSongs
            if (viewModel.uiState.value == ActionUiState.ADD_PLAYLIST){
                if(playlistAllSongs.songs.isEmpty()){
                    checkAndRequestStoragePermission()
                }
                playlistAllSongs.let {
                    selectorViewModel.setAllSelector(it.id,it.title,it.songs)
                }
            }
            else{
                val received = checkAndRequestStoragePermission()
                if (received){
                    val currentSong = playerViewModel.getCurrentTrack()
                    viewModel.setCurrentPlaylist(playlistAllSongs.id,currentSong,
                        { song, playMode ->
                            playerViewModel.setCurrentMusic(
                                SongTrackPresentationModel(
                                    song,
                                    playMode
                                )
                            )
                        }
                    )
                }
            }
        }
    }

    fun checkAndRequestStoragePermission() : Boolean{
        val permission = Manifest.permission.READ_EXTERNAL_STORAGE
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            viewModel.setAllSongs()
            return true
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(permission),
                REQUEST_CODE_READ_EXTERNAL_STORAGE
            )
            return false
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            REQUEST_CODE_READ_EXTERNAL_STORAGE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    viewModel.setAllSongs()
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.load_permission_decline),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun setAdapterListeners(){
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collectLatest {
                    state ->
                when(state){
                    ActionUiState.PLAY_MUSIC ->{
                        viewsHolder.mainSongList.apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = songAdapter
                        }
                    }
                    ActionUiState.ADD_PLAYLIST ->{
                        viewsHolder.mainSongList.apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = songSelectorAdapter
                        }
                    }
                }
            }
        }
    }

    private fun setCurrentPlaylistListener(){
        lifecycleScope.launchWhenStarted {
            viewModel.currentPlaylist.collectLatest {
                    playlist ->
                playlist?.songs?.let {
                    val currentSong = playerViewModel.getCurrentTrack()?.song
                    songAdapter.setSongs(songToUiMapper.mapList(it))
                    if(currentSong == null || !it.contains(currentSong)){
                        if (it.isNotEmpty()){
                            playerViewModel.setCurrentMusic(
                                SongTrackPresentationModel(it.first(), SongPlayMode.STOP)
                            )
                        }
                    }
                }
            }
        }
    }

    private fun setAllSelectorListener(){
        lifecycleScope.launchWhenStarted {
            lifecycleScope.launchWhenStarted {
                selectorViewModel.allSelectorSongs.collectLatest {
                    it?.songSelector.let{
                        if (it != null) {
                            songSelectorAdapter.setSongSelectors(songSelectorToUiMapper.mapList(it))
                        }
                    }
                }
            }
        }
    }

    private fun applyActionState(viewState: ActionUiState) {
        with(viewStateBinder){
            viewModel.uiState.value =viewState
            bind(viewState)
        }
    }

}