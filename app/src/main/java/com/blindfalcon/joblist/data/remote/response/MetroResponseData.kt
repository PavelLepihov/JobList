package com.blindfalcon.joblist.data.remote.response

import com.blindfalcon.joblist.data.remote.api.ID_METRO_LINE
import com.blindfalcon.joblist.data.remote.api.METRO_ID
import com.blindfalcon.joblist.data.remote.api.METRO_TITLE
import com.google.gson.annotations.SerializedName

class MetroResponseData(
    @SerializedName(METRO_ID) var metroId: Int,
    @SerializedName(METRO_TITLE) var metroTitle: String,
    @SerializedName(ID_METRO_LINE) var lineId: Int
)