package com.timur.itlab.oefe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class StudyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Задания"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
