package org.hyperskill.musicplayer.controller.player;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\t\u0010\u001f\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010 \u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\t\u0010\"\u001a\u00020\u001dH\u0096\u0001J\u0011\u0010#\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\u0006\u0010$\u001a\u00020\u0018J\u0010\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020\nJ\u0010\u0010\'\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u001dJ\u0006\u0010*\u001a\u00020\u0018J\u0006\u0010+\u001a\u00020\u0018J\u0006\u0010,\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006-"}, d2 = {"Lorg/hyperskill/musicplayer/controller/player/PlayerController;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Landroid/media/MediaPlayer$OnErrorListener;", "Lorg/hyperskill/musicplayer/ui/listener/PlaybackEventListener;", "appContext", "Landroid/content/Context;", "playbackEventListener", "Lorg/hyperskill/musicplayer/ui/handler/PlaybackListenerHandler;", "(Landroid/content/Context;Lorg/hyperskill/musicplayer/ui/handler/PlaybackListenerHandler;)V", "currentPlayingUri", "Landroid/net/Uri;", "isInitialized", "", "isPlaying", "isStopped", "mediaPlayer", "Landroid/media/MediaPlayer;", "playerWorker", "Lorg/hyperskill/musicplayer/player/PlayerWorker;", "position", "", "getPosition", "()J", "dispose", "", "onCompletion", "mp", "onError", "what", "", "extra", "onPlaybackComplete", "onPlaybackContinue", "onPlaybackPause", "onPlaybackStart", "onPlaybackStop", "pauseMusic", "playSong", "uri", "prepareMediaPlayer", "seek", "ms", "startPlaying", "stopMusic", "workerPeriodicJob", "Music_Player-task_debug"})
public final class PlayerController implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, org.hyperskill.musicplayer.ui.listener.PlaybackEventListener {
    private final android.content.Context appContext = null;
    private final org.hyperskill.musicplayer.ui.handler.PlaybackListenerHandler playbackEventListener = null;
    private android.media.MediaPlayer mediaPlayer;
    private org.hyperskill.musicplayer.player.PlayerWorker playerWorker;
    private android.net.Uri currentPlayingUri;
    private boolean isPlaying = false;
    private boolean isInitialized = false;
    private boolean isStopped = false;
    
    public PlayerController(@org.jetbrains.annotations.NotNull
    android.content.Context appContext, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.handler.PlaybackListenerHandler playbackEventListener) {
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