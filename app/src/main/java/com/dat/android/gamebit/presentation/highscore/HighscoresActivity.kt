package com.dat.android.gamebit.presentation.highscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dat.android.gamebit.PreferenceProvider
import com.dat.android.gamebit.R
import com.dat.android.gamebit.presentation.main.dialogs.FragmentDialogWin
import com.dat.android.gamebit.presentation.menu.MenuActivity
import kotlinx.android.synthetic.main.activity_highscores.*

class HighscoresActivity : AppCompatActivity(R.layout.activity_highscores) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUI()


        iv_back_menu_from_highscores.setOnClickListener {
            onBackPressed()
        }
    }

    private fun updateUI() {
        var backState = PreferenceProvider.getBackgroundStateSetting()
        when(backState){
            PreferenceProvider.BACKGROUND_BLUE -> {
                setBackgroundBlue()
            }
            PreferenceProvider.BACKGROUND_GREEN -> {
                setBackgroundGreen()
            }
            PreferenceProvider.BACKGROUND_RED -> {
                setBackgroundRed()
            }
        }
    }
    private fun setBackgroundGreen() {
        fl_background_highscores.setBackgroundResource(R.drawable.gradient_splash)
        fl_highscores_color_line_1.setBackgroundResource(R.drawable.ic_line_green_setting)
        fl_highscores_color_line_2.setBackgroundResource(R.drawable.ic_line_green_setting)
    }
    private fun setBackgroundRed() {
        fl_background_highscores.setBackgroundResource(R.drawable.gradient_splash_red)
        fl_highscores_color_line_1.setBackgroundResource(R.drawable.ic_line_setting_red)
        fl_highscores_color_line_2.setBackgroundResource(R.drawable.ic_line_setting_red)
    }
    private fun setBackgroundBlue() {
        fl_background_highscores.setBackgroundResource(R.drawable.gradient_splash_blue)
        fl_highscores_color_line_1.setBackgroundResource(R.drawable.ic_line_setting_blue)
        fl_highscores_color_line_2.setBackgroundResource(R.drawable.ic_line_setting_blue)
    }

}