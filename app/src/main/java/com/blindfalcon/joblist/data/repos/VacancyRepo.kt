package com.blindfalcon.joblist.data.repos

import com.blindfalcon.joblist.data.mappers.VacancyMapper
import com.blindfalcon.joblist.data.remote.api.VacancyApi
import com.blindfalcon.joblist.data.repos.entity.Vacancy
import io.reactivex.Single

interface IVacancyRepo {
    fun getVacancyList(keyword: String): Single<List<Vacancy>>
    fun getVacancy(vacancyId: Int): Single<Vacancy>
}

class VacancyRepo(
    private val api: VacancyApi,
    private val mapper: VacancyMapper
) : IVacancyRepo {

    override fun getVacancyList(keyword: String): Single<List<Vacancy>> =
        api.getVacancyList(keyword)
            .map { it.vacancyList }
            .map { mapper.restToVacancyList(it) }

    override fun getVacancy(vacancyId: Int): Single<Vacancy> =
        api.getVacancy(vacancyId)
            .map { mapper.restToVacancy(it) }
}