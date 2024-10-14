package org.hyperskill.musicplayer.data.db;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\u0018"}, d2 = {"Lorg/hyperskill/musicplayer/data/db/MusicPlayerDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addPlaylist", "", "playlistName", "", "songIds", "", "", "getAllPlaylistsGrouped", "", "getPlaylist", "Lorg/hyperskill/musicplayer/domain/entity/PlaylistEntry;", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "p1", "", "p2", "removePlaylist", "Music_Player-task_release"})
public final class MusicPlayerDatabase extends android.database.sqlite.SQLiteOpenHelper {
    
    public MusicPlayerDatabase(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null, null, null, 0);
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.NotNull
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override
    public void onUpgrade(@org.jetbrains.annotations.Nullable
    android.database.sqlite.SQLiteDatabase db, int p1, int p2) {
    }
    
    public final void addPlaylist(@org.jetbrains.annotations.NotNull
    java.lang.String playlistName, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> songIds) {
    }
    
    public final void removePlaylist(@org.jetbrains.annotations.NotNull
    java.lang.String playlistName) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<org.hyperskill.musicplayer.domain.entity.PlaylistEntry> getPlaylist(@org.jetbrains.annotations.NotNull
    java.lang.String playlistName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.util.List<java.lang.Long>> getAllPlaylistsGrouped() {
        return null;
    }
}