package com.blindfalcon.joblist.data.remote.response

import com.blindfalcon.joblist.data.remote.api.MORE
import com.blindfalcon.joblist.data.remote.api.OBJECTS
import com.blindfalcon.joblist.data.remote.api.TOTAL
import com.google.gson.annotations.SerializedName

data class VacancyListResponse(
    @SerializedName(OBJECTS) val vacancyList: List<VacancyResponseData>,
    @SerializedName(TOTAL) val total: Int?,
    @SerializedName(MORE) val hasMore: Boolean?
)