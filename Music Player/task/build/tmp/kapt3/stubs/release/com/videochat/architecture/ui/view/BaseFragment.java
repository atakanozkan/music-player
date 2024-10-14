package com.videochat.architecture.ui.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u00072\u00020\u0004B\u0007\b\u0016\u00a2\u0006\u0002\u0010\bB\u0011\b\u0016\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001fJ\u001f\u0010 \u001a\u00028\u00022\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H&\u00a2\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u001dH\u0002J&\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J;\u0010,\u001a\u0004\u0018\u00010\u00122\'\u0010-\u001a#\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d00\u0012\u0006\u0012\u0004\u0018\u00010\u00020.\u00a2\u0006\u0002\b1H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J\u0014\u00103\u001a\u00020\u001d2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d05J\b\u00106\u001a\u00020\u001dH&J\u000e\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209J\f\u0010:\u001a\u00020\u001d*\u00020(H&R\u0012\u0010\f\u001a\u0004\u0018\u00018\u0002X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u00028\u00028DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/videochat/architecture/ui/view/BaseFragment;", "VIEW_STATE", "", "VIEWS_PROVIDER", "Lcom/videochat/architecture/ui/binder/ViewsProvider;", "BINDING", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "layoutResourceId", "", "(I)V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "destinationJob", "Lkotlinx/coroutines/Job;", "uiStateJob", "viewModel", "Lcom/videochat/architecture/presentation/viewmodel/BaseViewModel;", "getViewModel", "()Lcom/videochat/architecture/presentation/viewmodel/BaseViewModel;", "viewStateBinder", "Lcom/videochat/architecture/ui/binder/ViewStateBinder;", "getViewStateBinder", "()Lcom/videochat/architecture/ui/binder/ViewStateBinder;", "applyViewState", "", "viewState", "(Ljava/lang/Object;)V", "initializeBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "observeViewModel", "onCreateView", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "performOnStartedLifecycleEvent", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "setupBackAction", "action", "Lkotlin/Function0;", "setupViews", "showToast", "message", "", "bindViews", "Music_Player-task_release"})
public abstract class BaseFragment<VIEW_STATE extends java.lang.Object, VIEWS_PROVIDER extends com.videochat.architecture.ui.binder.ViewsProvider, BINDING extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment implements com.videochat.architecture.ui.binder.ViewsProvider {
    private BINDING _binding;
    private kotlinx.coroutines.Job uiStateJob;
    private kotlinx.coroutines.Job destinationJob;
    
    public BaseFragment() {
        super();
    }
    
    public BaseFragment(@androidx.annotation.LayoutRes
    int layoutResourceId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.videochat.architecture.presentation.viewmodel.BaseViewModel<VIEW_STATE> getViewModel();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.videochat.architecture.ui.binder.ViewStateBinder<VIEW_STATE, VIEWS_PROVIDER> getViewStateBinder();
    
    @org.jetbrains.annotations.NotNull
    protected final BINDING getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract BINDING initializeBinding(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container);
    
    public abstract void bindViews(@org.jetbrains.annotations.NotNull
    android.view.View $this$bindViews);
    
    public abstract void setupViews();
    
    private final void observeViewModel() {
    }
    
    private final kotlinx.coroutines.Job performOnStartedLifecycleEvent(kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block) {
        return null;
    }
    
    public final void applyViewState(@org.jetbrains.annotations.NotNull
    VIEW_STATE viewState) {
    }
    
    public final void showToast(@org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    public final void setupBackAction(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> action) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}