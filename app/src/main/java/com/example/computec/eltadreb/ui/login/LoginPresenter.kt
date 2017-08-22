package com.example.computec.eltadreb.ui.login

import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BasePresenter


class LoginPresenter<V: LoginContract.View>: BasePresenter<V>(), LoginContract.Presenter<V> {

    override fun onLoginBtnClick(username: String?, password: String?) {

        if((username == null || username.isEmpty()) && (password == null || password.isEmpty())) {
            mvpView?.onError(R.string.empty_username_and_password)
            return
        } else if (username == null || username.isEmpty()) {
            mvpView?.onError(R.string.empty_username)
            return
        } else if (password == null || password.isEmpty()) {
            mvpView?.onError(R.string.empty_password)
            return
        }

        mvpView?.openMainActivity()
    }
}