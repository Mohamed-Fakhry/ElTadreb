package com.example.computec.eltadreb.ui.login

import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.service.model.login.LoginModel
import com.example.computec.eltadreb.service.model.login.LoginModelImpl
import com.example.computec.eltadreb.ui.base.BasePresenter

class LoginPresenter<V: LoginContract.View>: BasePresenter<V>(), LoginContract.Presenter<V>
        , LoginModel.OnLoginFinishedListener {

    var loginModel: LoginModel = LoginModelImpl()

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

        if (mvpView!!.isNetworkConnected()) {
            mvpView?.showLoading()
            loginModel.login(username, password, this)
        } else {
            mvpView?.onError(R.string.error_no_internet_connection)
        }
    }

    override fun onSuccess(token: String) {
        mvpView?.hideLoading()
        mvpView?.setToken(token)
        mvpView?.openMainActivity()
    }

    override fun onCanceled() {
        mvpView?.hideLoading()
        mvpView?.onError(R.string.error_username_password_incorrect)
    }

    override fun onAccountStopped() {}
}