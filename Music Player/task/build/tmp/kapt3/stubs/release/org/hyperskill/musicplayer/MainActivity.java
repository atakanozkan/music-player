package org.hyperskill.musicplayer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0006\u0010/\u001a\u00020,J\u0012\u00100\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u0010\u00103\u001a\u00020\n2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\n2\u0006\u00107\u001a\u000208H\u0016J-\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020;2\u000e\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0=2\u0006\u0010?\u001a\u00020@H\u0016\u00a2\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020,H\u0002J\b\u0010C\u001a\u00020,H\u0002J\b\u0010D\u001a\u00020,H\u0002J\b\u0010E\u001a\u00020,H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b$\u0010%R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006F"}, d2 = {"Lorg/hyperskill/musicplayer/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapterListenerManager", "Lorg/hyperskill/musicplayer/manager/listener/AdapterListenerManager;", "dialogManager", "Lorg/hyperskill/musicplayer/manager/dialog/DialogManager;", "fragmentAttachManager", "Lorg/hyperskill/musicplayer/manager/fragment/FragmentAttachManager;", "initialLoad", "", "mainListenerManager", "Lorg/hyperskill/musicplayer/manager/listener/MainListenerManager;", "musicPlayerDatabase", "Lorg/hyperskill/musicplayer/data/db/MusicPlayerDatabase;", "playbackEventListener", "Lorg/hyperskill/musicplayer/domain/event/PlaybackEventListener;", "playerManager", "Lorg/hyperskill/musicplayer/manager/player/PlayerManager;", "playerViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "getPlayerViewModel", "()Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "playerViewModel$delegate", "Lkotlin/Lazy;", "selectorViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "getSelectorViewModel", "()Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "selectorViewModel$delegate", "songAdapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "songSelectorAdapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;", "viewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "getViewModel", "()Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "viewModel$delegate", "viewStateBinder", "Lorg/hyperskill/musicplayer/ui/binder/MainActivityBinder;", "viewsHolder", "Lorg/hyperskill/musicplayer/ui/holder/MainActivityViewsHolder;", "applyActionState", "", "viewState", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "checkAndRequestStoragePermission", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "setAdapterListeners", "setAllSelectorListener", "setCurrentPlaylistListener", "setSearchButton", "Music_Player-task_release"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private org.hyperskill.musicplayer.ui.binder.MainActivityBinder viewStateBinder;
    private org.hyperskill.musicplayer.ui.holder.MainActivityViewsHolder viewsHolder;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy selectorViewModel$delegate = null;
    private final kotlin.Lazy playerViewModel$delegate = null;
    private boolean initialLoad = true;
    private org.hyperskill.musicplayer.manager.fragment.FragmentAttachManager fragmentAttachManager;
    private org.hyperskill.musicplayer.manager.dialog.DialogManager dialogManager;
    private org.hyperskill.musicplayer.manager.listener.MainListenerManager mainListenerManager;
    private org.hyperskill.musicplayer.manager.player.PlayerManager playerManager;
    private org.hyperskill.musicplayer.manager.listener.AdapterListenerManager adapterListenerManager;
    private org.hyperskill.musicplayer.ui.adapter.SongAdapter songAdapter;
    private org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter songSelectorAdapter;
    private org.hyperskill.musicplayer.data.db.MusicPlayerDatabase musicPlayerDatabase;
    private final org.hyperskill.musicplayer.domain.event.PlaybackEventListener playbackEventListener = null;
    
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
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void setSearchButton() {
    }
    
    public final void checkAndRequestStoragePermission() {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
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