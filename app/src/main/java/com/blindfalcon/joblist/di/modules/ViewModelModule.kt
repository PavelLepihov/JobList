package com.blindfalcon.joblist.di.modules

import com.blindfalcon.joblist.presentation.screens.app.AppActivity
import com.blindfalcon.joblist.presentation.screens.app.AppActivityViewModel
import com.blindfalcon.joblist.presentation.screens.main.MainFlowViewModel
import com.blindfalcon.joblist.presentation.screens.main.details.DetailsFragment
import com.blindfalcon.joblist.presentation.screens.main.details.DetailsScreenViewModel
import com.blindfalcon.joblist.presentation.screens.main.search.SearchFragment
import com.blindfalcon.joblist.presentation.screens.main.search.SearchScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    scope<AppActivity> {
        viewModel { AppActivityViewModel() }
    }

    viewModel { MainFlowViewModel() }

    scope(named<SearchFragment>()) {
        viewModel(named<SearchFragment>()) { SearchScreenViewModel(get()) }
    }

    scope(named<DetailsFragment>()) {
        viewModel(named<DetailsFragment>()) { DetailsScreenViewModel(get()) }
    }
}