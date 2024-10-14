package org.hyperskill.musicplayer.ui.provider

import android.widget.Button
import android.widget.EditText
import com.videochat.architecture.ui.binder.ViewsProvider

interface MainAddPlaylistViewsProvider  : ViewsProvider {
    val addPlaylistEtPlaylistName: EditText
    val addPlaylistBtnOk: Button
    val addPlaylistBtnCancel: Button
}