package com.blindfalcon.joblist.presentation.screens.main

sealed class MainFlowScreenState {
    object SearchScreen: MainFlowScreenState()
    data class DetailsScreen(val vacancyId: Int): MainFlowScreenState()
}