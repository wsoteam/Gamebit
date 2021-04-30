package com.dat.android.gamebit.presentation.game

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.dat.android.gamebit.PreferenceProvider
import com.dat.android.gamebit.R
import com.shawnlin.numberpicker.NumberPicker
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.String

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
        bindSpinners()
    }

    private fun bindSpinners() {
        val data =
            arrayOf("$50", "$100", "$200", "$300", "$400", "$500", "$1000", "$1500", "$2000")
        npBet.minValue = 1
        npBet.maxValue = data.size
        npBet.displayedValues = data
        npBet.value = 3
        /// "kek,lol,kek,kek" -- split --> array("kek", "lol", "kek", "kek") --> array[1] == "lol"
        /// "$50" -- split("$") --- array( "", "50") --- array[1].toInt

        var value = data[0].split("$")[1].toInt()
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