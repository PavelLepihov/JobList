package com.blindfalcon.joblist.data.remote.response

import com.blindfalcon.joblist.data.remote.api.*
import com.google.gson.annotations.SerializedName

data class VacancyResponseData(
    @SerializedName(ID) var id: Int,
    @SerializedName(ID_CLIENT) var clientIdVac: Int,
    @SerializedName(PROFESSION) var profession: String,
    @SerializedName(METRO) var metro: List<MetroResponseData> = listOf(),
    @SerializedName(DATE_PUBLISHED) var date: Int,
    @SerializedName(WORK) var duties: String?,
    @SerializedName(COMPENSATION) var conditions: String?,
    @SerializedName(CANDIDAT) var requirements: String?,
    @SerializedName(CLIENT) var client: ClientResponseData?,
    @SerializedName(PAYMENT_FROM) var paymentFrom: Int,
    @SerializedName(PAYMENT_TO) var paymentTo: Int
)