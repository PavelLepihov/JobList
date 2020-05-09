package com.blindfalcon.joblist.presentation.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel<T> : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    val screenState = MutableLiveData<T>()

    override fun onCleared() {
        compositeDisposable.clear()
    }
}