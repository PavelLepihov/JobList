package com.blindfalcon.joblist.di.modules

import com.blindfalcon.joblist.data.mappers.VacancyMapper
import com.blindfalcon.joblist.data.repos.VacancyRepo
import com.blindfalcon.joblist.presentation.screens.app.AppActivity
import org.koin.core.qualifier.named
import org.koin.dsl.module

val vacancyRepoModule = module {
    scope(named<AppActivity>()) {
        scoped { VacancyRepo(get(), get()) }
        scoped { VacancyMapper() }
    }
}