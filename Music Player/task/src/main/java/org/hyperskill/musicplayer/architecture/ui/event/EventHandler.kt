package org.hyperskill.musicplayer.architecture.ui.event

import org.hyperskill.musicplayer.architecture.ui.listener.EventListener

interface EventHandler {
    fun getEventHandler() : EventListener
}