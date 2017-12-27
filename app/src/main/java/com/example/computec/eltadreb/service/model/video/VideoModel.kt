package com.example.computec.eltadreb.service.model.video

import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.model.Video

interface VideoModel {
    interface OnGetVideoListener {

        fun onSuccess(video: Video)

        fun onSuccess(comments: MutableList<Comment>)

        fun onCanceled()

        fun onAccountStopped()
    }

    interface OnPotCommentListener: OnGetVideoListener {

        fun onSuccessComment(comment: Comment)
    }

    fun postComment(id: Int, comment: Comment, listener: OnPotCommentListener)

    fun getVideo(id: Int, listener: OnGetVideoListener)

    fun getComments(id: Int, listener: OnGetVideoListener)
}