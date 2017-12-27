package com.example.computec.eltadreb.service.model.login

import com.example.computec.eltadreb.App
import com.example.computec.eltadreb.service.responed.ResponedLogin
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModelImpl : LoginModel {

    lateinit var listener: LoginModel.OnLoginFinishedListener

    override fun login(username: String, password: String, listener: LoginModel.OnLoginFinishedListener) {
        this.listener = listener

        val user = JsonObject()
        user.addProperty("username", username)
        user.addProperty("password", password)

        App.getService.loginService(user).enqueue(object : Callback<ResponedLogin> {
            override fun onResponse(call: Call<ResponedLogin>, response: Response<ResponedLogin>) =
                    when {
                        response.isSuccessful -> listener.onSuccess(response.body()!!.token!!)
                        response.code() == 401 -> listener.onCanceled()
                        else -> listener.onCanceled()
                    }

            override fun onFailure(call: Call<ResponedLogin>, t: Throwable) {
                listener.onCanceled()
            }
        })
    }

    override fun restPassword(email: String, listener: LoginModel.OnRestPasswordFinishedListener) {
        val emailObject = JsonObject()
        emailObject.addProperty("email", email)
//        App.getService.resetPassword(emailObject).enqueue(object : Callback<Void> {
//            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                if (response.isSuccessful) {
//                    listener.onSuccess()
//                } else if (response.code() == 404)
//                    listener.onCanceled()
//                else if (response.code() == 401)
//                    listener.onAccountStopped()
//            }
//
//            override fun onFailure(call: Call<Void>, t: Throwable) {
//                listener.onCanceled()
//            }
//        })
    }

}
