package com.example.computec.eltadreb.ui.course

import com.example.computec.eltadreb.model.Course
import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView

interface CourseContract {

    interface View: MvpView {
        fun setCourse(course: Course)
    }

    interface Presenter<v: View>: MvpPresenter<v> {
        fun getCourse(id: Int)
    }
}