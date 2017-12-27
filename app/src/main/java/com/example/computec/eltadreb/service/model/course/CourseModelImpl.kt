package com.example.computec.eltadreb.service.model.course

import com.example.computec.eltadreb.App
import com.example.computec.eltadreb.model.Course
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CourseModelImpl : CourseModel {

    override fun getCourse(id: Int, listener: CourseModel.OnGetCourseListener) {
        App.getService.getCourse(id).enqueue(object : Callback<Course> {

            override fun onResponse(call: Call<Course>?, response: Response<Course>?) =
                    when {
                        response!!.isSuccessful -> listener.onSuccess(response.body()!!)
                        response.code() == 401 -> listener.onCanceled()
                        else -> listener.onCanceled()
                    }

            override fun onFailure(call: Call<Course>?, t: Throwable?) {
                listener.onCanceled()
            }
        })
    }
}