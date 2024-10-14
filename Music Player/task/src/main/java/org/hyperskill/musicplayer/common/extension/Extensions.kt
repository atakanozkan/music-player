package org.hyperskill.musicplayer.common.extension

import android.annotation.SuppressLint

@SuppressLint("DefaultLocale")
fun formatDuration(durationInSeconds: Long): String {
    val duration = durationInSeconds / 1000
    val minutes = duration / 60
    val seconds = duration % 60
    return String.format("%02d:%02d", minutes, seconds)
}