package com.example.computec.eltadreb.ui.login

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView


interface LoginContract {

    interface View: MvpView {
        fun openMainActivity()
    }

    interface Presenter<V: View>: MvpPresenter<V> {
        fun onLoginBtnClick(username: String?, password: String?)
    }
}