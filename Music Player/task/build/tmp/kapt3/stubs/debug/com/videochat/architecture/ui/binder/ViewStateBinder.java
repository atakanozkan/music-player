package com.videochat.architecture.ui.binder;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0000*\u00020\u00042\u00020\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u0006*\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/videochat/architecture/ui/binder/ViewStateBinder;", "VIEW_STATE", "", "VIEWS_PROVIDER", "Lcom/videochat/architecture/ui/binder/ViewsProvider;", "bind", "", "viewState", "(Ljava/lang/Object;)V", "bindState", "(Lcom/videochat/architecture/ui/binder/ViewsProvider;Ljava/lang/Object;)V", "Music_Player-task_debug"})
public abstract interface ViewStateBinder<VIEW_STATE extends java.lang.Object, VIEWS_PROVIDER extends com.videochat.architecture.ui.binder.ViewsProvider> {
    
    public abstract void bindState(@org.jetbrains.annotations.NotNull
    VIEWS_PROVIDER $this$bindState, @org.jetbrains.annotations.NotNull
    VIEW_STATE viewState);
    
    public abstract void bind(@org.jetbrains.annotations.NotNull
    VIEW_STATE viewState);
}