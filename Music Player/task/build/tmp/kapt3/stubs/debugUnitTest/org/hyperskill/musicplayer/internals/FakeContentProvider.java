package org.hyperskill.musicplayer.internals;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\bH\u0002\u00a2\u0006\u0002\u0010\nJ1\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\bH\u0016\u00a2\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016JO\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\u001bJ;\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\bH\u0016\u00a2\u0006\u0002\u0010\u001d\u00a8\u0006\u001f"}, d2 = {"Lorg/hyperskill/musicplayer/internals/FakeContentProvider;", "Landroid/content/ContentProvider;", "()V", "addMockRows", "", "cursor", "Landroid/database/MatrixCursor;", "projection", "", "", "(Landroid/database/MatrixCursor;[Ljava/lang/String;)V", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "Music_Player-task_debugUnitTest"})
public final class FakeContentProvider extends android.content.ContentProvider {
    @org.jetbrains.annotations.NotNull()
    private static java.util.List<org.hyperskill.musicplayer.internals.SongFake> fakeSongResult;
    private static boolean hasPermissionToReadExternalStorage = true;
    @org.jetbrains.annotations.NotNull()
    public static final org.hyperskill.musicplayer.internals.FakeContentProvider.Companion Companion = null;
    
    public FakeContentProvider() {
        super();
    }
    
    @java.lang.Override()
    public boolean onCreate() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.database.Cursor query(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    java.lang.String[] projection, @org.jetbrains.annotations.Nullable()
    java.lang.String selection, @org.jetbrains.annotations.Nullable()
    java.lang.String[] selectionArgs, @org.jetbrains.annotations.Nullable()
    java.lang.String sortOrder) {
        return null;
    }
    
    private final void addMockRows(android.database.MatrixCursor cursor, java.lang.String[] projection) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getType(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.net.Uri insert(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    android.content.ContentValues values) {
        return null;
    }
    
    @java.lang.Override()
    public int delete(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    java.lang.String selection, @org.jetbrains.annotations.Nullable()
    java.lang.String[] selectionArgs) {
        return 0;
    }
    
    @java.lang.Override()
    public int update(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    android.content.ContentValues values, @org.jetbrains.annotations.Nullable()
    java.lang.String selection, @org.jetbrains.annotations.Nullable()
    java.lang.String[] selectionArgs) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lorg/hyperskill/musicplayer/internals/FakeContentProvider$Companion;", "", "()V", "fakeSongResult", "", "Lorg/hyperskill/musicplayer/internals/SongFake;", "getFakeSongResult", "()Ljava/util/List;", "setFakeSongResult", "(Ljava/util/List;)V", "hasPermissionToReadExternalStorage", "", "getHasPermissionToReadExternalStorage", "()Z", "setHasPermissionToReadExternalStorage", "(Z)V", "Music_Player-task_debugUnitTest"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<org.hyperskill.musicplayer.internals.SongFake> getFakeSongResult() {
            return null;
        }
        
        public final void setFakeSongResult(@org.jetbrains.annotations.NotNull()
        java.util.List<org.hyperskill.musicplayer.internals.SongFake> p0) {
        }
        
        public final boolean getHasPermissionToReadExternalStorage() {
            return false;
        }
        
        public final void setHasPermissionToReadExternalStorage(boolean p0) {
        }
    }
}