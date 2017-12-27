package com.example.computec.eltadreb.ui.login.rest

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView

interface RestPasswordContract {

    interface View: MvpView

    interface Presenter<V: View>: MvpPresenter<V> {
        fun onRestBtnClick(email: String?)
    }
}