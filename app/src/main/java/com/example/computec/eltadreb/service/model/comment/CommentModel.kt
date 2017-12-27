package com.example.computec.eltadreb.service.model.comment

import com.example.computec.eltadreb.model.Comment

interface CommentModel {

    interface OnGetCommentListener {

        fun onCanceled()

        fun onSuccess(comment: Comment)

        fun onAccountStopped()
    }

    interface OnGetReplyListener: OnGetCommentListener {

        fun onSuccessReply(comment: Comment)
    }

    fun postReply(id: Int, comment: Comment, listener: OnGetReplyListener)

    fun getComment(id: Int, listener: OnGetCommentListener)
}