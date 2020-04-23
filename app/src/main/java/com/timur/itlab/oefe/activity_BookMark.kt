package com.timur.itlab.oefe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity__book_mark.*

class activity_BookMark : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__book_mark)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Журнал"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        webView.webViewClient = MyWebViewClient()

        loadpage_but.setOnClickListener(){
            webView.loadUrl("https://sgo.e-yakutia.ru/angular/school/studentdiary/")
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

class MyWebViewClient: WebViewClient( ){
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        view?.loadUrl(request?.url.toString())
        return true
    }
}
