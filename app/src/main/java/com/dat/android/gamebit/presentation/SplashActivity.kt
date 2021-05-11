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
import com.dat.android.gamebit.utils.URLMaker.createMonkissLanding
import com.dat.android.gamebit.utils.URLMaker.createMonkissRegF
import com.dat.android.gamebit.utils.URLMaker.createMonkissRegSimple1
import com.dat.android.gamebit.utils.URLMaker.createMonkissRegSimple2
import com.dat.android.gamebit.utils.URLMaker.createTCLanding
import com.dat.android.gamebit.utils.URLMaker.createTCRegBP
import com.dat.android.gamebit.utils.URLMaker.createTCRegF
import com.dat.android.gamebit.utils.URLMaker.createTCRegS
import com.dat.android.gamebit.utils.URLMaker.createVulLanding
import com.dat.android.gamebit.utils.URLMaker.createVulRegFast
import com.dat.android.gamebit.utils.URLMaker.createWPLanding
import com.dat.android.gamebit.utils.URLMaker.createWPRegBP
import com.dat.android.gamebit.utils.URLMaker.createWPRegFast
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {


    companion object{
        const val WELCOME_PARTNERS_LANDING = "wpl"
        const val WELCOME_PARTNERS_REG_FAST= "wprf"
        const val WELCOME_PARTNERS_REG_BONUS_PAGE = "wprb"

        const val VULKAN_LANDING = "vl"
        const val VULKAN_REG_FAST = "vrf"

        const val TRAFFIC_CAKE_LANDING = "tcl"
        const val TRAFFIC_CAKE_REG_SIMPLE = "tcrs"
        const val TRAFFIC_CAKE_REG_FAST = "tcrf"
        const val TRAFFIC_CAKE_REG_BONUS_PAGE = "tcrbp"

        const val MONKISS_LANDING = "ml"
        const val MONKISS_REG_FAST = "mrf"
        const val MONKISS_REG_SIMPLE_1 = "mrs1"
        const val MONKISS_REG_SIMPLE_2 = "mrs2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var span = SpannableString(getString(R.string.splash_title))
        span.setSpan(ForegroundColorSpan(resources.getColor(R.color.end_splash_title)), 4, span.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        tvTitle.text = span

        var url = "mrs1_[site id]_[webmaster id]_[program id]_[subid]"

        var key = url.split("_")[0]
        var outputURL = ""
        outputURL = when(key){
            WELCOME_PARTNERS_LANDING -> createWPLanding(url, "https://luckyland777.com/")
            WELCOME_PARTNERS_REG_FAST -> createWPRegFast(url, "https://mobyslot7.com/")
            WELCOME_PARTNERS_REG_BONUS_PAGE -> createWPRegBP(url,"https://mobyslot7.com/")
            VULKAN_LANDING -> createVulLanding(url, "https://vulkantop.pro/")
            VULKAN_REG_FAST -> createVulRegFast(url, "https://aff-redir.com/")
            TRAFFIC_CAKE_LANDING -> createTCLanding(url, "https://cakeglobaloffers.com/")
            TRAFFIC_CAKE_REG_SIMPLE -> createTCRegS(url, "https://sweet-slots.com/")
            TRAFFIC_CAKE_REG_FAST -> createTCRegF(url, "https://sweet-slots.com/")
            TRAFFIC_CAKE_REG_BONUS_PAGE -> createTCRegBP(url, "https://sweet-slots.com/")
            MONKISS_LANDING -> createMonkissLanding(url, "https://12monkiredirect.com/")
            MONKISS_REG_FAST -> createMonkissRegF(url, "https://777todayspin-redirect.com/")
            MONKISS_REG_SIMPLE_1 -> createMonkissRegSimple1(url, "https://777todayspin-redirect.com/")
            MONKISS_REG_SIMPLE_2 -> createMonkissRegSimple2(url, "https://777todayspin-redirect.com/")

            else -> "hui"
        }
        Log.e("LOL", outputURL)


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

