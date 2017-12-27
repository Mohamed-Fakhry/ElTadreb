package com.example.computec.eltadreb.ui.achievements

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseFragment
import com.example.computec.eltadreb.ui.video.adapter.AchievementsAdapter
import kotlinx.android.synthetic.main.fragment_achievements.*

class AchievementsFragment : BaseFragment() {

    companion object {
        fun newInstance(): AchievementsFragment = AchievementsFragment()
    }

    lateinit var achievementsAdapter: AchievementsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_achievements, container, false)
        activity?.title = getString(R.string.nav_achievements)
        return root
    }

    override fun onStart() {
        super.onStart()
        setUp(null)
    }

    override fun setUp(view: View?) {
        achievementsRV?.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        var achievements: MutableList<Any> = mutableListOf()
        achievementsAdapter = AchievementsAdapter(achievements)
        achievementsRV?.adapter = achievementsAdapter

    }
}