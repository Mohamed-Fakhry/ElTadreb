package com.example.computec.eltadreb.ui.course

import com.example.computec.eltadreb.model.Course
import com.example.computec.eltadreb.service.model.course.CourseModel
import com.example.computec.eltadreb.service.model.course.CourseModelImpl
import com.example.computec.eltadreb.ui.base.BasePresenter

class CoursePresenter<V: CourseContract.View>: BasePresenter<V>(), CourseContract.Presenter<V>, CourseModel.OnGetCourseListener {

    val courseModel: CourseModel = CourseModelImpl()

    override fun getCourse(id: Int) {
        mvpView?.showLoading()
        courseModel.getCourse(id,this)
    }

    override fun onSuccess(course: Course) {
        mvpView?.hideLoading()
        mvpView?.setCourse(course)
    }

    override fun onCanceled() {
        mvpView?.hideLoading()
    }

    override fun onAccountStopped() {
        mvpView?.hideLoading()
    }
}