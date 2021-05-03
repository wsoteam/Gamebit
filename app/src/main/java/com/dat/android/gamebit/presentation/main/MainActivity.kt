package com.dat.android.gamebit.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dat.android.gamebit.PreferenceProvider
import com.dat.android.gamebit.R
import com.dat.android.gamebit.presentation.highscore.HighscoresActivity
import com.dat.android.gamebit.presentation.main.dialogs.FragmentDialogDefeat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUI()
        bindSpinners()

        iv_show_highscoresActivity.setOnClickListener {
            var intentHigh = Intent(this@MainActivity, HighscoresActivity::class.java)
            startActivity(intentHigh)
        }

        /*tv_button_play.setOnClickListener {
            var dialogDefeat = FragmentDialogDefeat()
            dialogDefeat.show(supportFragmentManager, "customDialog")
        }*/ // диалог


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