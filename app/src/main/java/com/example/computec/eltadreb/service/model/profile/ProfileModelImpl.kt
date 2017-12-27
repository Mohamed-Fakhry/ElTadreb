package com.example.computec.eltadreb.service.model.profile

import com.example.computec.eltadreb.App
import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.model.Student
import com.example.computec.eltadreb.service.model.comment.CommentModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileModelImpl : ProfileModel {

    override fun getProfile(listener: ProfileModel.OnGetProfileListener) {
        App.getService.getProfile().enqueue(object : Callback<Student> {

            override fun onResponse(call: Call<Student>?, response: Response<Student>?) =
                    when {
                        response!!.isSuccessful -> listener.onSuccess(response.body()!!)
                        response.code() == 401 -> listener.onCanceled()
                        else -> listener.onCanceled()
                    }

            override fun onFailure(call: Call<Student>?, t: Throwable?) {
                listener.onCanceled()
            }
        })
    }
}