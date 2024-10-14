package org.hyperskill.musicplayer.architecture.ui.event;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lorg/hyperskill/musicplayer/architecture/ui/event/EventHandler;", "", "getEventHandler", "Lorg/hyperskill/musicplayer/architecture/ui/listener/EventListener;", "Music_Player-task_debug"})
public abstract interface EventHandler {
    
    @org.jetbrains.annotations.NotNull
    public abstract org.hyperskill.musicplayer.architecture.ui.listener.EventListener getEventHandler();
}