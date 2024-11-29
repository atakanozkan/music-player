package org.hyperskill.musicplayer.ui.listener

import org.hyperskill.musicplayer.base.ui.listener.EventListener

interface SongSelectListener : EventListener {
    fun onClick(id: Long,isSelected: Boolean)
}