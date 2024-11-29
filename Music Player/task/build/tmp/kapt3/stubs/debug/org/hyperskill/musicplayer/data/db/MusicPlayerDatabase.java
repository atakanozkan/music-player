package org.hyperskill.musicplayer.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u001a\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\nH&J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u000e"}, d2 = {"Lorg/hyperskill/musicplayer/data/db/MusicPlayerDatabase;", "", "addPlaylist", "", "playlistName", "", "songIds", "", "", "getAllPlaylistsGrouped", "", "getPlaylist", "Lorg/hyperskill/musicplayer/domain/entity/PlaylistEntry;", "removePlaylist", "Music_Player-task_debug"})
public abstract interface MusicPlayerDatabase {
    
    public abstract void addPlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistName, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> songIds);
    
    public abstract void removePlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistName);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<org.hyperskill.musicplayer.domain.entity.PlaylistEntry> getPlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistName);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.Map<java.lang.String, java.util.List<java.lang.Long>> getAllPlaylistsGrouped();
}