package com.example.computec.eltadreb.ui.courses.adapter

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.computec.eltadreb.model.Course
import com.example.computec.eltadreb.ui.course.CourseFragment
import com.example.computec.eltadreb.utils.ActivityUtils
import com.example.computec.eltadreb.utils.loadImage
import kotlinx.android.synthetic.main.item_subject.view.*

class CourseVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setUp(course: Course) {
        val activity: AppCompatActivity = itemView?.context as AppCompatActivity
        with(itemView) {
            coverIV.loadImage(course.cover)
            nameTV.text = course.name
            courseL.setOnClickListener({
                ActivityUtils.addFragmentToActivity(activity.supportFragmentManager,
                        CourseFragment.newInstance(course.id), true)
                activity.title = course.name
            })
        }
    }
}