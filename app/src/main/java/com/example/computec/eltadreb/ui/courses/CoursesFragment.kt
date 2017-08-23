package com.example.computec.eltadreb.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseFragment

class CoursesFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_courses, container, false)
        activity?.title = getString(R.string.nav_courses)
        return root
    }

    companion object {
        fun newInstance(): CoursesFragment = CoursesFragment()
    }

    override fun setUp(view: View?) {

    }
}