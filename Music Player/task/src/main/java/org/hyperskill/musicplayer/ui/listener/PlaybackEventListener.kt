package org.hyperskill.musicplayer.ui.listener

import org.hyperskill.musicplayer.architecture.ui.listener.EventListener

interface PlaybackEventListener : EventListener {
    fun onPlaybackComplete()
    fun onPlaybackStart() : Int
    fun onPlaybackPause(position: Long)
    fun onPlaybackContinue(position: Long)
    fun onPlaybackStop(position: Long)
}
