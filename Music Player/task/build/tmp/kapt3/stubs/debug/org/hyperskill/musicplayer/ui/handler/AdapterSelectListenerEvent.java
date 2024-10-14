package org.hyperskill.musicplayer.ui.handler;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lorg/hyperskill/musicplayer/ui/handler/AdapterSelectListenerEvent;", "Lorg/hyperskill/musicplayer/architecture/ui/event/EventHandler;", "playlistViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "selectorViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "(Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;)V", "getEventHandler", "Lorg/hyperskill/musicplayer/ui/listener/SongSelectListener;", "Music_Player-task_debug"})
public final class AdapterSelectListenerEvent implements org.hyperskill.musicplayer.architecture.ui.event.EventHandler {
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel = null;
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel = null;
    
    public AdapterSelectListenerEvent(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.hyperskill.musicplayer.ui.listener.SongSelectListener getEventHandler() {
        return null;
    }
}