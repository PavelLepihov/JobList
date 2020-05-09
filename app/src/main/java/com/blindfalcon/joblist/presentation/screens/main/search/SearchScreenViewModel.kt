package com.blindfalcon.joblist.presentation.screens.main.search

import com.blindfalcon.joblist.domain.SearchScreenInteractor
import com.blindfalcon.joblist.presentation.screens.main.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchScreenViewModel(private val interactor: SearchScreenInteractor) :
    BaseViewModel<SearchScreenEvent>() {

    fun loadData(keyword: String) {
        compositeDisposable.add(
            interactor.getVacancyList(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { screenState.postValue(SearchScreenEvent.Loading) }
                .map { SearchScreenEvent.LoadData(it) }
                .subscribe(screenState::postValue)
                { screenState.postValue(SearchScreenEvent.Error) }
        )
    }

    fun onVacancyClick(vacancyId: Int) {
        screenState.postValue(SearchScreenEvent.VacancyClicked(vacancyId))
    }
}