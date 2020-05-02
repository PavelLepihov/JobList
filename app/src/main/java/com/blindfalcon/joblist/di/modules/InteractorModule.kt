package com.blindfalcon.joblist.di.modules

import com.blindfalcon.joblist.domain.SearchScreenInteractor
import com.blindfalcon.joblist.presentation.screens.main.search.SearchFragment
import org.koin.core.qualifier.named
import org.koin.dsl.module

val interactorModule = module {
    scope(named<SearchFragment>()) {
        factory { SearchScreenInteractor(get()) }
    }
}