package org.hyperskill.musicplayer.ui.holder

import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView
import org.hyperskill.musicplayer.R
import org.hyperskill.musicplayer.ui.provider.MainActivityViewsProvider

class MainActivityViewsHolder(view: View):  MainActivityViewsProvider{
    override val mainButtonSearch: Button = view.findViewById(R.id.mainButtonSearch)
    override val mainSongList: RecyclerView= view.findViewById(R.id.mainSongList)
    override val mainFragmentContainer: FragmentContainerView= view.findViewById(R.id.mainFragmentContainer)
}