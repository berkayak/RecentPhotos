package com.berkayak.myrecentphotos.core

import android.app.Application
import com.berkayak.myrecentphotos.core.di.networkModule
import com.berkayak.myrecentphotos.core.di.repositoryModule
import com.berkayak.myrecentphotos.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyRecentPhotoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyRecentPhotoApp)
            modules(networkModule, repositoryModule, viewModelModule)
        }
    }
}