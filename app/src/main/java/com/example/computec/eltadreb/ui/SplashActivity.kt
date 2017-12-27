package com.example.computec.eltadreb.ui

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.service.LoginPref
import com.example.computec.eltadreb.ui.login.LoginActivity
import com.example.computec.eltadreb.ui.main.MainActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            loginToApp()
        }, 3000)
    }

    private fun loginToApp() {
        val loginPref = LoginPref(this)
        val accessToken = loginPref.accessToken

        if (accessToken == null || accessToken.isEmpty()) {
            startActivity(LoginActivity.getStartIntent(this))
        } else {
            startActivity(MainActivity.getStartIntent(this))
            loginPref.setSecureConnection()
        }
        finish()
    }

}
