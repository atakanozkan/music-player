package com.videochat.architecture.presentation.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u0007H\u0004J\b\u0010\u0018\u001a\u00020\u0017H\u0004J\u0015\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00028\u0000H\u0004\u00a2\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/videochat/architecture/presentation/viewmodel/BaseViewModel;", "VIEW_STATE", "Landroidx/lifecycle/ViewModel;", "initialViewState", "(Ljava/lang/Object;)V", "_destination", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/videochat/architecture/presentation/destination/BaseDestination;", "get_destination", "()Lkotlinx/coroutines/flow/SharedFlow;", "_uiState", "Lkotlinx/coroutines/flow/StateFlow;", "get_uiState", "()Lkotlinx/coroutines/flow/StateFlow;", "destination", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getDestination", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "navigate", "", "navigateBack", "updateViewState", "newState", "Music_Player-task_release"})
public abstract class BaseViewModel<VIEW_STATE extends java.lang.Object> extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<VIEW_STATE> uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<VIEW_STATE> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.videochat.architecture.presentation.destination.BaseDestination> destination = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<com.videochat.architecture.presentation.destination.BaseDestination> _destination = null;
    
    public BaseViewModel(VIEW_STATE initialViewState) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<VIEW_STATE> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<VIEW_STATE> get_uiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableSharedFlow<com.videochat.architecture.presentation.destination.BaseDestination> getDestination() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<com.videochat.architecture.presentation.destination.BaseDestination> get_destination() {
        return null;
    }
    
    protected final void updateViewState(VIEW_STATE newState) {
    }
    
    protected final void navigate(@org.jetbrains.annotations.NotNull
    com.videochat.architecture.presentation.destination.BaseDestination destination) {
    }
    
    protected final void navigateBack() {
    }
}