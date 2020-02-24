package ru.taptm.videosampleproject.ui.main.common

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.taptm.videosampleproject.ui.main.di.networkModule
import ru.taptm.videosampleproject.ui.main.di.repositoryModule
import ru.taptm.videosampleproject.ui.main.di.viewModelModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(repositoryModule, viewModelModule, networkModule))
        }
    }
}