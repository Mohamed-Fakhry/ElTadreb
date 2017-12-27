package com.example.computec.eltadreb.service

import com.example.computec.eltadreb.model.*
import com.example.computec.eltadreb.service.responed.ResponedLogin
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface Service {

    @POST("login")
    fun loginService(@Body user: JsonObject): Call<ResponedLogin>

    @GET("profile")
    fun getProfile(): Call<Student>

    @GET("courses?groupBy=category")
    fun getCoursesSortBYCategory(): Call<MutableList<Category>>

    @GET("courses/{id}")
    fun getCourse(@Path("id") id: Int): Call<Course>

    @GET("videos/{id}")
    fun getVideo(@Path("id") id: Int): Call<Video>

    @GET("comments/{id}")
    fun getComment(@Path("id") id: Int): Call<Comment>

    @POST("videos/{id}/comments")
    fun postComment(@Path("id") id: Int, @Body comment: JsonObject): Call<Comment>

    @GET("videos/{id}/comments")
    fun getComments(@Path("id") id: Int): Call<MutableList<Comment>>

    @POST("comments/{id}/replies")
    fun postReply(@Path("id") id: Int, @Body reply: JsonObject): Call<Comment>

    @PUT("videos/{id}/complete")
    fun putVideoComplete(@Path("id") id: Int): Call<Void>

    @DELETE("videos/{id}/complete")
    fun deleteVideoComplete(@Path("id") id: Int): Call<Void>
}