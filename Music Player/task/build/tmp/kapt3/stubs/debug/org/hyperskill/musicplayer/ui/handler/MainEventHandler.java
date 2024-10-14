package org.hyperskill.musicplayer.ui.handler;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lorg/hyperskill/musicplayer/ui/handler/MainEventHandler;", "Lorg/hyperskill/musicplayer/architecture/ui/event/EventHandler;", "fragmentTransactionController", "Lorg/hyperskill/musicplayer/controller/ui/FragmentTransactionController;", "playlistViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "selectorViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "songAdapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "songSelectorAdapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;", "(Lorg/hyperskill/musicplayer/controller/ui/FragmentTransactionController;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;)V", "getEventHandler", "Lorg/hyperskill/musicplayer/ui/listener/ActionStateEventListener;", "Music_Player-task_debug"})
public final class MainEventHandler implements org.hyperskill.musicplayer.architecture.ui.event.EventHandler {
    private final org.hyperskill.musicplayer.controller.ui.FragmentTransactionController fragmentTransactionController = null;
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel = null;
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel = null;
    private final org.hyperskill.musicplayer.ui.adapter.SongAdapter songAdapter = null;
    private final org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter songSelectorAdapter = null;
    
    public MainEventHandler(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.controller.ui.FragmentTransactionController fragmentTransactionController, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.adapter.SongAdapter songAdapter, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter songSelectorAdapter) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.hyperskill.musicplayer.ui.listener.ActionStateEventListener getEventHandler() {
        return null;
    }
}