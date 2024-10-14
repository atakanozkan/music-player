package org.hyperskill.musicplayer.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001eB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\f2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nJ\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0016\u0010\u001c\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter$SongViewHolder;", "songs", "", "Lorg/hyperskill/musicplayer/ui/model/SongUiModel;", "currentTrack", "Lorg/hyperskill/musicplayer/ui/model/SongTrackUiModel;", "(Ljava/util/List;Lorg/hyperskill/musicplayer/ui/model/SongTrackUiModel;)V", "songClickListener", "Lorg/hyperskill/musicplayer/domain/event/SongClickListener;", "changeCurrentTrackMode", "", "mode", "Lorg/hyperskill/musicplayer/ui/model/SongPlayMode;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "listener", "setCurrentTrack", "song", "setSongs", "songsReceived", "SongViewHolder", "Music_Player-task_release"})
public final class SongAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<org.hyperskill.musicplayer.ui.adapter.SongAdapter.SongViewHolder> {
    private java.util.List<org.hyperskill.musicplayer.ui.model.SongUiModel> songs;
    private org.hyperskill.musicplayer.ui.model.SongTrackUiModel currentTrack;
    private org.hyperskill.musicplayer.domain.event.SongClickListener songClickListener;
    
    public SongAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<org.hyperskill.musicplayer.ui.model.SongUiModel> songs, @org.jetbrains.annotations.Nullable
    org.hyperskill.musicplayer.ui.model.SongTrackUiModel currentTrack) {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setSongs(@org.jetbrains.annotations.NotNull
    java.util.List<org.hyperskill.musicplayer.ui.model.SongUiModel> songsReceived) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setCurrentTrack(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.model.SongUiModel song, @org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.model.SongPlayMode mode) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void changeCurrentTrackMode(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.model.SongPlayMode mode) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.hyperskill.musicplayer.ui.adapter.SongAdapter.SongViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.ui.adapter.SongAdapter.SongViewHolder holder, int position) {
    }
    
    public final void setClickListener(@org.jetbrains.annotations.NotNull
    org.hyperskill.musicplayer.domain.event.SongClickListener listener) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter$SongViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lorg/hyperskill/musicplayer/ui/adapter/SongAdapter;Landroid/view/View;)V", "btnPlayPause", "Landroid/widget/ImageButton;", "tvArtist", "Landroid/widget/TextView;", "tvDuration", "tvTitle", "bind", "", "song", "Lorg/hyperskill/musicplayer/ui/model/SongUiModel;", "Music_Player-task_release"})
    public final class SongViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.ImageButton btnPlayPause = null;
        private final android.widget.TextView tvArtist = null;
        private final android.widget.TextView tvTitle = null;
        private final android.widget.TextView tvDuration = null;
        
        public SongViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
        public final void bind(@org.jetbrains.annotations.NotNull
        org.hyperskill.musicplayer.ui.model.SongUiModel song) {
        }
    }
}