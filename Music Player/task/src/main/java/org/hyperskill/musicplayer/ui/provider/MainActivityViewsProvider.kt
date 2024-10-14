package org.hyperskill.musicplayer.ui.provider

import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView
import com.videochat.architecture.ui.binder.ViewsProvider

interface MainActivityViewsProvider : ViewsProvider {
    val mainButtonSearch: Button
    val mainSongList: RecyclerView
    val mainFragmentContainer: FragmentContainerView
}