package org.hyperskill.musicplayer.ui.provider;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lorg/hyperskill/musicplayer/ui/provider/MainActivityViewsProvider;", "Lcom/videochat/architecture/ui/binder/ViewsProvider;", "mainButtonSearch", "Landroid/widget/Button;", "getMainButtonSearch", "()Landroid/widget/Button;", "mainFragmentContainer", "Landroidx/fragment/app/FragmentContainerView;", "getMainFragmentContainer", "()Landroidx/fragment/app/FragmentContainerView;", "mainSongList", "Landroidx/recyclerview/widget/RecyclerView;", "getMainSongList", "()Landroidx/recyclerview/widget/RecyclerView;", "Music_Player-task_debug"})
public abstract interface MainActivityViewsProvider extends com.videochat.architecture.ui.binder.ViewsProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.widget.Button getMainButtonSearch();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.recyclerview.widget.RecyclerView getMainSongList();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.fragment.app.FragmentContainerView getMainFragmentContainer();
}