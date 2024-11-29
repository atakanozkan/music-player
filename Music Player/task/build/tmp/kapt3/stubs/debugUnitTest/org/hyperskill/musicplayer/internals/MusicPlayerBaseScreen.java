package org.hyperskill.musicplayer.internals;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lorg/hyperskill/musicplayer/internals/MusicPlayerBaseScreen;", "", "test", "Lorg/hyperskill/musicplayer/internals/MusicPlayerUnitTests;", "Lorg/hyperskill/musicplayer/ui/MainActivity;", "(Lorg/hyperskill/musicplayer/internals/MusicPlayerUnitTests;)V", "mainButtonSearch", "Landroid/widget/Button;", "getMainButtonSearch", "()Landroid/widget/Button;", "mainButtonSearch$delegate", "Lkotlin/Lazy;", "mainFragmentContainer", "Landroidx/fragment/app/FragmentContainerView;", "getMainFragmentContainer", "()Landroidx/fragment/app/FragmentContainerView;", "mainFragmentContainer$delegate", "mainSongList", "Landroidx/recyclerview/widget/RecyclerView;", "getMainSongList", "()Landroidx/recyclerview/widget/RecyclerView;", "mainSongList$delegate", "Companion", "Music_Player-task_debugUnitTest"})
public class MusicPlayerBaseScreen {
    @org.jetbrains.annotations.NotNull()
    private final org.hyperskill.musicplayer.internals.MusicPlayerUnitTests<org.hyperskill.musicplayer.ui.MainActivity> test = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID_MAIN_BUTTON_SEARCH = "mainButtonSearch";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID_MAIN_SONG_LIST = "mainSongList";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID_MAIN_FRAGMENT_CONTAINER = "mainFragmentContainer";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String mainMenuItemIdAddPlaylist = "mainMenuAddPlaylist";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String mainMenuItemIdLoadPlaylist = "mainMenuLoadPlaylist";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String mainMenuItemIdDeletePlaylist = "mainMenuDeletePlaylist";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainButtonSearch$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainSongList$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainFragmentContainer$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion Companion = null;
    
    public MusicPlayerBaseScreen(@org.jetbrains.annotations.NotNull()
    org.hyperskill.musicplayer.internals.MusicPlayerUnitTests<org.hyperskill.musicplayer.ui.MainActivity> test) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getMainButtonSearch() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getMainSongList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.fragment.app.FragmentContainerView getMainFragmentContainer() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lorg/hyperskill/musicplayer/internals/MusicPlayerBaseScreen$Companion;", "", "()V", "ID_MAIN_BUTTON_SEARCH", "", "ID_MAIN_FRAGMENT_CONTAINER", "ID_MAIN_SONG_LIST", "mainMenuItemIdAddPlaylist", "mainMenuItemIdDeletePlaylist", "mainMenuItemIdLoadPlaylist", "Music_Player-task_debugUnitTest"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}