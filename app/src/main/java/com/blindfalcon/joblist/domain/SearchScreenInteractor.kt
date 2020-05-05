package com.blindfalcon.joblist.domain

import com.blindfalcon.joblist.data.repos.VacancyRepo
import com.blindfalcon.joblist.data.repos.entity.Vacancy
import io.reactivex.Single

interface ISearchScreenInteractor {
    fun getVacancyList(keyword: String): Single<List<Vacancy>>
    fun getVacancy(vacancyId: Int): Single<Vacancy>
}

class SearchScreenInteractor(private val repo: VacancyRepo) : ISearchScreenInteractor {
    override fun getVacancyList(keyword: String): Single<List<Vacancy>> =
        repo.getVacancyList(keyword)

    override fun getVacancy(vacancyId: Int): Single<Vacancy> =
        repo.getVacancy(vacancyId)
}