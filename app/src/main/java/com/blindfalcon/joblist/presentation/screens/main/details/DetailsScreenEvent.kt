package com.blindfalcon.joblist.presentation.screens.main.details

import com.blindfalcon.joblist.data.repos.entity.Vacancy

sealed class DetailsScreenEvent {
    object Loading: DetailsScreenEvent()
    object Error: DetailsScreenEvent()
    data class LoadData(val data: Vacancy): DetailsScreenEvent()
    object BackPressed: DetailsScreenEvent()
}