package org.hyperskill.musicplayer.internals;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0006J6\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u001cJ \u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010*\u001a\u00020\u001eJ\u0006\u0010+\u001a\u00020%J$\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\u0006\u0010/\u001a\u00020\u001cJ\u0018\u00100\u001a\u00020(2\u0006\u0010\t\u001a\u00020\b2\u0006\u00101\u001a\u00020\u000fH\u0002J\u0014\u00102\u001a\u00020(2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u001c\u00104\u001a\u00020(*\u0002052\u0006\u00106\u001a\u00020\u001e2\b\b\u0001\u00107\u001a\u00020\u001cJ\u001a\u00108\u001a\u00020(*\u0002092\u0006\u00106\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u001cJ\u001c\u0010;\u001a\u00020\u001c*\u00020<2\u0006\u0010=\u001a\u00020\u001c2\b\b\u0002\u0010>\u001a\u00020?J\"\u0010@\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00020\u001c0\u00172\u0006\u0010A\u001a\u00020!2\b\b\u0002\u0010*\u001a\u00020\u001eJ\n\u0010B\u001a\u00020\u001e*\u00020\u001cR$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8D@DX\u0084\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8D@DX\u0084\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006C"}, d2 = {"Lorg/hyperskill/musicplayer/internals/MusicPlayerUnitTests;", "T", "Landroid/app/Activity;", "Lorg/hyperskill/musicplayer/internals/AbstractUnitTest;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "<anonymous parameter 0>", "Landroid/media/MediaPlayer;", "player", "getPlayer", "()Landroid/media/MediaPlayer;", "setPlayer", "(Landroid/media/MediaPlayer;)V", "playerPrivate", "Lorg/robolectric/shadows/ShadowMediaPlayer;", "shadowPlayer", "getShadowPlayer", "()Lorg/robolectric/shadows/ShadowMediaPlayer;", "setShadowPlayer", "(Lorg/robolectric/shadows/ShadowMediaPlayer;)V", "shadowPlayerPrivate", "songFakeList", "", "Lorg/hyperskill/musicplayer/internals/SongFake;", "getSongFakeList", "()Ljava/util/List;", "addPlaylist", "", "playlistName", "", "selectedItemsIndex", "songListView", "Landroidx/recyclerview/widget/RecyclerView;", "fragmentContainer", "Landroidx/fragment/app/FragmentContainerView;", "testEmptyName", "", "adjustPlayerPositionToAvoidSyncIssues", "assertViewStateIsPlayMusicState", "", "songList", "caseDescription", "isPlayerNull", "loadPlaylist", "menuItemIdLoadPlaylist", "expectedPlaylistNameList", "playlistToLoadIndex", "onMediaPlayerCreated", "shadow", "setupContentProvider", "fakeSongResult", "assertBackgroundColor", "Landroid/view/View;", "errorMessage", "expectedBackgroundColor", "assertCreatedFromResourceId", "Landroid/graphics/drawable/Drawable;", "expectedId", "clickAndRunOnItem", "Lorg/robolectric/shadows/ShadowAlertDialog;", "itemIndex", "millis", "", "clickSongSelectorListItems", "listView", "timeString", "Music_Player-task_debugUnitTest"})
public class MusicPlayerUnitTests<T extends android.app.Activity> extends org.hyperskill.musicplayer.internals.AbstractUnitTest<T> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<org.hyperskill.musicplayer.internals.SongFake> songFakeList = null;
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaPlayer playerPrivate;
    @org.jetbrains.annotations.Nullable()
    private org.robolectric.shadows.ShadowMediaPlayer shadowPlayerPrivate;
    
    public MusicPlayerUnitTests(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.hyperskill.musicplayer.internals.SongFake> getSongFakeList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final android.media.MediaPlayer getPlayer() {
        return null;
    }
    
    protected final void setPlayer(@org.jetbrains.annotations.NotNull()
    android.media.MediaPlayer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final org.robolectric.shadows.ShadowMediaPlayer getShadowPlayer() {
        return null;
    }
    
    protected final void setShadowPlayer(@org.jetbrains.annotations.NotNull()
    org.robolectric.shadows.ShadowMediaPlayer p0) {
    }
    
    public final boolean isPlayerNull() {
        return false;
    }
    
    private final void onMediaPlayerCreated(android.media.MediaPlayer player, org.robolectric.shadows.ShadowMediaPlayer shadow) {
    }
    
    public final void setupContentProvider(@org.jetbrains.annotations.NotNull()
    java.util.List<org.hyperskill.musicplayer.internals.SongFake> fakeSongResult) {
    }
    
    public final int clickAndRunOnItem(@org.jetbrains.annotations.NotNull()
    org.robolectric.shadows.ShadowAlertDialog $this$clickAndRunOnItem, int itemIndex, long millis) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String timeString(int $this$timeString) {
        return null;
    }
    
    public final void assertBackgroundColor(@org.jetbrains.annotations.NotNull()
    android.view.View $this$assertBackgroundColor, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMessage, @androidx.annotation.ColorInt()
    int expectedBackgroundColor) {
    }
    
    public final void assertCreatedFromResourceId(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable $this$assertCreatedFromResourceId, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMessage, int expectedId) {
    }
    
    public final int clickSongSelectorListItems(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> $this$clickSongSelectorListItems, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView listView, @org.jetbrains.annotations.NotNull()
    java.lang.String caseDescription) {
        return 0;
    }
    
    public final void assertViewStateIsPlayMusicState(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView songList, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentContainerView fragmentContainer, @org.jetbrains.annotations.NotNull()
    java.lang.String caseDescription) {
    }
    
    public final int addPlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistName, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> selectedItemsIndex, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView songListView, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentContainerView fragmentContainer, boolean testEmptyName) {
        return 0;
    }
    
    public final int loadPlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String menuItemIdLoadPlaylist, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expectedPlaylistNameList, int playlistToLoadIndex) {
        return 0;
    }
    
    public final int adjustPlayerPositionToAvoidSyncIssues() {
        return 0;
    }
}