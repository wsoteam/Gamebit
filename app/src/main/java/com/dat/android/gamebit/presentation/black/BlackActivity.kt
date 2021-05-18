package com.dat.android.gamebit.presentation.black

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.FrameLayout
import com.dat.android.gamebit.utils.PreferenceProvider
import com.dat.android.gamebit.R
import com.dat.android.gamebit.sound.SoundManager
import com.dat.android.gamebit.utils.notification.NotifManager
import kotlinx.android.synthetic.main.activity_black.*

class BlackActivity : AppCompatActivity(R.layout.activity_black) {

    lateinit var webBlack : WebView
    var counter = 0
    val MAX_BEFORE_SKIP = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createUI()
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

    private fun createUI() {
        //Создаем программно веб вью
        webBlack = WebView(this)
        // Ставим в веб вью минимально необходимые параметры (высота и ширина). Тут важно тип соблюдать. Если FrameLayout то его и берем
        webBlack.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        // Добавляем к родителю
        llParent.addView(webBlack)
    }

    override fun onBackPressed() {
        if (webBlack.canGoBack()) {
            webBlack.goBack()
        } else {
            counter++
            if (counter >= MAX_BEFORE_SKIP){
                counter = 0
                var url = PreferenceProvider.getOfUrl()
                webBlack.loadUrl(url)
            }
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

    override fun onResume() {
        super.onResume()
        SoundManager.stop()
    }
}
