package com.example.computec.eltadreb.ui.video

import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.model.Video
import com.example.computec.eltadreb.service.model.video.VideoModel
import com.example.computec.eltadreb.service.model.video.VideoModelImpl
import com.example.computec.eltadreb.ui.base.BasePresenter

class VideoPresenter<V : VideoContract.View> : BasePresenter<V>(), VideoContract.Presenter<V>,
        VideoModel.OnGetVideoListener, VideoModel.OnPotCommentListener {

    var videoModel: VideoModel = VideoModelImpl()

    override fun getVideo(id: Int) {
        mvpView!!.showLoading()
        videoModel.getVideo(id, this)
    }

    override fun onSuccess(video: Video) {
        mvpView!!.hideLoading()
        mvpView!!.setVideoView(video)
        videoModel.getComments(video.id, this)
    }

    override fun onCanceled() {
        mvpView!!.hideLoading()
    }

    override fun onAccountStopped() {
        mvpView!!.hideLoading()
    }

    override fun setComment(comment: Comment, id: Int) {
        mvpView!!.showLoading()
        videoModel.postComment(id, comment, this)
    }

    override fun onSuccessComment(comment: Comment) {
        mvpView!!.hideLoading()
        mvpView!!.addComment(comment)
    }

    override fun onSuccess(comments: MutableList<Comment>) {
        mvpView!!.setVideoCommentView(comments)
    }
}