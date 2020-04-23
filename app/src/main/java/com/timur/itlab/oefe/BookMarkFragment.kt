package com.timur.itlab.oefe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_bookmark.view.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.study_fragment.view.*

class BookMarkFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view: View = inflater!!.inflate(R.layout.fragment_bookmark, container, false)

        view.journal.setOnClickListener{view ->
            activity?.let{
                val intent = Intent (it, activity_BookMark::class.java)
                it.startActivity(intent) //включает новую активити с Заданиями
            }
        }
        // Return the fragment view/layout
        return view
    }

    companion object {
        fun newInstance(): BookMarkFragment = BookMarkFragment()
    }
}
