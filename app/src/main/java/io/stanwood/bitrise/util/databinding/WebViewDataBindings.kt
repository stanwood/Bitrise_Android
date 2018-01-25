package io.stanwood.bitrise.util.databinding

import android.databinding.BindingAdapter
import android.util.Log
import android.webkit.WebView
import android.webkit.WebChromeClient
import android.webkit.WebViewClient

@BindingAdapter("url")
fun loadUrl(webView: WebView, url: String?) {
    Log.e("pagelx", url+"")
    webView.webChromeClient = WebChromeClient()
    webView.webViewClient = WebViewClient()
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setLoadWithOverviewMode(true);
    webView.getSettings().setUseWideViewPort(true);

    url?.let { webView.loadUrl(it) }
}