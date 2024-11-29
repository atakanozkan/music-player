package com.videochat.architecture.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J\u0016\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u00a6@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/videochat/architecture/domain/usecase/UseCase;", "INPUT", "OUTPUT", "", "execute", "input", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Music_Player-task_debug"})
public abstract interface UseCase<INPUT extends java.lang.Object, OUTPUT extends java.lang.Object> {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object execute(INPUT input, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super OUTPUT> $completion);
}