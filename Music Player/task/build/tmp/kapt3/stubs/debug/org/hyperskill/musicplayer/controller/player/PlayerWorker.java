package org.hyperskill.musicplayer.controller.player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0016\u0010\u0005\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lorg/hyperskill/musicplayer/controller/player/PlayerWorker;", "", "cancel", "", "interrupt", "newWorker", "work", "Lkotlin/Function0;", "start", "PeriodicHandler", "Music_Player-task_debug"})
public abstract interface PlayerWorker {
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.hyperskill.musicplayer.controller.player.PlayerWorker newWorker(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> work);
    
    public abstract void interrupt();
    
    public abstract void start();
    
    public abstract void cancel();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0016\u0010\u0011\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lorg/hyperskill/musicplayer/controller/player/PlayerWorker$PeriodicHandler;", "Lorg/hyperskill/musicplayer/controller/player/PlayerWorker;", "period", "", "work", "Lkotlin/Function0;", "", "(JLkotlin/jvm/functions/Function0;)V", "handler", "Landroid/os/Handler;", "interrupted", "", "isCancelled", "workCycle", "Ljava/lang/Runnable;", "cancel", "interrupt", "newWorker", "start", "Music_Player-task_debug"})
    public static final class PeriodicHandler implements org.hyperskill.musicplayer.controller.player.PlayerWorker {
        private final long period = 0L;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function0<kotlin.Unit> work = null;
        @kotlin.jvm.Volatile()
        private volatile boolean interrupted = false;
        private boolean isCancelled = false;
        @org.jetbrains.annotations.NotNull()
        private final android.os.Handler handler = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.Runnable workCycle = null;
        
        public PeriodicHandler(long period, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> work) {
            super();
        }
        
        @java.lang.Override()
        public void interrupt() {
        }
        
        @java.lang.Override()
        public void start() {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public org.hyperskill.musicplayer.controller.player.PlayerWorker newWorker(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> work) {
            return null;
        }
        
        @java.lang.Override()
        public void cancel() {
        }
    }
}