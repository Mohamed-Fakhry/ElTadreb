package com.example.computec.eltadreb.data.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiError(private val errorCode: Int,
               @Expose
               @SerializedName("status_code")
               private val statusCode: String?,
               @Expose
               @SerializedName("message")
               val message: String?) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val apiError = other as ApiError?

        if (errorCode != apiError!!.errorCode) return false
        if (if (statusCode != null)
            statusCode != apiError.statusCode
        else
            apiError.statusCode != null)
            return false
        return if (message != null) message == apiError.message else apiError.message == null

    }

    override fun hashCode(): Int {
        var result = errorCode
        result = 31 * result + (statusCode?.hashCode() ?: 0)
        result = 31 * result + (message?.hashCode() ?: 0)
        return result
    }
}