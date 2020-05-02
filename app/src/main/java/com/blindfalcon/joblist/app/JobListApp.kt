package com.blindfalcon.joblist.app

import android.app.Application
import com.blindfalcon.joblist.di.modules.apiModule
import com.blindfalcon.joblist.di.modules.networkModule
import com.blindfalcon.joblist.di.modules.vacancyRepoModule
import com.blindfalcon.joblist.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JobListApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@JobListApp)
            modules(
                listOf(
                    apiModule,
                    networkModule,
                    vacancyRepoModule,
                    viewModelModule
                )
            )
        }
    }
}