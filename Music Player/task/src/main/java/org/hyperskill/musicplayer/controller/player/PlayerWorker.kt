package org.hyperskill.musicplayer.controller.player

import android.os.Handler
import android.os.Looper

interface PlayerWorker {
    fun newWorker(work: () -> Unit): PlayerWorker
    fun interrupt()
    fun start()
    fun cancel()

    class PeriodicHandler(private val period: Long, private val work: () -> Unit = {}) :
        PlayerWorker {
        @Volatile
        private var interrupted = false
        private var isCancelled = false
        private val handler = Handler(Looper.getMainLooper())
        private val workCycle = object : Runnable {
            override fun run() {
                if (interrupted.not() && isCancelled.not()) {
                    work()
                    handler.postDelayed(this, period)
                }
            }
        }

        override fun interrupt() {
            interrupted = true
            handler.removeCallbacks(workCycle)
        }

        override fun start() {
            if (isCancelled) return
            work()
            interrupted = false
            handler.post(workCycle)
        }

        override fun newWorker(work: () -> Unit): PlayerWorker {
            isCancelled = false
            return PeriodicHandler(period, work)
        }

        override fun cancel() {
            if (!interrupted){
                isCancelled = true
                interrupt()
            }
        }
    }
}
