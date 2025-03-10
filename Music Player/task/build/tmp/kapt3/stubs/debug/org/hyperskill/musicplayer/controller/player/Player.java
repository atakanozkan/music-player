package org.hyperskill.musicplayer.controller.player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&\u00a8\u0006\u000f"}, d2 = {"Lorg/hyperskill/musicplayer/controller/player/Player;", "", "dispose", "", "pauseMusic", "playSong", "Landroid/media/MediaPlayer;", "uri", "Landroid/net/Uri;", "prepareMediaPlayer", "seek", "ms", "", "startPlaying", "stopMusic", "Music_Player-task_debug"})
public abstract interface Player {
    
    @org.jetbrains.annotations.Nullable()
    public abstract android.media.MediaPlayer playSong(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
    
    public abstract void startPlaying();
    
    @org.jetbrains.annotations.Nullable()
    public abstract android.media.MediaPlayer prepareMediaPlayer(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
    
    public abstract void seek(int ms);
    
    public abstract void pauseMusic();
    
    public abstract void stopMusic();
    
    public abstract void dispose();
}