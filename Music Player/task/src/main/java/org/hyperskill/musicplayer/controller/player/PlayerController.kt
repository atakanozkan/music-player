package org.hyperskill.musicplayer.controller.player

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import org.hyperskill.musicplayer.ui.listener.PlaybackEventListener
import org.hyperskill.musicplayer.ui.handler.PlaybackListenerHandler

class PlayerController(
    private val appContext: Context,
    private val playbackEventListener: PlaybackListenerHandler
) : Player, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, PlaybackEventListener by playbackEventListener.getEventHandler(){

    private var mediaPlayer: MediaPlayer? = null

    private var playerWorker: PlayerWorker = PlayerWorker.PeriodicHandler(100,::workerPeriodicJob)

    private var currentPlayingUri: Uri? = null

    private var isPlaying: Boolean = false
    private var isInitialized: Boolean = false
    private var isStopped: Boolean = false

    val position: Long
        get() = mediaPlayer?.currentPosition?.toLong() ?: 0

    fun workerPeriodicJob(){
        mediaPlayer?.let {
            onPlaybackContinue(position)
        }
    }

    override fun prepareMediaPlayer(uri: Uri): MediaPlayer? {
        mediaPlayer = MediaPlayer.create(appContext, uri).apply {
            setOnCompletionListener(this@PlayerController)
            setOnErrorListener(this@PlayerController)
        }
        isInitialized = true
        return mediaPlayer
    }

    override fun seek(ms: Int) {
        mediaPlayer?.seekTo(ms)
    }

    override fun playSong(uri: Uri): MediaPlayer?{
        dispose()
        prepareMediaPlayer(uri)
        playerWorker = playerWorker.newWorker(::workerPeriodicJob)
        currentPlayingUri.let {
            if(it == uri || currentPlayingUri == null){
                val startValue = onPlaybackStart()
                seek(startValue)
            }
            else{
                seek(0)
            }
        }
        currentPlayingUri = uri
        return mediaPlayer
    }

    override fun startPlaying() {
        if (isInitialized && mediaPlayer != null) {
            playerWorker.interrupt()
            playerWorker.start()
            mediaPlayer?.start()
            isPlaying = true
        }
    }

    override fun pauseMusic() {
        if (isPlaying) {
            mediaPlayer?.pause()
            playerWorker.interrupt()

            isPlaying = false
            isStopped = true
            onPlaybackPause(position)
        }
    }

    override fun dispose() {
        playerWorker.cancel()
        isInitialized = false
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
    override fun stopMusic() {
        if (isPlaying || isStopped) {
            isPlaying = false
            isStopped = false
            seek(0)
            mediaPlayer?.stop()
            playerWorker.interrupt()
            onPlaybackStop(position)
        }
    }

    override fun onCompletion(mp: MediaPlayer?) {
        isPlaying = false
        isStopped = false
        playerWorker.interrupt()
        seek(0)
        mediaPlayer?.stop()
        onPlaybackComplete()
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        stopMusic()
        return true
    }
}