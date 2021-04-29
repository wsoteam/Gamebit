package com.dat.android.gamebit.presentation.game

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dat.android.gamebit.PreferenceProvider
import com.dat.android.gamebit.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUI()

        var anim = ValueAnimator.ofFloat(0f, 5000f)
        anim.duration = 5_000L
        anim.addUpdateListener {
            ivRoulete.rotation = it.animatedValue.toString().toFloat()
        }
        anim.start()
    }

    private fun updateUI() {
        var backState = PreferenceProvider.getBackgroundStateSetting()
        when(backState){
            PreferenceProvider.BACKGROUND_BLUE -> {
                iv_background_game.setImageResource(R.drawable.gradient_splash_blue)
            }
            PreferenceProvider.BACKGROUND_GREEN -> {
                iv_background_game.setImageResource(R.drawable.gradient_splash)
            }
            PreferenceProvider.BACKGROUND_RED -> {
                iv_background_game.setImageResource(R.drawable.gradient_splash_red)
            }
        }
    }
}