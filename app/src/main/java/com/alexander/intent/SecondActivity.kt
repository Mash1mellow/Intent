package com.alexander.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    lateinit var btnBack : Button
    lateinit var webv: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener({
            finish()
        })

        webv = findViewById(R.id.webv)
        val website:String? = intent.getStringExtra("website")
        if (website != null){
            webv.setWebViewClient(WebViewClient())
            webv.settings.javaScriptEnabled = true
            webv.loadUrl(website)
        }
    }
    override fun onBackPressed(){
        if (webv.canGoBack()){
            webv.goBack()
        }
        else{
            finish()
        }
    }
}

