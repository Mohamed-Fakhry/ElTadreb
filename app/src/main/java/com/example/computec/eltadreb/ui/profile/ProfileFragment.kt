package com.example.computec.eltadreb.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.model.Student
import com.example.computec.eltadreb.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment(), ProfileContract.View {

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }

    private lateinit var profilePresenter: ProfileContract.Presenter<ProfileFragment>
    private lateinit var studentV: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(null)
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun setUp(view: View?) {
        profilePresenter = ProfilePresenter()
        profilePresenter.onAttach(this)
        profilePresenter.getStudent()
    }

    override fun setStudent(student: Student) {
        with(student) {
            studentNameTV.text = name
            schoolNameTV.text = school.name
            phoneTV.text = phone
            academicYearTV.text = academicYear
            academicDivisionTV.text = academicDivision
        }
        if (studentDataSV.visibility == View.INVISIBLE)
            studentDataSV.visibility = View.VISIBLE
        studentV = student
    }
}