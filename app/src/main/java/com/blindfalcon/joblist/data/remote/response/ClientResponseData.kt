package com.blindfalcon.joblist.data.remote.response

import com.blindfalcon.joblist.data.remote.api.CLIENT_ID
import com.blindfalcon.joblist.data.remote.api.CLIENT_LOGO
import com.blindfalcon.joblist.data.remote.api.CLIENT_TITLE
import com.google.gson.annotations.SerializedName

data class ClientResponseData(
    @SerializedName(CLIENT_ID) var clientId: Int,
    @SerializedName(CLIENT_TITLE) var clientTitle: String?,
    @SerializedName(CLIENT_LOGO) var logo: String?
)