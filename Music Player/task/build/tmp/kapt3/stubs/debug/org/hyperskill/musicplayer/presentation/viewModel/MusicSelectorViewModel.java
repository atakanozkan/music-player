package org.hyperskill.musicplayer.presentation.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tJ$\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fJ\u0014\u0010 \u001a\u00020\u00112\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001fR\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\""}, d2 = {"Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "Lcom/videochat/architecture/presentation/viewmodel/BaseViewModel;", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "()V", "_allSelectorSongs", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lorg/hyperskill/musicplayer/presentation/model/SelectorPresentationalModel;", "_currentSelectedSongs", "", "Lorg/hyperskill/musicplayer/presentation/model/SongPresentationModel;", "allSelectorSongs", "Lkotlinx/coroutines/flow/StateFlow;", "getAllSelectorSongs", "()Lkotlinx/coroutines/flow/StateFlow;", "currentSelectedSongs", "getCurrentSelectedSongs", "addSelectedMusic", "", "song", "clearAllSelector", "clearSelectedMusics", "doesSongExistInSelector", "", "isPlaylistSame", "playlistId", "Ljava/util/UUID;", "removeSelectedMusic", "setAllSelector", "title", "", "list", "", "setCurrentSelectors", "playList", "Music_Player-task_debug"})
public final class MusicSelectorViewModel extends com.videochat.architecture.presentation.viewmodel.BaseViewModel<org.hyperskill.musicplayer.ui.model.ActionUiState> {
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<org.hyperskill.musicplayer.presentation.model.SongPresentationModel>> _currentSelectedSongs = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<org.hyperskill.musicplayer.presentation.model.SelectorPresentationalModel> _allSelectorSongs = null;
    
    public MusicSelectorViewModel() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<org.hyperskill.musicplayer.presentation.model.SongPresentationModel>> getCurrentSelectedSongs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<org.hyperskill.musicplayer.presentation.model.SelectorPresentationalModel> getAllSelectorSongs() {
        return null;
    }
    
    public final void addSelectedMusic(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.model.SongPresentationModel song) {
    }
    
    public final void removeSelectedMusic(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.model.SongPresentationModel song) {
    }
    
    public final void clearSelectedMusics() {
    }
    
    public final boolean doesSongExistInSelector(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.model.SongPresentationModel song) {
        return false;
    }
    
    public final boolean isPlaylistSame(@org.jetbrains.annotations.NotNull
    java.util.UUID playlistId) {
        return false;
    }
    
    public final void setCurrentSelectors(@org.jetbrains.annotations.NotNull
    java.util.List<org.hyperskill.musicplayer.presentation.model.SongPresentationModel> playList) {
    }
    
    public final void setAllSelector(@org.jetbrains.annotations.NotNull
    java.util.UUID playlistId, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.util.List<org.hyperskill.musicplayer.presentation.model.SongPresentationModel> list) {
    }
    
    public final void clearAllSelector() {
    }
}