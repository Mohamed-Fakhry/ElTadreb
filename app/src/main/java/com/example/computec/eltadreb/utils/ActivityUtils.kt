package com.example.computec.eltadreb.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.example.computec.eltadreb.R


object ActivityUtils {

    fun addFragmentToActivity(fragmentManager: FragmentManager,
                              fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}