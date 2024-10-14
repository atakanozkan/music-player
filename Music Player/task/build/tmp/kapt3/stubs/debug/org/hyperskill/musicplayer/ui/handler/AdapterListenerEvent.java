package org.hyperskill.musicplayer.ui.handler;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lorg/hyperskill/musicplayer/ui/handler/AdapterListenerEvent;", "Lorg/hyperskill/musicplayer/architecture/ui/event/EventHandler;", "playerViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "playlistViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "selectorViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "mapper", "Lorg/hyperskill/musicplayer/ui/mapper/SongTrackToUiMapper;", "songAdapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "longClickEvent", "Lkotlin/Function0;", "", "(Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;Lorg/hyperskill/musicplayer/ui/mapper/SongTrackToUiMapper;Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;Lkotlin/jvm/functions/Function0;)V", "getEventHandler", "Lorg/hyperskill/musicplayer/ui/listener/SongClickListener;", "Music_Player-task_debug"})
public final class AdapterListenerEvent implements org.hyperskill.musicplayer.architecture.ui.event.EventHandler {
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel playerViewModel = null;
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel = null;
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel = null;
    private final org.hyperskill.musicplayer.ui.mapper.SongTrackToUiMapper mapper = null;
    private final org.hyperskill.musicplayer.ui.adapter.SongAdapter songAdapter = null;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> longClickEvent = null;
    
    public AdapterListenerEvent(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel playerViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.mapper.SongTrackToUiMapper mapper, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.adapter.SongAdapter songAdapter, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> longClickEvent) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.hyperskill.musicplayer.ui.listener.SongClickListener getEventHandler() {
        return null;
    }
}