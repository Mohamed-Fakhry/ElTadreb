package com.example.computec.eltadreb.ui.achievements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseFragment

class AchievementsFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_achievements, container, false)
        activity?.title = getString(R.string.nav_achievements)
        return root
    }

    companion object {
        fun newInstance(): AchievementsFragment = AchievementsFragment()
    }

    override fun setUp(view: View?) {

    }
}