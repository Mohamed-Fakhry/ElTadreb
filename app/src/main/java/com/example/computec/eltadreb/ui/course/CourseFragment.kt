package com.example.computec.eltadreb.ui.course

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.model.Course
import com.example.computec.eltadreb.model.Video
import com.example.computec.eltadreb.ui.base.BaseFragment
import com.example.computec.eltadreb.ui.video.adapter.VideosAdapter
import kotlinx.android.synthetic.main.fragment_course.*

class CourseFragment : BaseFragment(), CourseContract.View {

    companion object {
        val ID_KEY = "id"

        fun newInstance(id: Int): CourseFragment {
            val courseFragment = CourseFragment()
            val bundle = Bundle()
            bundle.putInt(ID_KEY, id)
            courseFragment.arguments = bundle
            return courseFragment
        }
    }

    private lateinit var videoAdapter: VideosAdapter
    private lateinit var coursePresenter: CourseContract.Presenter<CourseFragment>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_course, container, false)
        setUp(root)
        return root
    }

    override fun setUp(view: View?) {
        coursePresenter = CoursePresenter()
        coursePresenter.onAttach(this)
        coursePresenter.getCourse(arguments.getInt(ID_KEY))

        videosRV?.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
    }

    override fun setCourse(course: Course) {
        val videos: MutableList<Video> = course.videos!!
        videoAdapter = VideosAdapter(videos)
        videosRV?.adapter = videoAdapter
    }
}