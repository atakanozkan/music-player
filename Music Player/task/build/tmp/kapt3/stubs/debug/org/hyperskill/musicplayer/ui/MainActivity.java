package org.hyperskill.musicplayer.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0006\u0010<\u001a\u00020=J\u0012\u0010>\u001a\u0002092\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\u0010\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020FH\u0016J-\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020I2\u000e\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020L0K2\u0006\u0010M\u001a\u00020NH\u0016\u00a2\u0006\u0002\u0010OJ\b\u0010P\u001a\u000209H\u0002J\b\u0010Q\u001a\u000209H\u0002J\b\u0010R\u001a\u000209H\u0002J\b\u0010S\u001a\u000209H\u0002J\b\u0010T\u001a\u000209H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b\'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010\u0016\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u000205X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2 = {"Lorg/hyperskill/musicplayer/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapterListenerEvent", "Lorg/hyperskill/musicplayer/ui/handler/AdapterListenerEvent;", "adapterSelectListenerEvent", "Lorg/hyperskill/musicplayer/ui/handler/AdapterSelectListenerEvent;", "dialogHandler", "Lorg/hyperskill/musicplayer/ui/dialog/DialogHandler;", "fragmentTransactionController", "Lorg/hyperskill/musicplayer/controller/ui/FragmentTransactionController;", "mainEventHandler", "Lorg/hyperskill/musicplayer/ui/handler/MainEventHandler;", "playbackListenerHandler", "Lorg/hyperskill/musicplayer/ui/handler/PlaybackListenerHandler;", "playerController", "Lorg/hyperskill/musicplayer/controller/player/Player;", "playerViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "getPlayerViewModel", "()Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "playerViewModel$delegate", "Lkotlin/Lazy;", "selectorViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "getSelectorViewModel", "()Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "selectorViewModel$delegate", "songAdapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "songSelectorAdapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;", "songSelectorToUiMapper", "Lorg/hyperskill/musicplayer/ui/mapper/SongSelectorToUiMapper;", "getSongSelectorToUiMapper", "()Lorg/hyperskill/musicplayer/ui/mapper/SongSelectorToUiMapper;", "songSelectorToUiMapper$delegate", "songToUiMapper", "Lorg/hyperskill/musicplayer/ui/mapper/SongToUiMapper;", "getSongToUiMapper", "()Lorg/hyperskill/musicplayer/ui/mapper/SongToUiMapper;", "songToUiMapper$delegate", "songTrackToUiMapper", "Lorg/hyperskill/musicplayer/ui/mapper/SongTrackToUiMapper;", "getSongTrackToUiMapper", "()Lorg/hyperskill/musicplayer/ui/mapper/SongTrackToUiMapper;", "songTrackToUiMapper$delegate", "viewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "getViewModel", "()Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "viewModel$delegate", "viewStateBinder", "Lorg/hyperskill/musicplayer/ui/binder/MainActivityBinder;", "viewsHolder", "Lorg/hyperskill/musicplayer/ui/holder/MainActivityViewsHolder;", "applyActionState", "", "viewState", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "checkAndRequestStoragePermission", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "setAdapterListeners", "setAllSelectorListener", "setCurrentPlaylistListener", "setEventHandlers", "setSearchButton", "Music_Player-task_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private org.hyperskill.musicplayer.ui.binder.MainActivityBinder viewStateBinder;
    private org.hyperskill.musicplayer.ui.holder.MainActivityViewsHolder viewsHolder;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy selectorViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy playerViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy songToUiMapper$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy songSelectorToUiMapper$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy songTrackToUiMapper$delegate = null;
    private org.hyperskill.musicplayer.controller.ui.FragmentTransactionController fragmentTransactionController;
    private org.hyperskill.musicplayer.ui.dialog.DialogHandler dialogHandler;
    private org.hyperskill.musicplayer.controller.player.Player playerController;
    private org.hyperskill.musicplayer.ui.handler.MainEventHandler mainEventHandler;
    private org.hyperskill.musicplayer.ui.handler.AdapterListenerEvent adapterListenerEvent;
    private org.hyperskill.musicplayer.ui.handler.AdapterSelectListenerEvent adapterSelectListenerEvent;
    private org.hyperskill.musicplayer.ui.handler.PlaybackListenerHandler playbackListenerHandler;
    private org.hyperskill.musicplayer.ui.adapter.SongAdapter songAdapter;
    private org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter songSelectorAdapter;
    
    public MainActivity() {
        super();
    }
    
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel getViewModel() {
        return null;
    }
    
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel getSelectorViewModel() {
        return null;
    }
    
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel getPlayerViewModel() {
        return null;
    }
    
    private final org.hyperskill.musicplayer.ui.mapper.SongToUiMapper getSongToUiMapper() {
        return null;
    }
    
    private final org.hyperskill.musicplayer.ui.mapper.SongSelectorToUiMapper getSongSelectorToUiMapper() {
        return null;
    }
    
    private final org.hyperskill.musicplayer.ui.mapper.SongTrackToUiMapper getSongTrackToUiMapper() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void setEventHandlers() {
    }
    
    private final void setSearchButton() {
    }
    
    public final boolean checkAndRequestStoragePermission() {
        return false;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void setAdapterListeners() {
    }
    
    private final void setCurrentPlaylistListener() {
    }
    
    private final void setAllSelectorListener() {
    }
    
    private final void applyActionState(org.hyperskill.musicplayer.ui.model.ActionUiState viewState) {
    }
}