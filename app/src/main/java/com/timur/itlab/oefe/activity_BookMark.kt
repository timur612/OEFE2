package com.timur.itlab.oefe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity__book_mark.*

class activity_BookMark : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__book_mark)

        loadpage_but.setOnClickListener(){
            webView.loadUrl("https://sgo.e-yakutia.ru/angular/school/studentdiary/")
        }

    }
}


