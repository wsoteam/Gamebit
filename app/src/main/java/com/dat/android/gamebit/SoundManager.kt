package com.dat.android.gamebit

import android.media.MediaPlayer

object SoundManager {

    private lateinit var mp: MediaPlayer
    var isStoped = true

    fun start() {
        var backStateSound = PreferenceProvider.getSoundStateSetting()
        when (backStateSound) {
            PreferenceProvider.SOUND_1 -> {
                mp = MediaPlayer.create(App.getInstance().applicationContext, R.raw.kaz)
            }
            PreferenceProvider.SOUND_2 -> {
                mp = MediaPlayer.create(App.getInstance().applicationContext, R.raw.kaz2)
            }
            PreferenceProvider.SOUND_3 -> {
                mp = MediaPlayer.create(App.getInstance().applicationContext, R.raw.kaz3)
            }
        }
        mp.isLooping = true
        mp.start()
        isStoped = false
    }

    fun stop() {
        isStoped = true
        mp.stop()
    }
}