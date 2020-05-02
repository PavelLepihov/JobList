package com.blindfalcon.joblist.data.remote.api

import com.blindfalcon.joblist.data.remote.response.VacancyListResponse
import com.blindfalcon.joblist.data.remote.response.VacancyResponseData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface VacancyApi {
    @GET(GET_VACANCY_LIST)
    fun getVacancyList(@Query(KEYWORD) keyword: String): Single<VacancyListResponse>

    @GET(GET_VACANCY)
    fun getVacancy(@Path(ID_VACANCY) id: Int): Single<VacancyResponseData>
}