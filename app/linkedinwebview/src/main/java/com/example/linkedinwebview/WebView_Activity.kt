package com.example.linkedinwebview

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.SeekBar

class WebView_Activity : AppCompatActivity() {
    lateinit var web_view: WebView
    lateinit var progress_bar: ProgressBar
    lateinit var webSettings: WebSettings
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        web_view = findViewById(R.id.web_view)
        web_view.scrollBarStyle=WebView.SCROLLBARS_OUTSIDE_OVERLAY
        progress_bar = findViewById(R.id.progrerss_bar)
        webSettings=web_view.settings
        webSettings.useWideViewPort=true
        webSettings.javaScriptEnabled=true
        webSettings.setSupportZoom(true)
        if (savedInstanceState==null)
        {
            progress_bar.visibility= View.VISIBLE
            web_view.loadUrl(getString(R.string.url))

        }
        web_view.webViewClient=object :WebViewClient()
        {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progress_bar.visibility=View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                progress_bar.visibility=View.GONE
                super.onPageFinished(view, url)

            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
            }
        }

    }

    override fun onBackPressed() {
        if(web_view.canGoBack())
            web_view.goBack()
        super.onBackPressed()
    }

    override fun onResume() {
        web_view.onResume()
        super.onResume()
    }

    override fun onPause() {
        web_view.onPause()
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        web_view.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        web_view.restoreState(savedInstanceState)
    }
}