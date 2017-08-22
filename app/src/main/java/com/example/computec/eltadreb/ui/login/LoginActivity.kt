package com.example.computec.eltadreb.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginContract.View {

    private lateinit var loginPresenter: LoginContract.Presenter<LoginActivity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUp()
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, LoginActivity::class.java)
    }

    override fun setUp() {
        loginPresenter = LoginPresenter()
        loginPresenter.onAttach(this@LoginActivity)
        loginB.setOnClickListener {
            loginPresenter.onLoginBtnClick(usernameET?.text.toString(), passwordET?.text.toString())
        }
    }

    override fun openMainActivity() {

    }

    override fun onDestroy() {
        loginPresenter.onDetach()
        super.onDestroy()
    }
}
