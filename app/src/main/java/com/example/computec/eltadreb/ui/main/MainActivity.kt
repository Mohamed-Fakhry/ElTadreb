package com.example.computec.eltadreb.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.service.LoginPref
import com.example.computec.eltadreb.ui.achievements.AchievementsFragment
import com.example.computec.eltadreb.ui.base.BaseActivity
import com.example.computec.eltadreb.ui.courses.CoursesFragment
import com.example.computec.eltadreb.ui.profile.ProfileActivity
import com.example.computec.eltadreb.utils.ActivityUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUp()
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    override fun setUp() {
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        openMainFragment()
    }

    override fun onBackPressed() = when {
        drawerLayout.isDrawerOpen(GravityCompat.START) -> drawerLayout.closeDrawer(GravityCompat.START)
        fragmentManager.backStackEntryCount > 0 -> {
            Log.e("count", fragmentManager.backStackEntryCount.toString())
            fragmentManager.popBackStack()
        }
        else -> {
            Log.e("count", fragmentManager.backStackEntryCount.toString())
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_main -> {
                openMainFragment()
            }
            R.id.nav_courses -> {
                openCoursesFragment()
            }
            R.id.nav_achievements -> {
                openAchievementsFragment()
            }
            R.id.nav_profile -> {
                openProfileActivity()
            }
            R.id.nav_exit -> {
                val loginPref = LoginPref(this)
                loginPref.removeAccessToken(this)
                finish()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun openMainFragment() {
        ActivityUtils.addFragmentToActivity(supportFragmentManager,
                MainFragment.newInstance())
    }

    private fun openCoursesFragment() {
        ActivityUtils.addFragmentToActivity(supportFragmentManager,
                CoursesFragment.newInstance())
    }

    private fun openAchievementsFragment() {
        ActivityUtils.addFragmentToActivity(supportFragmentManager,
                AchievementsFragment.newInstance())
    }

    private fun openProfileActivity() {
        startActivity(ProfileActivity.getStartIntent(this))
    }
}
