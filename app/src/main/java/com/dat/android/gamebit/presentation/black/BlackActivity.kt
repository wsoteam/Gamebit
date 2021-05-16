package com.dat.android.gamebit.presentation.black

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dat.android.gamebit.utils.PreferenceProvider
import com.dat.android.gamebit.R
import com.dat.android.gamebit.utils.notification.NotifManager
import kotlinx.android.synthetic.main.activity_black.*

class BlackActivity : AppCompatActivity(R.layout.activity_black) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        NotifManager.setAlarm(this)

        webBlack.settings.javaScriptEnabled = true
        webBlack.settings.domStorageEnabled = true
        webBlack.settings.userAgentString =
            webBlack.settings.userAgentString + "MobileAppClient/Android/0.9"
        webBlack.webViewClient = Client()

        if (savedInstanceState == null) {
            if (PreferenceProvider.getLastURL() == "") {
                var url = PreferenceProvider.getUrl()
                webBlack.loadUrl(url)
            } else {
                var url = PreferenceProvider.getLastURL()
                webBlack.loadUrl(url)
            }
        }
    }

    override fun onBackPressed() {
        if (webBlack.canGoBack()) {
            webBlack.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webBlack.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        webBlack.restoreState(savedInstanceState)
    }
}
