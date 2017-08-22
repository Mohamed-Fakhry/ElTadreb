package com.example.computec.eltadreb.ui.rest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_rest_password.*

class RestPasswordActivity : BaseActivity(), RestPasswordContract.View {

    private lateinit var restPasswordPresenter: RestPasswordContract.Presenter<RestPasswordActivity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_password)
    }

    companion object {
        fun getStartIntent(context: Context): Intent =
                Intent(context, RestPasswordActivity::class.java)
    }

    override fun setUp() {
        restPasswordPresenter = RestPasswordPresenter()
        restPasswordPresenter.onAttach(this@RestPasswordActivity)
        restPasswordB.setOnClickListener {
            restPasswordPresenter.onRestBtnClick(emailET?.text.toString())
        }
    }
}
