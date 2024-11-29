package org.hyperskill.musicplayer;

@org.junit.FixMethodOrder(value = org.junit.runners.MethodSorters.NAME_ASCENDING)
@org.robolectric.annotation.Config(shadows = {org.hyperskill.musicplayer.internals.CustomMediaPlayerShadow.class, org.hyperskill.musicplayer.internals.CustomShadowAsyncDifferConfig.class})
@org.junit.runner.RunWith(value = org.robolectric.RobolectricTestRunner.class)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007J\b\u0010\f\u001a\u00020\u0005H\u0007J\b\u0010\r\u001a\u00020\u0005H\u0007J\b\u0010\u000e\u001a\u00020\u0005H\u0007J\b\u0010\u000f\u001a\u00020\u0005H\u0007J\b\u0010\u0010\u001a\u00020\u0005H\u0007J\b\u0010\u0011\u001a\u00020\u0005H\u0007J\b\u0010\u0012\u001a\u00020\u0005H\u0007J\b\u0010\u0013\u001a\u00020\u0005H\u0007J\b\u0010\u0014\u001a\u00020\u0005H\u0007J\b\u0010\u0015\u001a\u00020\u0005H\u0007J\b\u0010\u0016\u001a\u00020\u0005H\u0007J\b\u0010\u0017\u001a\u00020\u0005H\u0007J\b\u0010\u0018\u001a\u00020\u0005H\u0007J\b\u0010\u0019\u001a\u00020\u0005H\u0007J\b\u0010\u001a\u001a\u00020\u0005H\u0007J\b\u0010\u001b\u001a\u00020\u0005H\u0007J\b\u0010\u001c\u001a\u00020\u0005H\u0007J\b\u0010\u001d\u001a\u00020\u0005H\u0007J\b\u0010\u001e\u001a\u00020\u0005H\u0007J\b\u0010\u001f\u001a\u00020\u0005H\u0007\u00a8\u0006 "}, d2 = {"Lorg/hyperskill/musicplayer/Stage2UnitTest;", "Lorg/hyperskill/musicplayer/internals/MusicPlayerUnitTests;", "Lorg/hyperskill/musicplayer/ui/MainActivity;", "()V", "setUp", "", "test00_checkSongListAfterInitialClickOnSearch", "test01_checkSongListItemChangesImageOnImageButtonClick", "test02_checkWhenCurrentTrackChangesAndOldCurrentTrackIsPlayingImageChangesToPaused", "test03_checkWhenCurrentTrackChangesAndOldCurrentTrackIsNotPlayingImageRemains", "test04_checkAfterInitialSearchFirstListItemIsCurrentTrackAndRespondToControllerPlayPauseButton", "test05_checkCurrentTrackImgChangeAfterControllerStopButtonClickWithCurrentTrackPlaying", "test06_checkListItemImgChangeMixedClicks", "test07_checkAddPlaylistStateTriggeredByMenuItem", "test08_checkAddingPlaylistWithEmptyListAddedToastErrorEmptyListMessage", "test09_checkAddingPlaylistWithBothEmptyListAndEmptyPlaylistNameToastErrorEmptyListMessage", "test10_checkAddingPlaylistWithReservedPlaylistNameAllSongsToastErrorReservedNameMessage", "test11_checkLoadPlaylistInPlayMusicStateAfterAddingPlaylistWithMainMenuItem", "test12_checkLoadPlaylistInPlayMusicStateAfterAddingPlaylistWithLongClick", "test13_checkLoadPlaylistOnPlayMusicStateWithCurrentTrackKeepsCurrentTrack", "test14_checkLoadPlaylistOnPlayMusicStateWithoutCurrentTrackChangesCurrentTrack", "test15_checkLoadPlaylistInAddPlaylistStateKeepsSelectedItemsById", "test16_checkLoadPlaylistInAddPlaylistStateKeepsCurrentTrackWhenReturningToPlayMusicState", "test17_checkPlaylistSavedAfterSelectingSongsAfterLoadingPlaylistInAddPlaylistState", "test18_checkCancellingAddPlaylistKeepsCurrentPlaylist", "test19_checkCancelingAddPlaylistKeepsCurrentTrackPlayingState", "test20_checkDeletePlaylistOnPlayMusicStateDeletingPlaylistThatIsNotCurrentPlaylist", "test21_checkDeletePlaylistOnPlayMusicStateWithCurrentPlaylistBeingDeleted", "test22_checkDeletePlaylistOnAddPlaylistStateDeletingPlaylistThatIsNotDisplayingAndNotCurrentPlaylist", "test23_checkDeletePlaylistOnAddPlaylistStateWithCurrentDisplayingAndCurrentPlaylistBeingDeleted", "test24_checkSearchInPlayMusicStateChangeCurrentPlaylistToAllSongs", "test25_checkSearchInAddPlaylistStateDisplaysAllSongsOnAddPlaylistStateAndKeepsCurrentPlaylistInPlayMusicState", "Music_Player-task_debugUnitTest"})
public final class Stage2UnitTest extends org.hyperskill.musicplayer.internals.MusicPlayerUnitTests<org.hyperskill.musicplayer.ui.MainActivity> {
    
    public Stage2UnitTest() {
        super(null);
    }
    
    @org.junit.Before()
    public final void setUp() {
    }
    
    @org.junit.Test()
    public final void test00_checkSongListAfterInitialClickOnSearch() {
    }
    
    @org.junit.Test()
    public final void test01_checkSongListItemChangesImageOnImageButtonClick() {
    }
    
    @org.junit.Test()
    public final void test02_checkWhenCurrentTrackChangesAndOldCurrentTrackIsPlayingImageChangesToPaused() {
    }
    
    @org.junit.Test()
    public final void test03_checkWhenCurrentTrackChangesAndOldCurrentTrackIsNotPlayingImageRemains() {
    }
    
    @org.junit.Test()
    public final void test04_checkAfterInitialSearchFirstListItemIsCurrentTrackAndRespondToControllerPlayPauseButton() {
    }
    
    @org.junit.Test()
    public final void test05_checkCurrentTrackImgChangeAfterControllerStopButtonClickWithCurrentTrackPlaying() {
    }
    
    @org.junit.Test()
    public final void test06_checkListItemImgChangeMixedClicks() {
    }
    
    @org.junit.Test()
    public final void test07_checkAddPlaylistStateTriggeredByMenuItem() {
    }
    
    @org.junit.Test()
    public final void test08_checkAddingPlaylistWithEmptyListAddedToastErrorEmptyListMessage() {
    }
    
    @org.junit.Test()
    public final void test09_checkAddingPlaylistWithBothEmptyListAndEmptyPlaylistNameToastErrorEmptyListMessage() {
    }
    
    @org.junit.Test()
    public final void test10_checkAddingPlaylistWithReservedPlaylistNameAllSongsToastErrorReservedNameMessage() {
    }
    
    @org.junit.Test()
    public final void test11_checkLoadPlaylistInPlayMusicStateAfterAddingPlaylistWithMainMenuItem() {
    }
    
    @org.junit.Test()
    public final void test12_checkLoadPlaylistInPlayMusicStateAfterAddingPlaylistWithLongClick() {
    }
    
    @org.junit.Test()
    public final void test13_checkLoadPlaylistOnPlayMusicStateWithCurrentTrackKeepsCurrentTrack() {
    }
    
    @org.junit.Test()
    public final void test14_checkLoadPlaylistOnPlayMusicStateWithoutCurrentTrackChangesCurrentTrack() {
    }
    
    @org.junit.Test()
    public final void test15_checkLoadPlaylistInAddPlaylistStateKeepsSelectedItemsById() {
    }
    
    @org.junit.Test()
    public final void test16_checkLoadPlaylistInAddPlaylistStateKeepsCurrentTrackWhenReturningToPlayMusicState() {
    }
    
    @org.junit.Test()
    public final void test17_checkPlaylistSavedAfterSelectingSongsAfterLoadingPlaylistInAddPlaylistState() {
    }
    
    @org.junit.Test()
    public final void test18_checkCancellingAddPlaylistKeepsCurrentPlaylist() {
    }
    
    @org.junit.Test()
    public final void test19_checkCancelingAddPlaylistKeepsCurrentTrackPlayingState() {
    }
    
    @org.junit.Test()
    public final void test20_checkDeletePlaylistOnPlayMusicStateDeletingPlaylistThatIsNotCurrentPlaylist() {
    }
    
    @org.junit.Test()
    public final void test21_checkDeletePlaylistOnPlayMusicStateWithCurrentPlaylistBeingDeleted() {
    }
    
    @org.junit.Test()
    public final void test22_checkDeletePlaylistOnAddPlaylistStateDeletingPlaylistThatIsNotDisplayingAndNotCurrentPlaylist() {
    }
    
    @org.junit.Test()
    public final void test23_checkDeletePlaylistOnAddPlaylistStateWithCurrentDisplayingAndCurrentPlaylistBeingDeleted() {
    }
    
    @org.junit.Test()
    public final void test24_checkSearchInPlayMusicStateChangeCurrentPlaylistToAllSongs() {
    }
    
    @org.junit.Test()
    public final void test25_checkSearchInAddPlaylistStateDisplaysAllSongsOnAddPlaylistStateAndKeepsCurrentPlaylistInPlayMusicState() {
    }
}