package org.hyperskill.musicplayer.presentation.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u001c\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020\'J\u0006\u0010(\u001a\u00020\u001cJ\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010*\u001a\u00020\u001cJ2\u0010+\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-2\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001c0/R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "Lcom/videochat/architecture/presentation/viewmodel/BaseViewModel;", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "musicPlayerDatabase", "Lorg/hyperskill/musicplayer/data/db/MusicPlayerDatabase;", "retrieveAllSongsFromMediaUseCase", "Lorg/hyperskill/musicplayer/domain/usecase/RetrieveAllSongsFromMediaUseCase;", "getSongFromMediaByIdUseCase", "Lorg/hyperskill/musicplayer/domain/usecase/GetSongFromMediaByIdUseCase;", "songMapper", "Lorg/hyperskill/musicplayer/presentation/mapper/SongDomainToPresentationMapper;", "(Lorg/hyperskill/musicplayer/data/db/MusicPlayerDatabase;Lorg/hyperskill/musicplayer/domain/usecase/RetrieveAllSongsFromMediaUseCase;Lorg/hyperskill/musicplayer/domain/usecase/GetSongFromMediaByIdUseCase;Lorg/hyperskill/musicplayer/presentation/mapper/SongDomainToPresentationMapper;)V", "_currentPlaylist", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lorg/hyperskill/musicplayer/presentation/model/PlaylistPresentationModel;", "allSongs", "getAllSongs", "()Lorg/hyperskill/musicplayer/presentation/model/PlaylistPresentationModel;", "currentPlaylist", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentPlaylist", "()Lkotlinx/coroutines/flow/StateFlow;", "playlists", "", "", "getPlaylists", "()Ljava/util/Map;", "checkForAutoLoadAll", "", "createPlaylist", "playlistName", "songList", "", "Lorg/hyperskill/musicplayer/presentation/model/SongPresentationModel;", "deletePlaylist", "id", "Ljava/util/UUID;", "generateUniqueID", "getSongFromCurrentPlaylist", "", "loadAllPlaylistsFromDb", "loadPlaylistFromDb", "setAllSongs", "setCurrentPlaylist", "currentSong", "Lorg/hyperskill/musicplayer/presentation/model/SongTrackPresentationModel;", "onSetCurrentSong", "Lkotlin/Function2;", "Lorg/hyperskill/musicplayer/ui/model/SongPlayMode;", "Music_Player-task_debug"})
public final class MusicPlaylistViewModel extends com.videochat.architecture.presentation.viewmodel.BaseViewModel<org.hyperskill.musicplayer.ui.model.ActionUiState> {
    private final org.hyperskill.musicplayer.data.db.MusicPlayerDatabase musicPlayerDatabase = null;
    private final org.hyperskill.musicplayer.domain.usecase.RetrieveAllSongsFromMediaUseCase retrieveAllSongsFromMediaUseCase = null;
    private final org.hyperskill.musicplayer.domain.usecase.GetSongFromMediaByIdUseCase getSongFromMediaByIdUseCase = null;
    private final org.hyperskill.musicplayer.presentation.mapper.SongDomainToPresentationMapper songMapper = null;
    @org.jetbrains.annotations.NotNull
    private final org.hyperskill.musicplayer.presentation.model.PlaylistPresentationModel allSongs = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, org.hyperskill.musicplayer.presentation.model.PlaylistPresentationModel> playlists = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<org.hyperskill.musicplayer.presentation.model.PlaylistPresentationModel> _currentPlaylist = null;
    
    public MusicPlaylistViewModel(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.data.db.MusicPlayerDatabase musicPlayerDatabase, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.domain.usecase.RetrieveAllSongsFromMediaUseCase retrieveAllSongsFromMediaUseCase, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.domain.usecase.GetSongFromMediaByIdUseCase getSongFromMediaByIdUseCase, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.presentation.mapper.SongDomainToPresentationMapper songMapper) {
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
    
    public final void loadAllPlaylistsFromDb() {
    }
    
    public final void loadPlaylistFromDb(@org.jetbrains.annotations.NotNull
    java.lang.String playlistName) {
    }
    
    public final void checkForAutoLoadAll() {
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
}