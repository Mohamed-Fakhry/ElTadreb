package com.example.computec.eltadreb.ui.video.adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.ui.comment.CommentFragment
import com.example.computec.eltadreb.utils.ActivityUtils
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentVH(itemView: View, private var isLastLevel: Boolean) : RecyclerView.ViewHolder(itemView) {

    fun setup(comment: Comment) {
        with(itemView) {
            if (!isLastLevel) {
                setOnClickListener {
                    ActivityUtils.addFragmentToActivity((context as Activity).fragmentManager,
                            CommentFragment.newInstance(comment.id!!), true)
                }
                repliesNumberTV.text =
                        if(comment.repliesN > 0)
                            "${comment.repliesN} ردود"
                        else
                            "لا يوجد ردرود"
                } else {
                replyL?.visibility = View.GONE
            }
            authorNameTV?.text = comment.author!!.name
            dateTV?.text = comment.createdAt
            contentTV?.text = comment.content
        }
    }
}