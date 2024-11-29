package org.hyperskill.musicplayer.base.ui.event

import org.hyperskill.musicplayer.base.ui.listener.EventListener

interface EventHandler {
    fun getEventHandler() : EventListener
}