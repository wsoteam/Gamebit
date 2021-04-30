package com.dat.android.gamebit.presentation.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dat.android.gamebit.PreferenceProvider
import com.dat.android.gamebit.R
import com.dat.android.gamebit.presentation.menu.MenuActivity
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity(R.layout.activity_setting) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindBackgroundViews()
        updateUI()
        backToMenu()
    }

    private fun backToMenu() {
        iv_back_menu_from_setting.setOnClickListener {
            intent = Intent(this@SettingActivity, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

     private fun updateUI() {
        var backState = PreferenceProvider.getBackgroundStateSetting()
        when(backState){
            PreferenceProvider.BACKGROUND_BLUE -> {
                setBlueCheckbox()
                setBackgroundBlue()
            }
            PreferenceProvider.BACKGROUND_GREEN -> {
                setGreenCheckbox()
                setBackgroundGreen()
            }
            PreferenceProvider.BACKGROUND_RED -> {
                setRedCheckbox()
                setBackgroundRed()
            }
        }
    }


    private fun bindBackgroundViews() {
        ctv_background_green.setOnClickListener {
            setGreenCheckbox()
            setBackgroundGreen()

            PreferenceProvider.saveBackgroundStateSetting(
                PreferenceProvider.BACKGROUND_GREEN)
        }

        ctv_background_red.setOnClickListener {
            setRedCheckbox()
            setBackgroundRed()

            PreferenceProvider.saveBackgroundStateSetting(
                PreferenceProvider.BACKGROUND_RED)
        }

        ctv_background_blue.setOnClickListener {
            setBlueCheckbox()
            setBackgroundBlue()

            PreferenceProvider.saveBackgroundStateSetting(
                PreferenceProvider.BACKGROUND_BLUE)
        }
    }

    private fun setBlueCheckbox() {
        ctv_background_red.isChecked = false
        ctv_background_blue.isChecked = true
        ctv_background_green.isChecked = false
    }
    private fun setGreenCheckbox() {
        ctv_background_green.isChecked = true
        ctv_background_red.isChecked = false
        ctv_background_blue.isChecked = false

    }
    private fun setRedCheckbox() {
        ctv_background_green.isChecked = false
        ctv_background_red.isChecked = true
        ctv_background_blue.isChecked = false
    }

    private fun setBackgroundGreen() {
        sv_color_setting.setBackgroundResource(R.drawable.gradient_splash)
        tv_line_settings_background.setBackgroundResource(R.drawable.ic_line_green_setting)
        tv_line_settings_sound.setBackgroundResource(R.drawable.ic_line_green_setting)
    }
    private fun setBackgroundRed() {
        sv_color_setting.setBackgroundResource(R.drawable.gradient_splash_red)
        tv_line_settings_background.setBackgroundResource(R.drawable.ic_line_setting_red)
        tv_line_settings_sound.setBackgroundResource(R.drawable.ic_line_setting_red)
    }
    private fun setBackgroundBlue() {
        sv_color_setting.setBackgroundResource(R.drawable.gradient_splash_blue)
        tv_line_settings_background.setBackgroundResource(R.drawable.ic_line_setting_blue)
        tv_line_settings_sound.setBackgroundResource(R.drawable.ic_line_setting_blue)
    }
}

