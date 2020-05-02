package com.blindfalcon.joblist.presentation.screens.main.search

import com.blindfalcon.joblist.data.repos.entity.Vacancy

sealed class SearchScreenEvent {
    object Loading: SearchScreenEvent()
    object Error: SearchScreenEvent()
    data class LoadData(val data: List<Vacancy>): SearchScreenEvent()
    data class VacancyClicked(val vacancyId: Int): SearchScreenEvent()
}