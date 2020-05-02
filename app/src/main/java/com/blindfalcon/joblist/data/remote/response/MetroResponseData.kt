package com.blindfalcon.joblist.data.remote.response

import com.blindfalcon.joblist.data.remote.api.ID
import com.blindfalcon.joblist.data.remote.api.ID_METRO_LINE
import com.blindfalcon.joblist.data.remote.api.TITLE
import com.google.gson.annotations.SerializedName

class MetroResponseData(
    @SerializedName(ID) var metroId: Int,
    @SerializedName(TITLE) var metroTitle: String,
    @SerializedName(ID_METRO_LINE) var lineId: Int
)