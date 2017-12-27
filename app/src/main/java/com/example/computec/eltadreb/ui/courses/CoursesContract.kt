package com.example.computec.eltadreb.ui.courses

import com.example.computec.eltadreb.model.Category
import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView


interface CoursesContract {

    interface View: MvpView {
        fun setCourses(categories: MutableList<Category>)
    }

    interface Presenter<v: View>: MvpPresenter<v> {
        fun getCourses()
    }
}