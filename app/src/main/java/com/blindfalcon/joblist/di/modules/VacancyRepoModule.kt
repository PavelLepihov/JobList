package com.blindfalcon.joblist.di.modules

import com.blindfalcon.joblist.data.mappers.VacancyMapper
import com.blindfalcon.joblist.data.repos.VacancyRepo
import org.koin.dsl.module

val vacancyRepoModule = module {
    factory { VacancyRepo(get(), get()) }
    factory { VacancyMapper() }
}