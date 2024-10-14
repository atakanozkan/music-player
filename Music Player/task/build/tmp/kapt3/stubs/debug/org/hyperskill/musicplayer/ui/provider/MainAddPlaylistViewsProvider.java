package org.hyperskill.musicplayer.ui.provider;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lorg/hyperskill/musicplayer/ui/provider/MainAddPlaylistViewsProvider;", "Lcom/videochat/architecture/ui/binder/ViewsProvider;", "addPlaylistBtnCancel", "Landroid/widget/Button;", "getAddPlaylistBtnCancel", "()Landroid/widget/Button;", "addPlaylistBtnOk", "getAddPlaylistBtnOk", "addPlaylistEtPlaylistName", "Landroid/widget/EditText;", "getAddPlaylistEtPlaylistName", "()Landroid/widget/EditText;", "Music_Player-task_debug"})
public abstract interface MainAddPlaylistViewsProvider extends com.videochat.architecture.ui.binder.ViewsProvider {
    
    @org.jetbrains.annotations.NotNull
    public abstract android.widget.EditText getAddPlaylistEtPlaylistName();
    
    @org.jetbrains.annotations.NotNull
    public abstract android.widget.Button getAddPlaylistBtnOk();
    
    @org.jetbrains.annotations.NotNull
    public abstract android.widget.Button getAddPlaylistBtnCancel();
}