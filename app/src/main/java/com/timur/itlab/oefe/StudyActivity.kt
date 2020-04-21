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
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T







class StudyActivity : AppCompatActivity(), View.OnTouchListener, View.OnDragListener {
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

        setListeners()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setListeners() {
        tv_dropdrop.setOnTouchListener(this)
        ll_pinklayout.setOnDragListener(this)
        drag_ans.setOnDragListener(this)
    }

    override fun onDrag(view: View, dragEvent: DragEvent):Boolean {
        var dragAction = dragEvent.getAction()
        Log.d(TAG, "onDrag: view->$view\n DragEvent$dragEvent")
        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_ENDED -> {
                Log.d(TAG, "onDrag: ACTION_DRAG_ENDED ")
                val result = dragEvent.getResult()
                if(result)
                {
                    Log.d(TAG, "Succeded")
                }else
                {
                    Log.d(TAG, "Failed")
                }
                return true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED")
                return true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                Log.d(TAG, "onDrag: ACTION_DRAG_ENTERED")
                return true
            }
            DragEvent.ACTION_DRAG_STARTED -> {
                Log.d(TAG, "onDrag: ACTION_DRAG_STARTED")
                var clipDescription = dragEvent.getClipDescription()
                return true
            }
            DragEvent.ACTION_DROP -> {
                val clipData = dragEvent.getClipData()
                val itemCount = clipData.getItemCount()

                if(itemCount > 0){
                    val item = clipData.getItemAt(0)
                    val dragDropString = item.getText().toString()
                    val srcView = dragEvent.localState as View
                    val owner = srcView.parent as ViewGroup
                    owner.removeView(srcView)
                    val newContainer = view as LinearLayout
                    newContainer.addView(srcView)
                    srcView.setVisibility(View.VISIBLE)
                    // Returns true to make DragEvent.getResult() value to true.
                    return true
                }else if(dragAction == DragEvent.ACTION_DRAG_LOCATION)
                {
                    return true
                }else
                {
                   Log.d(TAG,"что-то не так")
                }



                return false
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                Log.d(TAG, "onDrag: ACTION_DRAG_LOCATION")
                return true
            }
            else -> return false
        }
    }
     override fun onTouch(view:View, motionEvent: MotionEvent):Boolean {
        Log.d(TAG, "onTouch: view->view$view\n MotionEvent$motionEvent")
        return if (motionEvent.action === MotionEvent.ACTION_DOWN) {
            val dragShadowBuilder = View.DragShadowBuilder(view)
            view.startDrag(null, dragShadowBuilder, view, 0)
            true
        } else {
            false
        }
    }
}
