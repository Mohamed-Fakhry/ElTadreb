package com.example.computec.eltadreb.service.responed

import com.google.gson.annotations.SerializedName

class ResponedLogin {
    @SerializedName("accessToken")
    internal var token: String? = null
}
