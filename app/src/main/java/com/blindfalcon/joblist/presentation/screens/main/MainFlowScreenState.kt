package com.blindfalcon.joblist.presentation.screens.main

sealed class MainFlowScreenState {
    data class SearchScreen(
        val keyword: String,
        val shouldLoad: Boolean
    ) : MainFlowScreenState()

    data class DetailsScreen(
        val keyword: String,
        val vacancyId: Int
    ) : MainFlowScreenState()
}