package org.hyperskill.musicplayer.internals;

@org.robolectric.annotation.Implements(value = android.os.CountDownTimer.class)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0005J\b\u0010\u001c\u001a\u00020\u001bH\u0005J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0004J\n\u0010 \u001a\u0004\u0018\u00010\tH\u0005R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lorg/hyperskill/musicplayer/internals/CustomShadowCountDownTimer;", "", "()V", "<set-?>", "", "countDownInterval", "getCountDownInterval", "()J", "countDownTimer", "Landroid/os/CountDownTimer;", "getCountDownTimer", "()Landroid/os/CountDownTimer;", "setCountDownTimer", "(Landroid/os/CountDownTimer;)V", "millisInFuture", "getMillisInFuture", "millisUntilFinished", "getMillisUntilFinished", "setMillisUntilFinished", "(J)V", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "started", "", "__constructor__", "", "cancel", "hasStarted", "invokeFinish", "invokeTick", "start", "Companion", "Music_Player-task_debugUnitTest"})
public final class CustomShadowCountDownTimer {
    @org.jetbrains.annotations.Nullable()
    private static android.os.Handler handler;
    private boolean started = false;
    private long countDownInterval = 0L;
    private long millisInFuture = 0L;
    private long millisUntilFinished = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable runnable = null;
    @org.robolectric.annotation.RealObject()
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer countDownTimer;
    @org.jetbrains.annotations.NotNull()
    public static final org.hyperskill.musicplayer.internals.CustomShadowCountDownTimer.Companion Companion = null;
    
    public CustomShadowCountDownTimer() {
        super();
    }
    
    public final long getCountDownInterval() {
        return 0L;
    }
    
    public final long getMillisInFuture() {
        return 0L;
    }
    
    public final long getMillisUntilFinished() {
        return 0L;
    }
    
    public final void setMillisUntilFinished(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Runnable getRunnable() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.os.CountDownTimer getCountDownTimer() {
        return null;
    }
    
    public final void setCountDownTimer(@org.jetbrains.annotations.Nullable()
    android.os.CountDownTimer p0) {
    }
    
    @org.robolectric.annotation.Implementation()
    protected final void __constructor__(long millisInFuture, long countDownInterval) {
    }
    
    @org.robolectric.annotation.Implementation()
    @kotlin.jvm.Synchronized()
    @org.jetbrains.annotations.Nullable()
    protected final synchronized android.os.CountDownTimer start() {
        return null;
    }
    
    @org.robolectric.annotation.Implementation()
    protected final void cancel() {
    }
    
    public final void invokeTick(long millisUntilFinished) {
    }
    
    public final void invokeFinish() {
    }
    
    public final boolean hasStarted() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lorg/hyperskill/musicplayer/internals/CustomShadowCountDownTimer$Companion;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "Music_Player-task_debugUnitTest"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.os.Handler getHandler() {
            return null;
        }
        
        public final void setHandler(@org.jetbrains.annotations.Nullable()
        android.os.Handler p0) {
        }
    }
}