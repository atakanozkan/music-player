package org.hyperskill.musicplayer.domain.event;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lorg/hyperskill/musicplayer/domain/event/PlaybackEventListener;", "", "onPlaybackComplete", "", "onPlaybackContinue", "position", "", "onPlaybackPause", "onPlaybackStart", "", "onPlaybackStop", "Music_Player-task_release"})
public abstract interface PlaybackEventListener {
    
    public abstract void onPlaybackComplete();
    
    public abstract int onPlaybackStart();
    
    public abstract void onPlaybackPause(long position);
    
    public abstract void onPlaybackContinue(long position);
    
    public abstract void onPlaybackStop(long position);
}