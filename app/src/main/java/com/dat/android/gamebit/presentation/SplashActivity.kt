package com.dat.android.gamebit.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dat.android.gamebit.presentation.game.MenuActivity
import com.dat.android.gamebit.R

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent = Intent(this@SplashActivity, MenuActivity::class.java)
        startActivity(intent)
    }

}