package com.timur.itlab.oefe

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                toolbar.title = "Главная"
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_bookmark -> {
                toolbar.title = "Электронный журнал"
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_online_meeting -> {
                toolbar.title = "Конференции"
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_study -> {
                toolbar.title = "Учеба"

                val studyFragment = StudyFragment.newInstance()
                openFragment(studyFragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                toolbar.title = "Профиль"
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar!!

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
