package org.hyperskill.musicplayer.ui.provider

import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.videochat.architecture.ui.binder.ViewsProvider

interface MainPlayerControllerViewsProvider : ViewsProvider {
    val controllerTvCurrentTime: TextView
    val controllerTvTotalTime: TextView
    val controllerSeekBar:SeekBar
    val controllerBtnPlayPause: Button
    val controllerBtnStop: Button
}