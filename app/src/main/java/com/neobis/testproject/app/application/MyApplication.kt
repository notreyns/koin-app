package com.neobis.testproject.app.application

import android.app.Application
import com.neobis.testproject.koin.retrofitModule
import com.neobis.testproject.koin.viewModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(retrofitModule, viewModules))
            androidContext(this@MyApplication)
        }
    }
}