package org.hyperskill.musicplayer.domain.event;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lorg/hyperskill/musicplayer/domain/event/SongClickListener;", "Lorg/hyperskill/musicplayer/architecture/domain/usecase/EventListener;", "onClick", "", "id", "", "onLongClick", "Music_Player-task_release"})
public abstract interface SongClickListener extends org.hyperskill.musicplayer.architecture.domain.usecase.EventListener {
    
    public abstract void onClick(long id);
    
    public abstract void onLongClick(long id);
}