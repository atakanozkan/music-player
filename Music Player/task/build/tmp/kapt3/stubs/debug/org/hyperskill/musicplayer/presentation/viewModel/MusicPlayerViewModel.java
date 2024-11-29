package org.hyperskill.musicplayer.presentation.viewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0016\u001a\u0004\u0018\u00010\bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0012J\u0010\u0010!\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\bJ\u0016\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u00122\b\u0010\'\u001a\u0004\u0018\u00010\u0010J\b\u0010(\u001a\u00020\u0012H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "Lcom/videochat/architecture/presentation/viewmodel/BaseViewModel;", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "()V", "_currentPlayBack", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lorg/hyperskill/musicplayer/presentation/model/PlaybackPresentationModel;", "_currentSong", "Lorg/hyperskill/musicplayer/presentation/model/SongTrackPresentationModel;", "currentPlayBack", "Lkotlinx/coroutines/flow/SharedFlow;", "getCurrentPlayBack", "()Lkotlinx/coroutines/flow/SharedFlow;", "currentSong", "getCurrentSong", "player", "Lorg/hyperskill/musicplayer/controller/player/Player;", "checkChangeToNewMusic", "", "id", "", "song", "getCurrentTrack", "getPreviousTrack", "getUri", "Landroid/net/Uri;", "onCleared", "pauseMusic", "playMusic", "seekPosition", "pos", "", "setCurrentChangeOnTrack", "setCurrentMusic", "setPlaybackModel", "currentPos", "playbackStatus", "Lorg/hyperskill/musicplayer/presentation/model/PlaybackStatus;", "setPlayer", "manager", "stopMusic", "Music_Player-task_debug"})
public final class MusicPlayerViewModel extends com.videochat.architecture.presentation.viewmodel.BaseViewModel<org.hyperskill.musicplayer.ui.model.ActionUiState> {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel> _currentSong = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<org.hyperskill.musicplayer.presentation.model.PlaybackPresentationModel> _currentPlayBack = null;
    @org.jetbrains.annotations.Nullable()
    private org.hyperskill.musicplayer.controller.player.Player player;
    
    public MusicPlayerViewModel() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel> getCurrentSong() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<org.hyperskill.musicplayer.presentation.model.PlaybackPresentationModel> getCurrentPlayBack() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel getCurrentTrack() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.hyperskill.musicplayer.presentation.model.PlaybackPresentationModel getCurrentPlayBack() {
        return null;
    }
    
    public final void setCurrentMusic(@org.jetbrains.annotations.Nullable()
    org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel song) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel getPreviousTrack() {
        return null;
    }
    
    public final void setPlayer(@org.jetbrains.annotations.Nullable()
    org.hyperskill.musicplayer.controller.player.Player manager) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    private final void playMusic() {
    }
    
    private final void pauseMusic() {
    }
    
    private final void stopMusic() {
    }
    
    public final void seekPosition(int pos) {
    }
    
    public final void setCurrentChangeOnTrack() {
    }
    
    public final void setPlaybackModel(long currentPos, @org.jetbrains.annotations.NotNull()
    org.hyperskill.musicplayer.presentation.model.PlaybackStatus playbackStatus) {
    }
    
    private final void checkChangeToNewMusic(long id, org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel song) {
    }
    
    private final android.net.Uri getUri(long id) {
        return null;
    }
}