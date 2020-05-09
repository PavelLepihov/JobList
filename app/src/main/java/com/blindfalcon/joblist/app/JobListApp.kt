package com.blindfalcon.joblist.app

import android.app.Application
import com.blindfalcon.joblist.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class JobListApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@JobListApp)
            androidLogger(Level.DEBUG)
            fragmentFactory()
            modules(
                listOf(
                    apiModule,
                    networkModule,
                    vacancyRepoModule,
                    viewModelModule,
                    interactorModule,
                    fragmentModule
                )
            )
        }
    }
}