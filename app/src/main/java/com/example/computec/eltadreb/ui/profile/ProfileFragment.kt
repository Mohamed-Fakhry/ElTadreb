package com.example.computec.eltadreb.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseFragment
import kotlinx.android.synthetic.main.app_bar_main.*

class ProfileFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_profile, container, false)
        activity?.title = getString(R.string.nav_profile)
        return root
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }

    override fun setUp(view: View?) {

    }
}