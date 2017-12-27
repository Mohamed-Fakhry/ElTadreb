package com.example.computec.eltadreb.ui.video.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.computec.eltadreb.R

class AchievementsAdapter(private val achievements: MutableList<Any>) : RecyclerView.Adapter<AchievementVH>() {

    override fun onBindViewHolder(holder: AchievementVH?, position: Int) {}

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AchievementVH =
            AchievementVH(LayoutInflater.from(parent?.context).inflate(R.layout.item_achievement, null))

    override fun getItemCount(): Int = 8
}