package com.example.computec.eltadreb.ui.rest

import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BasePresenter

class RestPasswordPresenter<V: RestPasswordContract.View>: BasePresenter<V>(), RestPasswordContract.Presenter<V> {

    override fun onRestBtnClick(email: String?) {
        if(email == null || email.isEmpty()) {
            mvpView?.onError(R.string.empty_email)
            return
        }

    }
}