package org.hyperskill.musicplayer.ui.holder

import android.view.View
import android.widget.Button
import android.widget.EditText
import org.hyperskill.musicplayer.R
import org.hyperskill.musicplayer.ui.provider.MainAddPlaylistViewsProvider

class MainAddPlaylistViewsHolder(view: View) : MainAddPlaylistViewsProvider {
    override val addPlaylistEtPlaylistName: EditText = view.findViewById(R.id.addPlaylistEtPlaylistName)
    override val addPlaylistBtnOk: Button = view.findViewById(R.id.addPlaylistBtnOk)
    override val addPlaylistBtnCancel: Button = view.findViewById(R.id.addPlaylistBtnCancel)
}