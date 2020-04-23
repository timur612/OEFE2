package com.timur.itlab.oefe

import android.content.ClipDescription
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.cardview.widget.CardView
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_study.*
import android.content.ClipData
import android.graphics.Color
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_study.view.*
import kotlinx.android.synthetic.main.conf_fragment.view.*


class StudyActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

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

        lltop.setOnDragListener(dragListener)
        llbottom.setOnDragListener(dragListener)
        llbottom2.setOnDragListener(dragListener)
        llbottom3.setOnDragListener(dragListener)

        dragView.setOnLongClickListener{
            val clipText = "Ты молодец!"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }
        dragView2.setOnLongClickListener{
            val clipText = "Ты молодец!"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }
        dragView3.setOnLongClickListener{
            val clipText = "Ты молодец!"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    val dragListener = View.OnDragListener { view, event ->
        when(event.action){
            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                val item = event.clipData.getItemAt(0)

                val v = event.localState as View
                val owner = v.parent as ViewGroup
                val destination = view as CardView
                    if (v.dragView != null){
                        val dragData = item.text
                        Toast.makeText(this, dragData, Toast.LENGTH_SHORT).show()

                        view.invalidate()


                        owner.removeView(v)

                        destination.addView(v)
                        //destination.visibility = View.INVISIBLE
                        v.visibility = View.VISIBLE

                        true
                    }else{
                        Toast.makeText(this, "Подумай еще раз!", Toast.LENGTH_SHORT).show()
                        lltop.setBackgroundColor(Color.RED)
                        false
                    }




            }
            DragEvent.ACTION_DRAG_ENDED -> {
                val v = event.localState as View
                view.invalidate()
                lltop.setBackgroundColor(Color.WHITE)
                v.visibility = View.VISIBLE
                true
            }
            else -> false
        }
    }


}
