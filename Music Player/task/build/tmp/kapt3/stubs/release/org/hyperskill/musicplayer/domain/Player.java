package org.hyperskill.musicplayer.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&\u00a8\u0006\u0010"}, d2 = {"Lorg/hyperskill/musicplayer/domain/Player;", "", "dispose", "", "pauseOrPlay", "playSong", "song", "Lorg/hyperskill/musicplayer/presentation/model/SongPresentationModel;", "prepare", "input", "playAfter", "", "seek", "ms", "", "stop", "Music_Player-task_release"})
public abstract interface Player {
    
    public abstract void playSong(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.model.SongPresentationModel song);
    
    public abstract void seek(long ms);
    
    public abstract void pauseOrPlay();
    
    public abstract void stop();
    
    public abstract void dispose();
    
    public abstract void prepare(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.model.SongPresentationModel input, boolean playAfter);
}