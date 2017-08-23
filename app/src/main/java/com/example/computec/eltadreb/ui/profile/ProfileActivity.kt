package com.example.computec.eltadreb.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseActivity
import com.example.computec.eltadreb.utils.ActivityUtils

class ProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setUp()
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, ProfileActivity::class.java)
    }

    override fun setUp() {
        ActivityUtils.addFragmentToActivity(supportFragmentManager,
                ProfileFragment.newInstance())
    }

}
