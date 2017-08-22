package com.example.computec.eltadreb.ui.rest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseActivity
import com.example.computec.eltadreb.utils.loadImage
import kotlinx.android.synthetic.main.activity_rest_password.*

class RestPasswordActivity : BaseActivity(), RestPasswordContract.View {

    private lateinit var restPasswordPresenter: RestPasswordContract.Presenter<RestPasswordActivity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_password)
        setUp()
    }

    companion object {
        fun getStartIntent(context: Context): Intent =
                Intent(context, RestPasswordActivity::class.java)
    }

    override fun setUp() {
        // setup presenter
        restPasswordPresenter = RestPasswordPresenter()
        restPasswordPresenter.onAttach(this@RestPasswordActivity)

        //setup view actions
        restPasswordB.setOnClickListener {
            restPasswordPresenter.onRestBtnClick(emailET?.text.toString())
        }
    }

    override fun onDestroy() {
        restPasswordPresenter.onDetach()
        super.onDestroy()
    }
}
