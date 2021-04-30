package com.dat.android.gamebit.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.dat.android.gamebit.presentation.game.MenuActivity
import com.dat.android.gamebit.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var span = SpannableString(getString(R.string.splash_title))
        span.setSpan(ForegroundColorSpan(resources.getColor(R.color.end_splash_title)), 4, span.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        tvTitle.text = span

        intent = Intent(this@SplashActivity, MenuActivity::class.java)
        startActivity(intent)
    }

}