package org.hyperskill.musicplayer;

@org.junit.FixMethodOrder(value = org.junit.runners.MethodSorters.NAME_ASCENDING)
@org.robolectric.annotation.Config(shadows = {org.hyperskill.musicplayer.internals.CustomMediaPlayerShadow.class, org.hyperskill.musicplayer.internals.CustomShadowCountDownTimer.class, org.hyperskill.musicplayer.internals.CustomShadowAsyncDifferConfig.class})
@org.junit.runner.RunWith(value = org.robolectric.RobolectricTestRunner.class)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007J\b\u0010\f\u001a\u00020\u0005H\u0007J\b\u0010\r\u001a\u00020\u0005H\u0007J\b\u0010\u000e\u001a\u00020\u0005H\u0007J\b\u0010\u000f\u001a\u00020\u0005H\u0007J\b\u0010\u0010\u001a\u00020\u0005H\u0007J\b\u0010\u0011\u001a\u00020\u0005H\u0007J\b\u0010\u0012\u001a\u00020\u0005H\u0007J\b\u0010\u0013\u001a\u00020\u0005H\u0007J\b\u0010\u0014\u001a\u00020\u0005H\u0007\u00a8\u0006\u0015"}, d2 = {"Lorg/hyperskill/musicplayer/Stage3UnitTest;", "Lorg/hyperskill/musicplayer/internals/MusicPlayerUnitTests;", "Lorg/hyperskill/musicplayer/ui/MainActivity;", "()V", "setUp", "", "test00_checkControllerTriggersMediaPlayerOnDefaultItem", "test01_checkImgButtonTriggersMediaPlayerOnListItem", "test02_checkSeekBarChangeWhilePlaying", "test03_checkSeekBarBeforePlaying", "test04_checkSeekBarAfterStop", "test05_checkSeekBarAfterPause", "test06_checkMusicEnd", "test07_checkSeekBarChangeAfterMusicEnd", "test08_checkPlayAfterMusicEnd", "test09_checkImgButtonPlayAfterMusicEnd", "test10_checkSongChange", "test11_checkCancelAddPlaylistKeepsPlayingCurrentSelectedSong", "test12_checkLoadPlaylistKeepsPlayingCurrentSelectedSong", "test13_checkLoadPlaylistChangesSongIfCurrentSelectedSongNotInPlaylist", "test14_checkControllerKeepsStateAfterCancelAddPlaylist", "Music_Player-task_debugUnitTest"})
public final class Stage3UnitTest extends org.hyperskill.musicplayer.internals.MusicPlayerUnitTests<org.hyperskill.musicplayer.ui.MainActivity> {
    
    public Stage3UnitTest() {
        super(null);
    }
    
    @org.junit.Before()
    public final void setUp() {
    }
    
    @org.junit.Test()
    public final void test00_checkControllerTriggersMediaPlayerOnDefaultItem() {
    }
    
    @org.junit.Test()
    public final void test01_checkImgButtonTriggersMediaPlayerOnListItem() {
    }
    
    @org.junit.Test()
    public final void test02_checkSeekBarChangeWhilePlaying() {
    }
    
    @org.junit.Test()
    public final void test03_checkSeekBarBeforePlaying() {
    }
    
    @org.junit.Test()
    public final void test04_checkSeekBarAfterStop() {
    }
    
    @org.junit.Test()
    public final void test05_checkSeekBarAfterPause() {
    }
    
    @org.junit.Test()
    public final void test06_checkMusicEnd() {
    }
    
    @org.junit.Test()
    public final void test07_checkSeekBarChangeAfterMusicEnd() {
    }
    
    @org.junit.Test()
    public final void test08_checkPlayAfterMusicEnd() {
    }
    
    @org.junit.Test()
    public final void test09_checkImgButtonPlayAfterMusicEnd() {
    }
    
    @org.junit.Test()
    public final void test10_checkSongChange() {
    }
    
    @org.junit.Test()
    public final void test11_checkCancelAddPlaylistKeepsPlayingCurrentSelectedSong() {
    }
    
    @org.junit.Test()
    public final void test12_checkLoadPlaylistKeepsPlayingCurrentSelectedSong() {
    }
    
    @org.junit.Test()
    public final void test13_checkLoadPlaylistChangesSongIfCurrentSelectedSongNotInPlaylist() {
    }
    
    @org.junit.Test()
    public final void test14_checkControllerKeepsStateAfterCancelAddPlaylist() {
    }
}