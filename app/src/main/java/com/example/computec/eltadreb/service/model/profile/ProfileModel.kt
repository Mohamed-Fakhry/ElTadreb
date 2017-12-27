package com.example.computec.eltadreb.service.model.profile

import com.example.computec.eltadreb.model.Student

interface ProfileModel {

    interface OnGetProfileListener {

        fun onCanceled()

        fun onSuccess(student: Student)

        fun onAccountStopped()
    }

    fun getProfile(listener: OnGetProfileListener)
}