package org.hyperskill.musicplayer.ui.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\bJ\u0016\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter$SongSelectorViewHolder;", "songSelectors", "", "Lorg/hyperskill/musicplayer/ui/model/SongSelectorUiModel;", "(Ljava/util/List;)V", "songSelectListener", "Lorg/hyperskill/musicplayer/ui/listener/SongSelectListener;", "getAdapterList", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSongSelectListener", "listener", "setSongSelectors", "songsReceived", "SongSelectorViewHolder", "Music_Player-task_debug"})
public final class SongSelectorAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter.SongSelectorViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<org.hyperskill.musicplayer.ui.model.SongSelectorUiModel> songSelectors;
    @org.jetbrains.annotations.Nullable()
    private org.hyperskill.musicplayer.ui.listener.SongSelectListener songSelectListener;
    
    public SongSelectorAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<org.hyperskill.musicplayer.ui.model.SongSelectorUiModel> songSelectors) {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setSongSelectors(@org.jetbrains.annotations.NotNull()
    java.util.List<org.hyperskill.musicplayer.ui.model.SongSelectorUiModel> songsReceived) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter.SongSelectorViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    org.hyperskill.musicplayer.ui.adapter.SongSelectorAdapter.SongSelectorViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setSongSelectListener(@org.jetbrains.annotations.NotNull()
    org.hyperskill.musicplayer.ui.listener.SongSelectListener listener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.hyperskill.musicplayer.ui.model.SongSelectorUiModel> getAdapterList() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter$SongSelectorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lorg/hyperskill/musicplayer/ui/adapter/SongSelectorAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "tvArtist", "Landroid/widget/TextView;", "tvDuration", "tvTitle", "bind", "", "songSelector", "Lorg/hyperskill/musicplayer/ui/model/SongSelectorUiModel;", "Music_Player-task_debug"})
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    public final class SongSelectorViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.CheckBox checkBox = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvArtist = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvTitle = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvDuration = null;
        
        public SongSelectorViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        org.hyperskill.musicplayer.ui.model.SongSelectorUiModel songSelector) {
        }
    }
}