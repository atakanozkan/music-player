package org.hyperskill.musicplayer.ui.dialog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lorg/hyperskill/musicplayer/ui/dialog/DialogHandler;", "", "context", "Landroid/content/Context;", "playlistViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "selectorViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "playerViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "(Landroid/content/Context;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;)V", "onSetCurrentSong", "Lkotlin/Function2;", "Lorg/hyperskill/musicplayer/presentation/model/SongPresentationModel;", "Lorg/hyperskill/musicplayer/ui/model/SongPlayMode;", "", "showDeletePlaylistDialog", "showLoadPlaylistDialog", "Music_Player-task_debug"})
public final class DialogHandler {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel = null;
    @org.jetbrains.annotations.NotNull()
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel = null;
    @org.jetbrains.annotations.NotNull()
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel playerViewModel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<org.hyperskill.musicplayer.presentation.model.SongPresentationModel, org.hyperskill.musicplayer.ui.model.SongPlayMode, kotlin.Unit> onSetCurrentSong = null;
    
    public DialogHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel, @org.jetbrains.annotations.NotNull()
    org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel, @org.jetbrains.annotations.NotNull()
    org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel playerViewModel) {
        super();
    }
    
    public final void showDeletePlaylistDialog() {
    }
    
    public final void showLoadPlaylistDialog() {
    }
}