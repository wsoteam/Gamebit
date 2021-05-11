package com.dat.android.gamebit.presentation

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import com.dat.android.gamebit.presentation.menu.MenuActivity
import com.dat.android.gamebit.R
import com.dat.android.gamebit.utils.URLMaker
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var span = SpannableString(getString(R.string.splash_title))
        span.setSpan(ForegroundColorSpan(resources.getColor(R.color.end_splash_title)), 4, span.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        tvTitle.text = span

        var url = "wpl_[landing id]_[webmaster id]_[program id]_[subid]"
        var key = url.split("_")[0]
        when(key){
            "wpl" -> createURlWelcomePar()
        }

        intent = Intent(this@SplashActivity, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startAnim() {
        var anim = ValueAnimator.ofFloat(0f, 9000f)
        anim.duration = 9_000L
        anim.addUpdateListener {
            iv_roulette_splash_giv.rotation = it.animatedValue.toString().toFloat()
        }
        anim.start()
    }

    override fun onPostResume() {
        super.onPostResume()
    }
}

