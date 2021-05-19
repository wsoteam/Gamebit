package com.dat.android.gamebit.presentation.black

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.dat.android.gamebit.R
import com.dat.android.gamebit.sound.SoundManager
import com.dat.android.gamebit.utils.PreferenceProvider
import com.dat.android.gamebit.utils.notification.NotifManager
import kotlinx.android.synthetic.main.activity_black.*


class BlackActivity : AppCompatActivity(R.layout.activity_black) {

    lateinit var webBlack : WebView
    var counter = 0
    val MAX_BEFORE_SKIP = 2



    private val IMG_PICK = 1

    private val URLL = "https://www.avalon78.com/ru/bonus-wheel-page"//

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        createUI()
        NotifManager.setAlarm(this)

        webBlack.settings.allowFileAccess = true
        webBlack.settings.allowFileAccess = true
        webBlack.settings.allowContentAccess = true
        webBlack.settings.supportZoom()
        webBlack.settings.useWideViewPort = true

        webBlack.settings.javaScriptEnabled = true
        webBlack.settings.domStorageEnabled = true
        webBlack.settings.userAgentString =
            webBlack.settings.userAgentString + "MobileAppClient/Android/0.9"
        webBlack.webViewClient = Client()

        if (savedInstanceState == null) {
            if (PreferenceProvider.getLastURL() == "") {
                var url = PreferenceProvider.getUrl()
                webBlack.loadUrl(URLL)//url
            } else {
                var url = PreferenceProvider.getLastURL()
                webBlack.loadUrl(URLL)//url
            }
        }

        webBlack.webChromeClient = object : WebChromeClient(){

            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {

                val pickIntent = Intent()
                pickIntent.type = "image/*"
                pickIntent.action = Intent.ACTION_GET_CONTENT
                startActivityForResult(Intent.createChooser(pickIntent, "Select Picture"), IMG_PICK)

                return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
            }

        }

    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == Activity.RESULT_OK) {
            if (resultCode == IMG_PICK) {
                var uri = data?.extras?.get("data")
                
                uri = intent.data

                Log.e("LOL", uri.toString())
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
