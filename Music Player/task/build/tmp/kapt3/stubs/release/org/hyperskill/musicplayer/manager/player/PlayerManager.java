package org.hyperskill.musicplayer.manager.player;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\t\u0010\u001e\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010 \u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\t\u0010!\u001a\u00020\u001cH\u0096\u0001J\u0011\u0010\"\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0006\u0010#\u001a\u00020\u0017J\u0010\u0010$\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020\tJ\u0010\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020\tJ\u000e\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020\u0017J\u0006\u0010*\u001a\u00020\u0017J\u0006\u0010+\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006,"}, d2 = {"Lorg/hyperskill/musicplayer/manager/player/PlayerManager;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Landroid/media/MediaPlayer$OnErrorListener;", "Lorg/hyperskill/musicplayer/domain/event/PlaybackEventListener;", "appContext", "Landroid/content/Context;", "playbackEventListener", "(Landroid/content/Context;Lorg/hyperskill/musicplayer/domain/event/PlaybackEventListener;)V", "currentPlayingUri", "Landroid/net/Uri;", "isInitialized", "", "isPlaying", "isStopped", "mediaPlayer", "Landroid/media/MediaPlayer;", "playerWorker", "Lorg/hyperskill/musicplayer/player/PlayerWorker;", "position", "", "getPosition", "()J", "dispose", "", "onCompletion", "mp", "onError", "what", "", "extra", "onPlaybackComplete", "onPlaybackContinue", "onPlaybackPause", "onPlaybackStart", "onPlaybackStop", "pauseMusic", "playSong", "uri", "prepareMediaPlayer", "seek", "ms", "startPlaying", "stopMusic", "workerPeriodicJob", "Music_Player-task_release"})
public final class PlayerManager implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, org.hyperskill.musicplayer.domain.event.PlaybackEventListener {
    private final android.content.Context appContext = null;
    private final org.hyperskill.musicplayer.domain.event.PlaybackEventListener playbackEventListener = null;
    private android.media.MediaPlayer mediaPlayer;
    private org.hyperskill.musicplayer.player.PlayerWorker playerWorker;
    private android.net.Uri currentPlayingUri;
    private boolean isPlaying = false;
    private boolean isInitialized = false;
    private boolean isStopped = false;
    
    public PlayerManager(@org.jetbrains.annotations.NotNull
    android.content.Context appContext, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.domain.event.PlaybackEventListener playbackEventListener) {
        super();
    }
    
    public final long getPosition() {
        return 0L;
    }
    
    public final void workerPeriodicJob() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.media.MediaPlayer prepareMediaPlayer(@org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
        return null;
    }
    
    public final void seek(int ms) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.media.MediaPlayer playSong(@org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
        return null;
    }
    
    public final void startPlaying() {
    }
    
    public final void pauseMusic() {
    }
    
    private final void dispose() {
    }
    
    public final void stopMusic() {
    }
    
    @java.lang.Override
    public void onCompletion(@org.jetbrains.annotations.Nullable
    android.media.MediaPlayer mp) {
    }
    
    @java.lang.Override
    public boolean onError(@org.jetbrains.annotations.Nullable
    android.media.MediaPlayer mp, int what, int extra) {
        return false;
    }
    
    @java.lang.Override
    public void onPlaybackComplete() {
    }
    
    @java.lang.Override
    public void onPlaybackContinue(long position) {
    }
    
    @java.lang.Override
    public void onPlaybackPause(long position) {
    }
    
    @java.lang.Override
    public int onPlaybackStart() {
        return 0;
    }
    
    @java.lang.Override
    public void onPlaybackStop(long position) {
    }
}