package org.hyperskill.musicplayer.ui.holder

import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import org.hyperskill.musicplayer.R
import org.hyperskill.musicplayer.ui.provider.MainPlayerControllerViewsProvider

class MainPlayerControllerViewsHolder(view: View): MainPlayerControllerViewsProvider {
    override val controllerTvCurrentTime: TextView = view.findViewById(R.id.controllerTvCurrentTime)
    override val controllerTvTotalTime: TextView = view.findViewById(R.id.controllerTvTotalTime)
    override val controllerSeekBar: SeekBar = view.findViewById(R.id.controllerSeekBar)
    override val controllerBtnPlayPause: Button = view.findViewById(R.id.controllerBtnPlayPause)
    override val controllerBtnStop: Button = view.findViewById(R.id.controllerBtnStop)
}