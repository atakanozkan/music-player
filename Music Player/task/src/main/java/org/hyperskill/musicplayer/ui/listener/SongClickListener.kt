package org.hyperskill.musicplayer.ui.listener

import org.hyperskill.musicplayer.architecture.ui.listener.EventListener

interface SongClickListener: EventListener {
    fun onClick(id: Long)
    fun onLongClick(id: Long)
}