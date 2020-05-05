package com.blindfalcon.joblist.presentation.screens.main.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blindfalcon.joblist.domain.SearchScreenInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchScreenViewModel(private val interactor: SearchScreenInteractor) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val screenState = MutableLiveData<SearchScreenEvent>()

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

    override fun onCleared() {
        compositeDisposable.clear()
    }
}