package org.hyperskill.musicplayer.ui.fragment;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010%\u001a\u00020&J\u0006\u0010\'\u001a\u00020&J\u001a\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0006\u0010-\u001a\u00020&J\u0006\u0010.\u001a\u00020&J\b\u0010/\u001a\u00020&H\u0016J\f\u00100\u001a\u00020&*\u000201H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020 X\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00062"}, d2 = {"Lorg/hyperskill/musicplayer/ui/fragment/MainAddPlaylistFragment;", "Lcom/videochat/architecture/ui/view/BaseFragment;", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "Lorg/hyperskill/musicplayer/ui/provider/MainAddPlaylistViewsProvider;", "Lorg/hyperskill/musicplayer/databinding/MainAddPlaylistFragmentBinding;", "()V", "selectorAdapterFragment", "Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;", "getSelectorAdapterFragment", "()Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;", "setSelectorAdapterFragment", "(Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;)V", "selectorViewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "getSelectorViewModel", "()Lorg/hyperskill/musicplayer/presentation/viewModel/MusicSelectorViewModel;", "selectorViewModel$delegate", "Lkotlin/Lazy;", "songAdapterFragment", "Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "getSongAdapterFragment", "()Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "setSongAdapterFragment", "(Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;)V", "viewHolder", "Lorg/hyperskill/musicplayer/ui/holder/MainAddPlaylistViewsHolder;", "viewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "getViewModel", "()Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlaylistViewModel;", "viewModel$delegate", "viewStateBinder", "Lorg/hyperskill/musicplayer/ui/binder/MainAddPlaylistFragmentBinder;", "getViewStateBinder", "()Lorg/hyperskill/musicplayer/ui/binder/MainAddPlaylistFragmentBinder;", "setViewStateBinder", "(Lorg/hyperskill/musicplayer/ui/binder/MainAddPlaylistFragmentBinder;)V", "changeBackPlayer", "", "displayToastIfEmpty", "initializeBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setAddPlaylistBtn", "setPlaylistCancelButton", "setupViews", "bindViews", "Landroid/view/View;", "Music_Player-task_debug"})
public final class MainAddPlaylistFragment extends com.videochat.architecture.ui.view.BaseFragment<org.hyperskill.musicplayer.ui.model.ActionUiState, org.hyperskill.musicplayer.ui.provider.MainAddPlaylistViewsProvider, org.hyperskill.musicplayer.databinding.MainAddPlaylistFragmentBinding> {
    private org.hyperskill.musicplayer.ui.holder.MainAddPlaylistViewsHolder viewHolder;
    public org.hyperskill.musicplayer.ui.binder.MainAddPlaylistFragmentBinder viewStateBinder;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy selectorViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter selectorAdapterFragment;
    @org.jetbrains.annotations.Nullable()
    private org.hyperskill.musicplayer.ui.adapter.SongAdapter songAdapterFragment;
    
    public MainAddPlaylistFragment() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.hyperskill.musicplayer.ui.binder.MainAddPlaylistFragmentBinder getViewStateBinder() {
        return null;
    }
    
    public void setViewStateBinder(@org.jetbrains.annotations.NotNull()
    org.hyperskill.musicplayer.ui.binder.MainAddPlaylistFragmentBinder p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel getViewModel() {
        return null;
    }
    
    private final org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel getSelectorViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter getSelectorAdapterFragment() {
        return null;
    }
    
    public final void setSelectorAdapterFragment(@org.jetbrains.annotations.Nullable()
    org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.hyperskill.musicplayer.ui.adapter.SongAdapter getSongAdapterFragment() {
        return null;
    }
    
    public final void setSongAdapterFragment(@org.jetbrains.annotations.Nullable()
    org.hyperskill.musicplayer.ui.adapter.SongAdapter p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.hyperskill.musicplayer.databinding.MainAddPlaylistFragmentBinding initializeBinding(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container) {
        return null;
    }
    
    @java.lang.Override()
    public void bindViews(@org.jetbrains.annotations.NotNull()
    android.view.View $this$bindViews) {
    }
    
    @java.lang.Override()
    public void setupViews() {
    }
    
    public final void setPlaylistCancelButton() {
    }
    
    public final void setAddPlaylistBtn() {
    }
    
    public final void displayToastIfEmpty() {
    }
    
    public final void changeBackPlayer() {
    }
}