package com.blindfalcon.joblist.presentation.screens.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppActivityViewModel : ViewModel() {

    val screenState = MutableLiveData<AppActivityScreenState>()

    enum class AppScreens {
        MAIN_FLOW_SCREEN
    }

    fun navigateToScreen(screen: AppScreens) {
        when (screen) {
            AppScreens.MAIN_FLOW_SCREEN -> screenState.postValue(AppActivityScreenState.MainFlowScreen)
        }
    }
}