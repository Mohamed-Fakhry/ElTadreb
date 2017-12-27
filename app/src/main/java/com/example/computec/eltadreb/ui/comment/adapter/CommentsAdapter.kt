package com.example.computec.eltadreb.ui.video.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.model.Comment

class CommentsAdapter(private val comments: MutableList<Comment>,
                      private val isLastLevel: Boolean = false) : RecyclerView.Adapter<CommentVH>() {

    override fun onBindViewHolder(holder: CommentVH?, position: Int) {
        holder!!.setup(comments[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CommentVH =
            CommentVH(LayoutInflater.from(parent?.context).inflate(R.layout.item_comment, null), isLastLevel)

    override fun getItemCount(): Int = comments.size
}