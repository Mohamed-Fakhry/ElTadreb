package com.example.computec.eltadreb.service.model.comment

import com.example.computec.eltadreb.App
import com.example.computec.eltadreb.model.Category
import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.service.model.category.CategoriesModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentModelImpl : CommentModel {

    override fun getComment(id: Int, listener: CommentModel.OnGetCommentListener) {
        App.getService.getComment(id).enqueue(object : Callback<Comment> {

            override fun onResponse(call: Call<Comment>?, response: Response<Comment>?) =
                    when {
                        response!!.isSuccessful -> listener.onSuccess(response.body()!!)
                        response.code() == 401 -> listener.onCanceled()
                        else -> listener.onCanceled()
                    }

            override fun onFailure(call: Call<Comment>?, t: Throwable?) {
                listener.onCanceled()
            }
        })
    }

    override fun postReply(id: Int, comment: Comment, listener: CommentModel.OnGetReplyListener) {
        val commentJson = JsonObject()
        commentJson.addProperty("content", comment.content)
        App.getService.postReply(id, commentJson).enqueue(object : Callback<Comment> {

            override fun onResponse(call: Call<Comment>?, response: Response<Comment>?) =
                    when {
                        response!!.isSuccessful -> listener.onSuccessReply(response.body()!!)
                        response.code() == 401 -> listener.onCanceled()
                        else -> listener.onCanceled()
                    }

            override fun onFailure(call: Call<Comment>?, t: Throwable?) {

            }
        })
    }
}