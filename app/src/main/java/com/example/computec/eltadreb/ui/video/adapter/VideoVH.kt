package com.example.computec.eltadreb.ui.video.adapter

import android.view.View
import com.bumptech.glide.Glide.with
import com.example.computec.eltadreb.R.id.thumbIV
import com.example.computec.eltadreb.R.id.titleTV
import com.example.computec.eltadreb.model.Video
import com.example.computec.eltadreb.ui.video.VideoActivity


class VideoVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setUp(video: Video) {
        with(itemView) {
            titleTV.text = video.title
            thumbIV.loadImage(video.thumb)
            setOnClickListener({
                context.startActivity(VideoActivity.getStartIntent(context, video.id))
            })
        }
    }
}