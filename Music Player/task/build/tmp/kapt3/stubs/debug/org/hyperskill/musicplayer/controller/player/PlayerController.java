package org.hyperskill.musicplayer.controller.player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u001c\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\t\u0010 \u001a\u00020\u0019H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010\"\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\t\u0010#\u001a\u00020\u001eH\u0096\u0001J\u0011\u0010$\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\b\u0010%\u001a\u00020\u0019H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u00112\u0006\u0010\'\u001a\u00020\u000bH\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010\u00112\u0006\u0010\'\u001a\u00020\u000bH\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001eH\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\u0006\u0010-\u001a\u00020\u0019R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006."}, d2 = {"Lorg/hyperskill/musicplayer/controller/player/PlayerController;", "Lorg/hyperskill/musicplayer/controller/player/Player;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Landroid/media/MediaPlayer$OnErrorListener;", "Lorg/hyperskill/musicplayer/ui/listener/PlaybackEventListener;", "appContext", "Landroid/content/Context;", "playbackEventListener", "Lorg/hyperskill/musicplayer/ui/handler/PlaybackListenerHandler;", "(Landroid/content/Context;Lorg/hyperskill/musicplayer/ui/handler/PlaybackListenerHandler;)V", "currentPlayingUri", "Landroid/net/Uri;", "isInitialized", "", "isPlaying", "isStopped", "mediaPlayer", "Landroid/media/MediaPlayer;", "playerWorker", "Lorg/hyperskill/musicplayer/controller/player/PlayerWorker;", "position", "", "getPosition", "()J", "dispose", "", "onCompletion", "mp", "onError", "what", "", "extra", "onPlaybackComplete", "onPlaybackContinue", "onPlaybackPause", "onPlaybackStart", "onPlaybackStop", "pauseMusic", "playSong", "uri", "prepareMediaPlayer", "seek", "ms", "startPlaying", "stopMusic", "workerPeriodicJob", "Music_Player-task_debug"})
public final class PlayerController implements org.hyperskill.musicplayer.controller.player.Player, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, org.hyperskill.musicplayer.ui.listener.PlaybackEventListener {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final org.hyperskill.musicplayer.ui.handler.PlaybackListenerHandler playbackEventListener = null;
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaPlayer mediaPlayer;
    @org.jetbrains.annotations.NotNull()
    private org.hyperskill.musicplayer.controller.player.PlayerWorker playerWorker;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri currentPlayingUri;
    private boolean isPlaying = false;
    private boolean isInitialized = false;
    private boolean isStopped = false;
    
    public PlayerController(@org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    org.hyperskill.musicplayer.ui.handler.PlaybackListenerHandler playbackEventListener) {
        super();
    }
    
    public final long getPosition() {
        return 0L;
    }
    
    public final void workerPeriodicJob() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.media.MediaPlayer prepareMediaPlayer(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    @java.lang.Override()
    public void seek(int ms) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.media.MediaPlayer playSong(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    @java.lang.Override()
    public void startPlaying() {
    }
    
    @java.lang.Override()
    public void pauseMusic() {
    }
    
    @java.lang.Override()
    public void dispose() {
    }
    
    @java.lang.Override()
    public void stopMusic() {
    }
    
    @java.lang.Override()
    public void onCompletion(@org.jetbrains.annotations.Nullable()
    android.media.MediaPlayer mp) {
    }
    
    @java.lang.Override()
    public boolean onError(@org.jetbrains.annotations.Nullable()
    android.media.MediaPlayer mp, int what, int extra) {
        return false;
    }
    
    @java.lang.Override()
    public void onPlaybackComplete() {
    }
    
    @java.lang.Override()
    public void onPlaybackContinue(long position) {
    }
    
    @java.lang.Override()
    public void onPlaybackPause(long position) {
    }
    
    @java.lang.Override()
    public int onPlaybackStart() {
        return 0;
    }
    
    @java.lang.Override()
    public void onPlaybackStop(long position) {
    }
}