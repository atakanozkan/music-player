package org.hyperskill.musicplayer.presentation.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001c\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020\'J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010)\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0016J\u0006\u0010*\u001a\u00020\u001aJ2\u0010+\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-2\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001a0/R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "Lcom/videochat/architecture/presentation/viewmodel/BaseViewModel;", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "musicPlayerDatabase", "Lorg/hyperskill/musicplayer/data/db/MusicPlayerDatabase;", "retrieveAllSongsFromMediaUseCase", "Lorg/hyperskill/musicplayer/domain/usecase/RetrieveAllSongsFromMediaUseCase;", "getSongFromMediaByIdUseCase", "Lorg/hyperskill/musicplayer/domain/usecase/GetSongFromMediaByIdUseCase;", "(Lorg/hyperskill/musicplayer/data/db/MusicPlayerDatabase;Lorg/hyperskill/musicplayer/domain/usecase/RetrieveAllSongsFromMediaUseCase;Lorg/hyperskill/musicplayer/domain/usecase/GetSongFromMediaByIdUseCase;)V", "_currentPlaylist", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lorg/hyperskill/musicplayer/presentation/model/PlaylistPresentationModel;", "allSongs", "getAllSongs", "()Lorg/hyperskill/musicplayer/presentation/model/PlaylistPresentationModel;", "currentPlaylist", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentPlaylist", "()Lkotlinx/coroutines/flow/StateFlow;", "playlists", "", "", "getPlaylists", "()Ljava/util/Map;", "checkForAutoLoadAll", "", "context", "Landroid/content/Context;", "createPlaylist", "playlistName", "songList", "", "Lorg/hyperskill/musicplayer/presentation/model/SongPresentationModel;", "deletePlaylist", "id", "Ljava/util/UUID;", "generateUniqueID", "getSongFromCurrentPlaylist", "", "loadAllPlaylistsFromDb", "loadPlaylistFromDb", "setAllSongs", "setCurrentPlaylist", "currentSong", "Lorg/hyperskill/musicplayer/presentation/model/SongTrackPresentationModel;", "onSetCurrentSong", "Lkotlin/Function2;", "Lorg/hyperskill/musicplayer/ui/model/SongPlayMode;", "MusicPlaylistViewModelFactory", "Music_Player-task_release"})
public final class MusicPlaylistViewModel extends com.videochat.architecture.presentation.viewmodel.BaseViewModel<org.hyperskill.musicplayer.ui.model.ActionUiState> {
    private final org.hyperskill.musicplayer.data.db.MusicPlayerDatabase musicPlayerDatabase = null;
    private final org.hyperskill.musicplayer.domain.usecase.RetrieveAllSongsFromMediaUseCase retrieveAllSongsFromMediaUseCase = null;
    private final org.hyperskill.musicplayer.domain.usecase.GetSongFromMediaByIdUseCase getSongFromMediaByIdUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final org.hyperskill.musicplayer.presentation.model.PlaylistPresentationModel allSongs = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, org.hyperskill.musicplayer.presentation.model.PlaylistPresentationModel> playlists = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<org.hyperskill.musicplayer.presentation.model.PlaylistPresentationModel> _currentPlaylist = null;
    
    public MusicPlaylistViewModel(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.data.db.MusicPlayerDatabase musicPlayerDatabase, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.domain.usecase.RetrieveAllSongsFromMediaUseCase retrieveAllSongsFromMediaUseCase, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.domain.usecase.GetSongFromMediaByIdUseCase getSongFromMediaByIdUseCase) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final org.hyperskill.musicplayer.presentation.model.PlaylistPresentationModel getAllSongs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, org.hyperskill.musicplayer.presentation.model.PlaylistPresentationModel> getPlaylists() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<org.hyperskill.musicplayer.presentation.model.PlaylistPresentationModel> getCurrentPlaylist() {
        return null;
    }
    
    public final void loadAllPlaylistsFromDb(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void loadPlaylistFromDb(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String playlistName) {
    }
    
    public final void checkForAutoLoadAll(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void createPlaylist(@org.jetbrains.annotations.NotNull
    java.lang.String playlistName, @org.jetbrains.annotations.NotNull
    java.util.List<org.hyperskill.musicplayer.presentation.model.SongPresentationModel> songList) {
    }
    
    public final void deletePlaylist(@org.jetbrains.annotations.NotNull
    java.util.UUID id) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final org.hyperskill.musicplayer.presentation.model.SongPresentationModel getSongFromCurrentPlaylist(long id) {
        return null;
    }
    
    public final void setAllSongs() {
    }
    
    public final void setCurrentPlaylist(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.Nullable
    org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel currentSong, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super org.hyperskill.musicplayer.presentation.model.SongPresentationModel, ? super org.hyperskill.musicplayer.ui.model.SongPlayMode, kotlin.Unit> onSetCurrentSong) {
    }
    
    private final java.util.UUID generateUniqueID() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel$MusicPlaylistViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "musicPlayerDatabase", "Lorg/hyperskill/musicplayer/data/db/MusicPlayerDatabase;", "retrieveAllSongsFromMediaUseCase", "Lorg/hyperskill/musicplayer/domain/usecase/RetrieveAllSongsFromMediaUseCase;", "getSongFromMediaByIdUseCase", "Lorg/hyperskill/musicplayer/domain/usecase/GetSongFromMediaByIdUseCase;", "(Lorg/hyperskill/musicplayer/data/db/MusicPlayerDatabase;Lorg/hyperskill/musicplayer/domain/usecase/RetrieveAllSongsFromMediaUseCase;Lorg/hyperskill/musicplayer/domain/usecase/GetSongFromMediaByIdUseCase;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Music_Player-task_release"})
    public static final class MusicPlaylistViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
        private final org.hyperskill.musicplayer.data.db.MusicPlayerDatabase musicPlayerDatabase = null;
        private final org.hyperskill.musicplayer.domain.usecase.RetrieveAllSongsFromMediaUseCase retrieveAllSongsFromMediaUseCase = null;
        private final org.hyperskill.musicplayer.domain.usecase.GetSongFromMediaByIdUseCase getSongFromMediaByIdUseCase = null;
        
        public MusicPlaylistViewModelFactory(@org.jetbrains.annotations.NotNull
        org.hyperskill.musicplayer.data.db.MusicPlayerDatabase musicPlayerDatabase, @org.jetbrains.annotations.NotNull
        org.hyperskill.musicplayer.domain.usecase.RetrieveAllSongsFromMediaUseCase retrieveAllSongsFromMediaUseCase, @org.jetbrains.annotations.NotNull
        org.hyperskill.musicplayer.domain.usecase.GetSongFromMediaByIdUseCase getSongFromMediaByIdUseCase) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}