package com.example.computec.eltadreb.ui.comment

import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.model.Course
import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView

interface CommentContract {

    interface View: MvpView {
        fun setComment(comment: Comment)
        fun setReply(reply: Comment)
    }

    interface Presenter<v: View>: MvpPresenter<v> {
        fun getComment(id: Int)
        fun addReply(reply: Comment, id: Int)
    }
}