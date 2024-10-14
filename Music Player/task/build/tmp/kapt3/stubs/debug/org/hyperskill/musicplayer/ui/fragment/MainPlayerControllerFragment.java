package org.hyperskill.musicplayer.ui.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0003J\u001a\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020)H\u0002J\u0010\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020-H\u0002J\b\u00101\u001a\u00020)H\u0002J\b\u00102\u001a\u00020)H\u0002J\b\u00103\u001a\u00020)H\u0016J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020-H\u0002J\f\u00106\u001a\u00020)*\u000207H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u001aX\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u00068"}, d2 = {"Lorg/hyperskill/musicplayer/ui/fragment/MainPlayerControllerFragment;", "Lcom/videochat/architecture/ui/view/BaseFragment;", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "Lorg/hyperskill/musicplayer/ui/provider/MainPlayerControllerViewsProvider;", "Lorg/hyperskill/musicplayer/databinding/MainPlayerControllerFragmentBinding;", "()V", "adapter", "Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "getAdapter", "()Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "setAdapter", "(Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;)V", "songToUiMapper", "Lorg/hyperskill/musicplayer/ui/mapper/SongToUiMapper;", "getSongToUiMapper", "()Lorg/hyperskill/musicplayer/ui/mapper/SongToUiMapper;", "songToUiMapper$delegate", "Lkotlin/Lazy;", "viewHolder", "Lorg/hyperskill/musicplayer/ui/holder/MainPlayerControllerViewsHolder;", "viewModel", "Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "getViewModel", "()Lorg/hyperskill/musicplayer/presentation/viewModel/MusicPlayerViewModel;", "viewModel$delegate", "viewStateBinder", "Lorg/hyperskill/musicplayer/ui/binder/MainPlayerControllerFragmentBinder;", "getViewStateBinder", "()Lorg/hyperskill/musicplayer/ui/binder/MainPlayerControllerFragmentBinder;", "setViewStateBinder", "(Lorg/hyperskill/musicplayer/ui/binder/MainPlayerControllerFragmentBinder;)V", "formatDurationInSeconds", "", "durationInSeconds", "", "initializeBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setControllerBtnPlayPause", "", "setControllerBtnStop", "setControllerTvTotalTime", "value", "", "setCurrentChangeOnTrack", "setMaxDuration", "duration", "setObserverOnWorker", "setSeekBar", "setupViews", "updateSeekBarAndTime", "currentPosition", "bindViews", "Landroid/view/View;", "Music_Player-task_debug"})
public final class MainPlayerControllerFragment extends com.videochat.architecture.ui.view.BaseFragment<org.hyperskill.musicplayer.ui.model.ActionUiState, org.hyperskill.musicplayer.ui.provider.MainPlayerControllerViewsProvider, org.hyperskill.musicplayer.databinding.MainPlayerControllerFragmentBinding> {
    private org.hyperskill.musicplayer.ui.holder.MainPlayerControllerViewsHolder viewHolder;
    public org.hyperskill.musicplayer.ui.binder.MainPlayerControllerFragmentBinder viewStateBinder;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy songToUiMapper$delegate = null;
    @org.jetbrains.annotations.Nullable
    private org.hyperskill.musicplayer.ui.adapter.SongAdapter adapter;
    
    public MainPlayerControllerFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.hyperskill.musicplayer.ui.binder.MainPlayerControllerFragmentBinder getViewStateBinder() {
        return null;
    }
    
    public void setViewStateBinder(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.binder.MainPlayerControllerFragmentBinder p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel getViewModel() {
        return null;
    }
    
    private final org.hyperskill.musicplayer.ui.mapper.SongToUiMapper getSongToUiMapper() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final org.hyperskill.musicplayer.ui.adapter.SongAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable
    org.hyperskill.musicplayer.ui.adapter.SongAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.hyperskill.musicplayer.databinding.MainPlayerControllerFragmentBinding initializeBinding(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container) {
        return null;
    }
    
    @java.lang.Override
    public void bindViews(@org.jetbrains.annotations.NotNull
    android.view.View $this$bindViews) {
    }
    
    @java.lang.Override
    public void setupViews() {
    }
    
    private final void setControllerBtnPlayPause() {
    }
    
    private final void setControllerBtnStop() {
    }
    
    private final void setCurrentChangeOnTrack() {
    }
    
    private final void setControllerTvTotalTime(long value) {
    }
    
    private final void setSeekBar() {
    }
    
    private final void setObserverOnWorker() {
    }
    
    private final void updateSeekBarAndTime(long currentPosition) {
    }
    
    private final void setMaxDuration(long duration) {
    }
    
    @android.annotation.SuppressLint(value = {"DefaultLocale"})
    private final java.lang.String formatDurationInSeconds(int durationInSeconds) {
        return null;
    }
}