package com.blindfalcon.joblist.presentation.screens.main.details

import com.blindfalcon.joblist.domain.SearchScreenInteractor
import com.blindfalcon.joblist.presentation.screens.main.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsScreenViewModel(private val interactor: SearchScreenInteractor) :
    BaseViewModel<DetailsScreenEvent>() {

    fun loadData(vacancyId: Int) {
        compositeDisposable.add(
            interactor.getVacancy(vacancyId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { screenState.postValue(DetailsScreenEvent.Loading) }
                .map { DetailsScreenEvent.LoadData(it) }
                .subscribe(screenState::postValue)
                { screenState.postValue(DetailsScreenEvent.Error) }
        )
    }

    fun onBackPressed() {
        screenState.postValue(DetailsScreenEvent.BackPressed)
    }
}