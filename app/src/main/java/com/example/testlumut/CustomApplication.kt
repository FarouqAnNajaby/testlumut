package com.example.testlumut

import android.app.Application
import com.example.repository.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CustomApplication)
            modules(listOf(viewModelModule, repositoryModule))
        }
    }
}
