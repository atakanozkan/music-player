package org.hyperskill.musicplayer.data.db.impl;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000eH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\u0019"}, d2 = {"Lorg/hyperskill/musicplayer/data/db/impl/MusicPlayerDatabaseImpl;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Lorg/hyperskill/musicplayer/data/db/MusicPlayerDatabase;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addPlaylist", "", "playlistName", "", "songIds", "", "", "getAllPlaylistsGrouped", "", "getPlaylist", "Lorg/hyperskill/musicplayer/domain/entity/PlaylistEntry;", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "p1", "", "p2", "removePlaylist", "Music_Player-task_debug"})
public final class MusicPlayerDatabaseImpl extends android.database.sqlite.SQLiteOpenHelper implements org.hyperskill.musicplayer.data.db.MusicPlayerDatabase {
    
    public MusicPlayerDatabaseImpl(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, null, null, 0);
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db, int p1, int p2) {
    }
    
    @java.lang.Override()
    public void addPlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistName, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> songIds) {
    }
    
    @java.lang.Override()
    public void removePlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistName) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.hyperskill.musicplayer.domain.entity.PlaylistEntry> getPlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistName) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Map<java.lang.String, java.util.List<java.lang.Long>> getAllPlaylistsGrouped() {
        return null;
    }
}