package com.example.computec.eltadreb.ui.courses

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.model.Category
import com.example.computec.eltadreb.ui.base.BaseFragment
import com.example.computec.eltadreb.ui.courses.adapter.CoursesAdapter
import kotlinx.android.synthetic.main.fragment_courses.*

class CoursesFragment : BaseFragment(), CoursesContract.View {

    companion object {
        fun newInstance(): CoursesFragment = CoursesFragment()
    }

    lateinit var coursesAdapter: CoursesAdapter
    lateinit var categories: MutableList<Category>
    lateinit var coursesPresenter: CoursesContract.Presenter<CoursesFragment>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_courses, container, false)
        activity?.title = getString(R.string.nav_courses)
        setUp(root)
        return root
    }

    override fun setUp(view: View?) {
        coursesPresenter = CoursesPresenter()
        coursesPresenter.onAttach(this)
        coursesPresenter.getCourses()

        coursesRV?.layoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
        coursesRV2?.layoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
    }

    override fun setCourses(categories: MutableList<Category>) {
        this.categories =  categories
        var courseAdapter = CoursesAdapter(categories[0].courses)
        var courseAdapter2 = CoursesAdapter(categories[1].courses)
        coursesRV?.adapter = courseAdapter
        coursesRV2?.adapter = courseAdapter2
    }
}