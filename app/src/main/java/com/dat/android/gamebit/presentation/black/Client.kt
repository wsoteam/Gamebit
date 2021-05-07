package com.dat.android.gamebit.presentation.black

import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import com.dat.android.gamebit.utils.PreferenceProvider

class Client : WebViewClient() {
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().acceptCookie()
        CookieManager.getInstance().flush()
    }

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        PreferenceProvider.setLastURL(url!!)
        view!!.loadUrl(url!!)
        return true
    }
}