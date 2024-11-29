package org.hyperskill.musicplayer.ui.listener

import org.hyperskill.musicplayer.base.ui.listener.EventListener

interface ActionStateEventListener : EventListener {
    fun onPlayMusic()
    fun onAddPlaylist()
}