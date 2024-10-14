package org.hyperskill.musicplayer.manager.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lorg/hyperskill/musicplayer/manager/listener/MainListenerManager;", "", "fragmentAttachManager", "Lorg/hyperskill/musicplayer/manager/fragment/FragmentAttachManager;", "playerViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "playlistViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "selectorViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "songAdapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "songSelectorAdapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;", "(Lorg/hyperskill/musicplayer/manager/fragment/FragmentAttachManager;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;)V", "getActionStateEventListener", "Lorg/hyperskill/musicplayer/domain/event/ActionStateEventListener;", "Music_Player-task_release"})
public final class MainListenerManager {
    private final org.hyperskill.musicplayer.manager.fragment.FragmentAttachManager fragmentAttachManager = null;
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel playerViewModel = null;
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel = null;
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel = null;
    private final org.hyperskill.musicplayer.ui.adapter.SongAdapter songAdapter = null;
    private final org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter songSelectorAdapter = null;
    
    public MainListenerManager(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.manager.fragment.FragmentAttachManager fragmentAttachManager, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel playerViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel playlistViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel selectorViewModel, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.adapter.SongAdapter songAdapter, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter songSelectorAdapter) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final org.hyperskill.musicplayer.domain.event.ActionStateEventListener getActionStateEventListener() {
        return null;
    }
}