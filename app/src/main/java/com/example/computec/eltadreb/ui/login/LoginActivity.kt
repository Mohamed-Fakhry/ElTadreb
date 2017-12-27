package com.example.computec.eltadreb.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseActivity
import com.example.computec.eltadreb.ui.main.MainActivity
import com.example.computec.eltadreb.utils.ActivityUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUp()
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, LoginActivity::class.java)
    }

    override fun setUp() {
        ActivityUtils.addFragmentToActivity(supportFragmentManager,
                LoginFragment.newInstance())
    }
}
