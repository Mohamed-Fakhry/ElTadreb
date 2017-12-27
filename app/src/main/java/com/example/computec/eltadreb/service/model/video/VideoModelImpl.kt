package com.example.computec.eltadreb.service.model.video

import com.example.computec.eltadreb.App
import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.model.Video
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideoModelImpl : VideoModel {

    override fun getVideo(id: Int, listener: VideoModel.OnGetVideoListener) {
        App.getService.getVideo(id).enqueue(object : Callback<Video> {

            override fun onResponse(call: Call<Video>?, response: Response<Video>?) =
                    when {
                        response!!.isSuccessful -> listener.onSuccess(response.body()!!)
                        response.code() == 401 -> listener.onAccountStopped()
                        else -> listener.onCanceled()
                    }

            override fun onFailure(call: Call<Video>?, t: Throwable?) {
                listener.onCanceled()
            }
        })
    }

    override fun getComments(id: Int, listener: VideoModel.OnGetVideoListener) {
        App.getService.getComments(id).enqueue(object : Callback<MutableList<Comment>> {

            override fun onResponse(call: Call<MutableList<Comment>>?, response: Response<MutableList<Comment>>?)  {
                    if(response!!.isSuccessful) listener.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<MutableList<Comment>>?, t: Throwable?) {}
        })
    }

    override fun postComment(id: Int, comment: Comment, listener: VideoModel.OnPotCommentListener) {
        val commentJson = JsonObject()
        commentJson.addProperty("content", comment.content)
        App.getService.postComment(id, commentJson).enqueue(object : Callback<Comment> {

            override fun onResponse(call: Call<Comment>?, response: Response<Comment>?) =
                    when {
                        response!!.isSuccessful -> listener.onSuccessComment(response.body()!!)
                        response.code() == 401 -> listener.onAccountStopped()
                        else -> listener.onCanceled()
                    }

            override fun onFailure(call: Call<Comment>?, t: Throwable?) = listener.onCanceled()
        })
    }


}