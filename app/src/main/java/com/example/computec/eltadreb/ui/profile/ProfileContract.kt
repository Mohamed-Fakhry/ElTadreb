package com.example.computec.eltadreb.ui.profile

import com.example.computec.eltadreb.model.Student
import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView

interface ProfileContract {

    interface View: MvpView {
        fun setStudent(student: Student)
    }

    interface Presenter<v: View>: MvpPresenter<v> {
        fun getStudent()
    }
}