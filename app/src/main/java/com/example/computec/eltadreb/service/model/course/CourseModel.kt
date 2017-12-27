package com.example.computec.eltadreb.service.model.course

import com.example.computec.eltadreb.model.Course

interface CourseModel {
    interface OnGetCourseListener {

        fun onSuccess(course: Course)

        fun onCanceled()

        fun onAccountStopped()
    }

    fun getCourse(id: Int, listener: OnGetCourseListener)
}