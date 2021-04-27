package com.dat.android.gamebit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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