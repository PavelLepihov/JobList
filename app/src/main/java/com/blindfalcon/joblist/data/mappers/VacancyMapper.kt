package com.blindfalcon.joblist.data.mappers

import com.blindfalcon.joblist.data.remote.response.ClientResponseData
import com.blindfalcon.joblist.data.remote.response.MetroResponseData
import com.blindfalcon.joblist.data.remote.response.VacancyResponseData
import com.blindfalcon.joblist.data.repos.entity.Client
import com.blindfalcon.joblist.data.repos.entity.Metro
import com.blindfalcon.joblist.data.repos.entity.Vacancy

interface IVacancyMapper {
    fun restToVacancyList(vacancyResponseDataList: List<VacancyResponseData>): List<Vacancy>
    fun restToVacancy(vacancyResponse: VacancyResponseData): Vacancy
}

class VacancyMapper : IVacancyMapper {
    override fun restToVacancyList(vacancyResponseDataList: List<VacancyResponseData>): List<Vacancy> =
        vacancyResponseDataList.map { restToVacancy(it) }

    override fun restToVacancy(vacancyResponse: VacancyResponseData): Vacancy =
        Vacancy(
            vacancyResponse.id,
            vacancyResponse.clientIdVac,
            vacancyResponse.profession,
            restToMetroList(vacancyResponse.metro),
            vacancyResponse.date,
            vacancyResponse.duties,
            vacancyResponse.conditions,
            vacancyResponse.requirements,
            restToClient(vacancyResponse.client),
            vacancyResponse.paymentFrom,
            vacancyResponse.paymentTo
        )

    private fun restToMetroList(metroResponse: List<MetroResponseData>): List<Metro> =
        metroResponse.map {
            Metro(
                it.metroId,
                it.metroTitle,
                it.lineId
            )
        }.toList()

    private fun restToClient(clientResponse: ClientResponseData?): Client? =
        clientResponse?.let {
            Client(
                it.clientId,
                it.clientTitle,
                it.logo
            )
        }
}