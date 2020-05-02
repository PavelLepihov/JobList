package com.blindfalcon.joblist.domain

import com.blindfalcon.joblist.data.repos.IVacancyRepo
import com.blindfalcon.joblist.data.repos.entity.Vacancy
import io.reactivex.Single

interface ISearchScreenInteractor {
    fun getVacancyList(keyword: String): Single<List<Vacancy>>
    fun getVacancy(vacancyId: Int): Single<Vacancy>
}

class SearchScreenInteractor(private val repo: IVacancyRepo) : ISearchScreenInteractor {
    override fun getVacancyList(keyword: String): Single<List<Vacancy>> =
        repo.getVacancyList(keyword)

    override fun getVacancy(vacancyId: Int): Single<Vacancy> =
        repo.getVacancy(vacancyId)
}