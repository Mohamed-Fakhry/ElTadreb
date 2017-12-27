package com.example.computec.eltadreb.ui.comment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.ui.base.BaseYoutubeFragment
import com.example.computec.eltadreb.ui.video.adapter.CommentsAdapter
import kotlinx.android.synthetic.main.fragment_comment.*

class CommentFragment : BaseYoutubeFragment(), CommentContract.View {

    companion object {
        val ID_KEY = "id"

        fun newInstance(id: Int): CommentFragment {
            val commentFragment = CommentFragment()
            val bundle = Bundle()
            bundle.putInt(ID_KEY, id)
            commentFragment.arguments = bundle
            return commentFragment
        }
    }

    lateinit var commentsAdapter: CommentsAdapter
    lateinit var commentPresenter: CommentPresenter<CommentFragment>
    lateinit var commentView: Comment

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_comment, container, false)


    override fun onStart() {
        super.onStart()
        setUp(null)
    }

    override fun setUp(view: View?) {
        commentPresenter = CommentPresenter()
        commentPresenter.onAttach(this)
        commentPresenter.getComment(arguments.getInt(ID_KEY))
        commentsRV?.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        fabAction()
    }

    override fun setComment(comment: Comment) {
        with(comment) {
            authorNameTV.text = author?.name
            dateTV.text = createdAt
            contentTV.text = content
            val replies: MutableList<Comment> = replies!!
            commentsAdapter = CommentsAdapter(replies, true)
            commentsRV?.adapter = commentsAdapter
        }

        commentView = comment

        sendIV.setOnClickListener({
            val comment = Comment(content = commentET.text.toString())
            commentPresenter.addReply(comment, commentView.id!!)
        })
    }

    override fun setReply(reply: Comment) {
        commentView.replies?.add(reply)
        commentsAdapter.notifyDataSetChanged()
    }

    private fun fabAction() {
        fab.setOnClickListener {
            if (commentLL.visibility == View.GONE) {
                commentLL.visibility = View.VISIBLE
            } else if (commentLL.visibility == View.VISIBLE) {
                commentLL.visibility = View.GONE
            }
        }
    }
}