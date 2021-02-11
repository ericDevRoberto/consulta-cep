package com.project.consultcep

import android.app.Application
import com.project.consultcep.di.DbModule
import com.project.consultcep.di.ViewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApplication)

            modules(
                listOf(
                    ViewModelModules,
                    DbModule,
                )
            )
        }
    }
}