package com.example.computec.eltadreb.ui.courses.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.model.Course

class CoursesAdapter(private val courses: MutableList<Course>) : RecyclerView.Adapter<CourseVH>() {

    override fun onBindViewHolder(holder: CourseVH?, position: Int) {
        holder?.setUp(courses[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CourseVH =
            CourseVH(LayoutInflater.from(parent?.context).inflate(R.layout.item_subject, null))

    override fun getItemCount(): Int = courses.size
}