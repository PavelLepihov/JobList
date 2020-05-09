package com.blindfalcon.joblist.di.modules

import com.blindfalcon.joblist.presentation.screens.main.details.DetailsFragment
import com.blindfalcon.joblist.presentation.screens.main.search.SearchFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val fragmentModule = module {
    fragment { (keyword: String, vacancyId: Int) -> DetailsFragment(keyword, vacancyId) }
    fragment { (keyword: String, shouldLoad: Boolean) -> SearchFragment(keyword, shouldLoad) }
}