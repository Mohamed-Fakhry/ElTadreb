package com.example.computec.eltadreb.service.model.login

interface LoginModel {

    interface OnLoginFinishedListener {

        fun onCanceled()

        fun onSuccess(token: String)

        fun onAccountStopped()
    }

    interface OnRestPasswordFinishedListener {

        fun onCanceled()

        fun onSuccess()

        fun onAccountStopped()
    }

    fun login(username: String, password: String, listener: OnLoginFinishedListener)

    fun restPassword(email: String, listener: OnRestPasswordFinishedListener)
}
