package com.example.computec.eltadreb.ui.profile

import com.example.computec.eltadreb.model.Student
import com.example.computec.eltadreb.service.model.profile.ProfileModel
import com.example.computec.eltadreb.service.model.profile.ProfileModelImpl
import com.example.computec.eltadreb.ui.base.BasePresenter

class ProfilePresenter<V: ProfileContract.View>: BasePresenter<V>(), ProfileContract.Presenter<V>
        , ProfileModel.OnGetProfileListener {

    var profileModel: ProfileModel = ProfileModelImpl()

    override fun getStudent() {
        mvpView?.showLoading()
        profileModel.getProfile(this)
    }

    override fun onSuccess(student: Student) {
        mvpView?.hideLoading()
        mvpView?.setStudent(student)
    }

    override fun onCanceled() {
        mvpView?.hideLoading()
    }

    override fun onAccountStopped() {
        mvpView?.hideLoading()
    }
}