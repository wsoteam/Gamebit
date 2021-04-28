package com.dat.android.gamebit.presentation.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dat.android.gamebit.PreferenceProvider
import com.dat.android.gamebit.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity(R.layout.activity_menu) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUI()



        tv_button_settings_from_menu.setOnClickListener {
            var intentSetting = Intent (this@MenuActivity, SettingActivity::class.java)
            startActivity(intentSetting)
            finish()
        }
    }
    private fun updateUI() {
        var backState = PreferenceProvider.getBackgroundStateSetting()
        when(backState){
            PreferenceProvider.BACKGROUND_BLUE -> {
                iv_background_menu.setImageResource(R.drawable.gradient_splash_blue)
            }
            PreferenceProvider.BACKGROUND_GREEN -> {
                iv_background_menu.setImageResource(R.drawable.gradient_splash)
            }
            PreferenceProvider.BACKGROUND_RED -> {
                iv_background_menu.setImageResource(R.drawable.gradient_splash_red)
            }
        }
    }
}