package com.timur.itlab.oefe

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.study_fragment.view.*

class StudyFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view: View = inflater!!.inflate(R.layout.study_fragment, container, false)

        view.button2.setOnClickListener { view ->
            activity?.let{
                val intent = Intent (it, StudyActivity::class.java)
                it.startActivity(intent)
            }
        }
        view.button.setOnClickListener { view ->
            Log.d("btn1", "Selected")
        }

        // Return the fragment view/layout
        return view
    }

    companion object {
        fun newInstance(): StudyFragment = StudyFragment()
    }
}
