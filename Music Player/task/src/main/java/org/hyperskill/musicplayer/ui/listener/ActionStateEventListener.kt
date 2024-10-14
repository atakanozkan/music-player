package org.hyperskill.musicplayer.ui.listener

import org.hyperskill.musicplayer.architecture.ui.listener.EventListener

interface ActionStateEventListener : EventListener {
    fun onPlayMusic()
    fun onAddPlaylist()
}