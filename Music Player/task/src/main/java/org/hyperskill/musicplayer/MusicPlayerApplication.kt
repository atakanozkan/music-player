package org.hyperskill.musicplayer

import android.app.Application
import org.hyperskill.musicplayer.di.appModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MusicPlayerApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MusicPlayerApplication)
            modules(appModule)
        }
    }
}