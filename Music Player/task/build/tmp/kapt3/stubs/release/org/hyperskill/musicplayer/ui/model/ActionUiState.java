package org.hyperskill.musicplayer.ui.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "", "()V", "ADD_PLAYLIST", "PLAY_MUSIC", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState$PLAY_MUSIC;", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState$ADD_PLAYLIST;", "Music_Player-task_release"})
public abstract class ActionUiState {
    
    private ActionUiState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lorg/hyperskill/musicplayer/ui/model/ActionUiState$PLAY_MUSIC;", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "()V", "Music_Player-task_release"})
    public static final class PLAY_MUSIC extends org.hyperskill.musicplayer.ui.model.ActionUiState {
        @org.jetbrains.annotations.NotNull
        public static final org.hyperskill.musicplayer.ui.model.ActionUiState.PLAY_MUSIC INSTANCE = null;
        
        private PLAY_MUSIC() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lorg/hyperskill/musicplayer/ui/model/ActionUiState$ADD_PLAYLIST;", "Lorg/hyperskill/musicplayer/ui/model/ActionUiState;", "()V", "Music_Player-task_release"})
    public static final class ADD_PLAYLIST extends org.hyperskill.musicplayer.ui.model.ActionUiState {
        @org.jetbrains.annotations.NotNull
        public static final org.hyperskill.musicplayer.ui.model.ActionUiState.ADD_PLAYLIST INSTANCE = null;
        
        private ADD_PLAYLIST() {
            super();
        }
    }
}