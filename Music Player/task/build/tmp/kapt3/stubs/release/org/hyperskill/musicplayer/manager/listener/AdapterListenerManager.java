package org.hyperskill.musicplayer.manager.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lorg/hyperskill/musicplayer/manager/listener/AdapterListenerManager;", "", "playerViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "playlistViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "selectorViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "(Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;)V", "getSongClickListener", "Lorg/hyperskill/musicplayer/domain/event/SongClickListener;", "songAdapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "longClickEvent", "Lkotlin/Function0;", "", "getSongSelectListener", "Lorg/hyperskill/musicplayer/domain/event/SongSelectListener;", "Music_Player-task_release"})
public final class AdapterListenerManager {
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel playerViewModel = null;
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel = null;
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel = null;
    
    public AdapterListenerManager(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel playerViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final org.hyperskill.musicplayer.domain.event.SongClickListener getSongClickListener(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.adapter.SongAdapter songAdapter, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> longClickEvent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final org.hyperskill.musicplayer.domain.event.SongSelectListener getSongSelectListener() {
        return null;
    }
}