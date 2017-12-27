package com.example.computec.eltadreb.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.service.LoginPref
import com.example.computec.eltadreb.ui.base.BaseFragment
import com.example.computec.eltadreb.ui.login.rest.RestPasswordFragment
import com.example.computec.eltadreb.ui.main.MainActivity
import com.example.computec.eltadreb.utils.ActivityUtils
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment(), LoginContract.View {

    companion object {
        fun newInstance(): LoginFragment = LoginFragment()
    }

    private lateinit var loginPresenter: LoginContract.Presenter<LoginFragment>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_login, container, false)
        return root
    }

    override fun onStart() {
        super.onStart()
        setUp(null)
    }

    override fun setUp(view: View?) {
        loginPresenter = LoginPresenter()
        loginPresenter.onAttach(this)

        loginB.setOnClickListener {
            loginPresenter.onLoginBtnClick(usernameET?.text.toString(), passwordET?.text.toString())
        }

        rememberTV.setOnClickListener {
            ActivityUtils.addFragmentToActivity(activity.supportFragmentManager,
                    RestPasswordFragment.newInstance(), true)
        }

        passwordET.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE && isLoginValid()) {
                loginB.performClick()
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun isLoginValid(): Boolean =
            usernameET?.text!!.isNotEmpty() && passwordET?.text!!.isNotEmpty()


    override fun openMainActivity() {
        startActivity(MainActivity.getStartIntent(activity))
        activity.finish()
    }

    override fun setToken(token: String) {
        val loginPref = LoginPref(activity)
        loginPref.setAccessToken(activity, token)
    }
}