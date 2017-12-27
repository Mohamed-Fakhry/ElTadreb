package com.example.computec.eltadreb.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiError(private val errorCode: Int,
                    @Expose
                    @SerializedName("status_code")
                    private val statusCode: String?,
                    @Expose
                    @SerializedName("message")
                    val message: String?)