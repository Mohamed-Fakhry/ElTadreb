package com.example.computec.eltadreb.ui.video.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.model.Video

class VideosAdapter(private val videos: MutableList<Video>) : RecyclerView.Adapter<VideoVH>() {

    override fun onBindViewHolder(holder: VideoVH?, position: Int) {
        holder!!.setUp(videos[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VideoVH =
            VideoVH(LayoutInflater.from(parent?.context).inflate(R.layout.item_video, null))

    override fun getItemCount(): Int = videos.size
}