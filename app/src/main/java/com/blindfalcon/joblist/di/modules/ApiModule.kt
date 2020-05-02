package com.blindfalcon.joblist.di.modules

import com.blindfalcon.joblist.data.remote.api.VacancyApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(VacancyApi::class.java) }
}