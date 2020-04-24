package com.timur.itlab.oefe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.dostij_include_profile.*
import kotlinx.android.synthetic.main.dostij_include_profile.view.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.study_fragment.view.*

class ProfileFragment: Fragment(){
    val MENU_APLHA_ID = 1
    val MENU_SCALE_ID = 2
    val MENU_TRANSLATE_ID = 3
    val MENU_ROTATE_ID = 4
    val MENU_COMBO_ID = 5
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)


        view.textView14.setOnClickListener{
            dostij_card.visibility = View.VISIBLE
            cardView.visibility = View.GONE

        }
        view.close_btn.setOnClickListener{
            dostij_card.visibility = View.GONE
            cardView.visibility = View.VISIBLE
        }
        // Return the fragment view/layout
        return view
    }

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }
    /* override fun onCreateContextMenu(menu:ContextMenu, v:View, menuInfo:ContextMenu.ContextMenuInfo){
         when(v.getId()){
              R.id.dostij -> menu.add(0,MENU_APLHA_ID, 0, "alpha")
              R.id.dostij -> menu.add(0,MENU_SCALE_ID, 0, "scale")
             R.id.dostij -> menu.add(0,MENU_TRANSLATE_ID, 0, "translate")
             R.id.dostij -> menu.add(0,MENU_ROTATE_ID, 0, "rotate")
             R.id.dostij -> menu.add(0,MENU_COMBO_ID, 0, "combo")
         }
         super.onCreateContextMenu(menu, v, menuInfo)
     }
     val onContextItemSelected = { item: MenuItem ->
         var anim = null as Animation
         when(item.itemId){
             MENU_APLHA_ID -> anim = AnimationUtils.loadAnimation(it, R.anim.myalpha)

         }
     }
     */
}
