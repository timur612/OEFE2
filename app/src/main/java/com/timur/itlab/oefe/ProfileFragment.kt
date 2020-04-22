package com.timur.itlab.oefe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.study_fragment.view.*

class ProfileFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view: View = inflater!!.inflate(R.layout.fragment_profile, container, false)

        textView14.setOnClickListener{
            dostij.visibility = View.VISIBLE
            cardView.visibility = View.INVISIBLE
        }
        // Return the fragment view/layout
        return view
    }

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }
}
