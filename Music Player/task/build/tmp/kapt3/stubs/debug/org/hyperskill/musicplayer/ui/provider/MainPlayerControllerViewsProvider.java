package org.hyperskill.musicplayer.ui.provider;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lorg/hyperskill/musicplayer/ui/provider/MainPlayerControllerViewsProvider;", "Lcom/videochat/architecture/ui/binder/ViewsProvider;", "controllerBtnPlayPause", "Landroid/widget/Button;", "getControllerBtnPlayPause", "()Landroid/widget/Button;", "controllerBtnStop", "getControllerBtnStop", "controllerSeekBar", "Landroid/widget/SeekBar;", "getControllerSeekBar", "()Landroid/widget/SeekBar;", "controllerTvCurrentTime", "Landroid/widget/TextView;", "getControllerTvCurrentTime", "()Landroid/widget/TextView;", "controllerTvTotalTime", "getControllerTvTotalTime", "Music_Player-task_debug"})
public abstract interface MainPlayerControllerViewsProvider extends com.videochat.architecture.ui.binder.ViewsProvider {
    
    @org.jetbrains.annotations.NotNull
    public abstract android.widget.TextView getControllerTvCurrentTime();
    
    @org.jetbrains.annotations.NotNull
    public abstract android.widget.TextView getControllerTvTotalTime();
    
    @org.jetbrains.annotations.NotNull
    public abstract android.widget.SeekBar getControllerSeekBar();
    
    @org.jetbrains.annotations.NotNull
    public abstract android.widget.Button getControllerBtnPlayPause();
    
    @org.jetbrains.annotations.NotNull
    public abstract android.widget.Button getControllerBtnStop();
}