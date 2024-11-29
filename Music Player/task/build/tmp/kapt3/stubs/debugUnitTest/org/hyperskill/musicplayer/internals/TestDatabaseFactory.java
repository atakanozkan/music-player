package org.hyperskill.musicplayer.internals;

/**
 * Use this class to get a testing database.
 *
 * example use-cases:
 * TestDatabaseFactory().writableDatabase.use {...}, for setting up a state before launching
 * the activity to test restoring of existing data by this activity.
 *
 * TestDatabaseFactory().readableDatabase.use {...}, for testing if data is is being saved
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010\u00a8\u0006 "}, d2 = {"Lorg/hyperskill/musicplayer/internals/TestDatabaseFactory;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "version", "", "(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V", "onCreateCalled", "", "getOnCreateCalled", "()Z", "setOnCreateCalled", "(Z)V", "onOpenCalled", "getOnOpenCalled", "setOnOpenCalled", "onUpgradeCalled", "getOnUpgradeCalled", "setOnUpgradeCalled", "close", "", "onCreate", "database", "Landroid/database/sqlite/SQLiteDatabase;", "onOpen", "onUpgrade", "oldVersion", "newVersion", "Music_Player-task_debugUnitTest"})
public final class TestDatabaseFactory extends android.database.sqlite.SQLiteOpenHelper {
    private boolean onCreateCalled = false;
    private boolean onUpgradeCalled = false;
    private boolean onOpenCalled = false;
    
    public TestDatabaseFactory(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase.CursorFactory factory, int version) {
        super(null, null, null, 0);
    }
    
    public final boolean getOnCreateCalled() {
        return false;
    }
    
    public final void setOnCreateCalled(boolean p0) {
    }
    
    public final boolean getOnUpgradeCalled() {
        return false;
    }
    
    public final void setOnUpgradeCalled(boolean p0) {
    }
    
    public final boolean getOnOpenCalled() {
        return false;
    }
    
    public final void setOnOpenCalled(boolean p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase database) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase database, int oldVersion, int newVersion) {
    }
    
    @java.lang.Override()
    public void onOpen(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase database) {
    }
    
    @java.lang.Override()
    @kotlin.jvm.Synchronized()
    public synchronized void close() {
    }
}