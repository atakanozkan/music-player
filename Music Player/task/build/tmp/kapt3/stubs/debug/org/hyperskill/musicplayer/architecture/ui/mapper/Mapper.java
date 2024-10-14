package org.hyperskill.musicplayer.architecture.ui.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016\u00a8\u0006\n"}, d2 = {"Lorg/hyperskill/musicplayer/architecture/ui/mapper/Mapper;", "INPUT", "OUTPUT", "", "map", "input", "(Ljava/lang/Object;)Ljava/lang/Object;", "mapList", "", "inputList", "Music_Player-task_debug"})
public abstract interface Mapper<INPUT extends java.lang.Object, OUTPUT extends java.lang.Object> {
    
    public abstract OUTPUT map(INPUT input);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<OUTPUT> mapList(@org.jetbrains.annotations.NotNull
    java.util.List<? extends INPUT> inputList);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull
        public static <INPUT extends java.lang.Object, OUTPUT extends java.lang.Object>java.util.List<OUTPUT> mapList(@org.jetbrains.annotations.NotNull
        org.hyperskill.musicplayer.architecture.ui.mapper.Mapper<? super INPUT, ? extends OUTPUT> $this, @org.jetbrains.annotations.NotNull
        java.util.List<? extends INPUT> inputList) {
            return null;
        }
    }
}