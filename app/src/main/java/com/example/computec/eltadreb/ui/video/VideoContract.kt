package com.example.computec.eltadreb.ui.video

import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.model.Video
import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView

interface VideoContract {

    interface View: MvpView {
        fun setVideoView(video: Video)
        fun setVideoCommentView(comments: MutableList<Comment>)
        fun addComment(comment: Comment)
    }

    interface Presenter<v: View>: MvpPresenter<v> {
        fun getVideo(id: Int)
        fun setComment(comment: Comment, id: Int)
    }
}