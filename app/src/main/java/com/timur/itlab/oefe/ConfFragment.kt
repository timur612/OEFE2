package com.timur.itlab.oefe

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.conf_fragment.view.*
import kotlinx.android.synthetic.main.study_fragment.view.*

class ConfFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view: View = inflater!!.inflate(R.layout.conf_fragment, container, false)


        view.button3.setOnClickListener { view ->
            activity?.let{
                val intent = Intent (it, StudyActivity::class.java)
                it.startActivity(intent) //включает новую активити с Конференцией
            }
        }
        // Return the fragment view/layout
        return view
    }

    companion object {
        fun newInstance(): ConfFragment = ConfFragment()
    }
}
