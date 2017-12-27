package com.example.computec.eltadreb.ui.comment

import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.service.model.comment.CommentModel
import com.example.computec.eltadreb.service.model.comment.CommentModelImpl
import com.example.computec.eltadreb.ui.base.BasePresenter

class CommentPresenter<V: CommentContract.View>: BasePresenter<V>(), CommentContract.Presenter<V>
        , CommentModel.OnGetCommentListener, CommentModel.OnGetReplyListener {

    private val commentModel: CommentModel = CommentModelImpl()

    override fun getComment(id: Int) {
        mvpView?.showLoading()
        commentModel.getComment(id, this)
    }

    override fun onSuccess(comment: Comment) {
        mvpView?.hideLoading()
        mvpView?.setComment(comment)
    }

    override fun onCanceled() {
        mvpView?.hideLoading()
    }

    override fun onAccountStopped() {
        mvpView?.hideLoading()
    }

    override fun addReply(reply: Comment, id: Int) {
        mvpView?.showLoading()
        commentModel.postReply(id, reply, this)
    }

    override fun onSuccessReply(comment: Comment) {
        mvpView?.hideLoading()
        mvpView?.setReply(comment)
    }
}