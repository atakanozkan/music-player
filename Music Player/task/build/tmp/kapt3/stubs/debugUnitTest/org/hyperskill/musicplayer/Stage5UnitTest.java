package org.hyperskill.musicplayer;

@org.junit.FixMethodOrder(value = org.junit.runners.MethodSorters.NAME_ASCENDING)
@org.robolectric.annotation.Config(shadows = {org.hyperskill.musicplayer.internals.CustomMediaPlayerShadow.class, org.hyperskill.musicplayer.internals.CustomShadowCountDownTimer.class, org.hyperskill.musicplayer.internals.CustomShadowAsyncDifferConfig.class})
@org.junit.runner.RunWith(value = org.robolectric.RobolectricTestRunner.class)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007\u00a8\u0006\r"}, d2 = {"Lorg/hyperskill/musicplayer/Stage5UnitTest;", "Lorg/hyperskill/musicplayer/internals/MusicPlayerUnitTests;", "Lorg/hyperskill/musicplayer/ui/MainActivity;", "()V", "setUp", "", "test00_checkDatabaseDataAfterPlaylistSave", "test01_checkSamePlaylistSaveTwiceNoDuplicatesOnDatabase", "test02_checkDatabaseDataAfterPlaylistSaveWithExistingPlaylistNameAndDifferentSongs", "test03_checkDatabaseDifferentPlaylistSaves", "test04_checkLoadPlaylistFromDatabase", "test05_checkAutomaticSearchOnPlaylistLoad", "Companion", "Music_Player-task_debugUnitTest"})
public final class Stage5UnitTest extends org.hyperskill.musicplayer.internals.MusicPlayerUnitTests<org.hyperskill.musicplayer.ui.MainActivity> {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String tableName = "playlist";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String columnSongId = "songId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String columnPlaylistName = "playlistName";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String createQuery = "CREATE TABLE IF NOT EXISTS playlist(playlistName TEXT, songId INTEGER, PRIMARY KEY(playlistName, songId));";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ALL_SONGS = "All Songs";
    @org.jetbrains.annotations.NotNull()
    public static final org.hyperskill.musicplayer.Stage5UnitTest.Companion Companion = null;
    
    public Stage5UnitTest() {
        super(null);
    }
    
    @org.junit.Before()
    public final void setUp() {
    }
    
    @org.junit.Test()
    public final void test00_checkDatabaseDataAfterPlaylistSave() {
    }
    
    @org.junit.Test()
    public final void test01_checkSamePlaylistSaveTwiceNoDuplicatesOnDatabase() {
    }
    
    @org.junit.Test()
    public final void test02_checkDatabaseDataAfterPlaylistSaveWithExistingPlaylistNameAndDifferentSongs() {
    }
    
    @org.junit.Test()
    public final void test03_checkDatabaseDifferentPlaylistSaves() {
    }
    
    @org.junit.Test()
    public final void test04_checkLoadPlaylistFromDatabase() {
    }
    
    @org.junit.Test()
    public final void test05_checkAutomaticSearchOnPlaylistLoad() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lorg/hyperskill/musicplayer/Stage5UnitTest$Companion;", "", "()V", "ALL_SONGS", "", "columnPlaylistName", "columnSongId", "createQuery", "tableName", "Music_Player-task_debugUnitTest"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}