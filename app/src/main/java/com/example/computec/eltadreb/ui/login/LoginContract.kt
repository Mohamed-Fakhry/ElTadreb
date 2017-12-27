package com.example.computec.eltadreb.ui.login

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView


interface LoginContract {

    interface View: MvpView {
        fun openMainActivity()
        fun setToken(token: String)
    }

    interface Presenter<v: View>: MvpPresenter<v> {
        fun onLoginBtnClick(username: String?, password: String?)
    }
}