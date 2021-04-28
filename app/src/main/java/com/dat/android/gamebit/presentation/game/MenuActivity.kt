package com.dat.android.gamebit.presentation.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dat.android.gamebit.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity(R.layout.activity_menu) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        tv_button_settings_from_menu.setOnClickListener {
            var intentSetting = Intent (this@MenuActivity, SettingActivity::class.java)
            startActivity(intentSetting)
        }
    }

}