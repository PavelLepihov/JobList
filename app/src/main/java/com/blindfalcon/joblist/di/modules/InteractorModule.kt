package com.blindfalcon.joblist.di.modules

import com.blindfalcon.joblist.domain.SearchScreenInteractor
import org.koin.dsl.module

val interactorModule = module {
    factory { SearchScreenInteractor(get()) }
}