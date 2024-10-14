package org.hyperskill.musicplayer.controller.ui

import androidx.fragment.app.FragmentManager
import org.hyperskill.musicplayer.R
import org.hyperskill.musicplayer.ui.adapter.SongAdapter
import org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter
import org.hyperskill.musicplayer.ui.fragment.MainAddPlaylistFragment
import org.hyperskill.musicplayer.ui.fragment.MainPlayerControllerFragment

class FragmentTransactionController (private val fragmentManager: FragmentManager) {

    fun attachMainPlayerControllerFragment(adapter: SongAdapter) {
        fragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, MainPlayerControllerFragment().apply { this.adapter = adapter })
            .commit()
    }

    fun attachMainAddPlaylistFragment(songAdapter: SongAdapter, selectorAdapter: SongSelectorAdapter) {
        fragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, MainAddPlaylistFragment().apply {
                this.songAdapterFragment = songAdapter
                this.selectorAdapterFragment = selectorAdapter
            })
            .commit()
    }
}