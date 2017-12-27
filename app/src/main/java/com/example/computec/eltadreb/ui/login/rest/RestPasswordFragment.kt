package com.example.computec.eltadreb.ui.login.rest


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_rest_password.*


class RestPasswordFragment : BaseFragment(), RestPasswordContract.View {

    companion object {
        fun newInstance(): RestPasswordFragment = RestPasswordFragment()
    }

    lateinit var restPasswordPresenter : RestPasswordContract.Presenter<RestPasswordFragment>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_rest_password, container, false)
        return root
    }

    override fun onStart() {
        super.onStart()
        setUp(null)
    }
    override fun setUp(view: View?) {
        restPasswordPresenter = RestPasswordPresenter()
        restPasswordPresenter.onAttach(this)

        restPasswordB.setOnClickListener {
            restPasswordPresenter.onRestBtnClick(emailET?.text?.toString())
        }
    }
}