package org.hyperskill.musicplayer;

@org.junit.FixMethodOrder(value = org.junit.runners.MethodSorters.NAME_ASCENDING)
@org.robolectric.annotation.Config(shadows = {org.hyperskill.musicplayer.internals.CustomMediaPlayerShadow.class, org.hyperskill.musicplayer.internals.CustomShadowCountDownTimer.class, org.hyperskill.musicplayer.internals.CustomShadowAsyncDifferConfig.class})
@org.junit.runner.RunWith(value = org.robolectric.RobolectricTestRunner.class)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007J\b\u0010\f\u001a\u00020\u0005H\u0007\u00a8\u0006\u000e"}, d2 = {"Lorg/hyperskill/musicplayer/Stage4UnitTest;", "Lorg/hyperskill/musicplayer/internals/MusicPlayerUnitTests;", "Lorg/hyperskill/musicplayer/ui/MainActivity;", "()V", "setUp", "", "tearDown", "test00_testPermissionRequestGranted", "test01_testListStateOnPermissionRequestDenied", "test02_testToastShowsOnPermissionRequestDenied", "test03_testPermissionRequestAgainGranted", "test04_testMusicFilesRetrievalAllFiles", "test05_testMusicFilesRetrievalNoFiles", "Companion", "Music_Player-task_debugUnitTest"})
public final class Stage4UnitTest extends org.hyperskill.musicplayer.internals.MusicPlayerUnitTests<org.hyperskill.musicplayer.ui.MainActivity> {
    public static final int expectedRequestCode = 1;
    @org.jetbrains.annotations.NotNull()
    public static final org.hyperskill.musicplayer.Stage4UnitTest.Companion Companion = null;
    
    public Stage4UnitTest() {
        super(null);
    }
    
    @org.junit.Before()
    public final void setUp() {
    }
    
    @org.junit.Test()
    public final void test00_testPermissionRequestGranted() {
    }
    
    @org.junit.Test()
    public final void test01_testListStateOnPermissionRequestDenied() {
    }
    
    @org.junit.Test()
    public final void test02_testToastShowsOnPermissionRequestDenied() {
    }
    
    @org.junit.Test()
    public final void test03_testPermissionRequestAgainGranted() {
    }
    
    @org.junit.Test()
    public final void test04_testMusicFilesRetrievalAllFiles() {
    }
    
    @org.junit.Test()
    public final void test05_testMusicFilesRetrievalNoFiles() {
    }
    
    @org.junit.After()
    public final void tearDown() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/hyperskill/musicplayer/Stage4UnitTest$Companion;", "", "()V", "expectedRequestCode", "", "Music_Player-task_debugUnitTest"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}