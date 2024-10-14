package org.hyperskill.musicplayer.ui.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lorg/hyperskill/musicplayer/ui/listener/ActionStateEventListener;", "Lorg/hyperskill/musicplayer/architecture/ui/listener/EventListener;", "onAddPlaylist", "", "onPlayMusic", "Music_Player-task_debug"})
public abstract interface ActionStateEventListener extends org.hyperskill.musicplayer.architecture.ui.listener.EventListener {
    
    public abstract void onPlayMusic();
    
    public abstract void onAddPlaylist();
}