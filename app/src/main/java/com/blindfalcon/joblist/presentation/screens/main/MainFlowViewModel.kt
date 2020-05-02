package com.blindfalcon.joblist.presentation.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFlowViewModel : ViewModel() {

    val screenState = MutableLiveData<MainFlowScreenState>()

    fun navigateToScreen(screen: MainFlowScreenState) {
        screenState.postValue(screen)
    }
}