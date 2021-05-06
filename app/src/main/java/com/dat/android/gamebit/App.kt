package com.dat.android.gamebit

import android.app.Activity
import android.app.Application
import android.os.Bundle

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        sInstance = this
    }



    companion object {

        private lateinit var sInstance: App

        fun getInstance(): App {
            return sInstance
        }
    }

}