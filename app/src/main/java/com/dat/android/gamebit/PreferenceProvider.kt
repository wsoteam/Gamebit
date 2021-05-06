package com.dat.android.gamebit

import android.content.Context
import android.content.SharedPreferences

object PreferenceProvider {

    private val BACKGROUND_KEY = "BACKGROUND_KEY"
    const val BACKGROUND_GREEN = 0
    const val BACKGROUND_RED = 1
    const val BACKGROUND_BLUE = 2


    var sp: SharedPreferences = App.getInstance()
        .getSharedPreferences("", Context.MODE_PRIVATE)

    var editor = sp.edit()

    fun saveBackgroundStateSetting(state: Int) {
        editor.putInt(
            BACKGROUND_KEY, state
        )
        editor.commit()
    }

    fun getBackgroundStateSetting(): Int {
        val savedStateBackground = sp.getInt(
            BACKGROUND_KEY, BACKGROUND_GREEN
        )!!
        return savedStateBackground
    }


    private val USER_NAME_KEY = "USER_NAME_KEY"
    val DEFAULT_USER_NAME = "Unknown user"


    fun saveUserName(name: String) {
        editor.putString(
            USER_NAME_KEY, name
        )
        editor.commit()
    }

    fun getUserName(): String {
        val name = sp.getString(
            USER_NAME_KEY, DEFAULT_USER_NAME
        )!!
        return name
    }


    private val USER_SCORE_KEY = "USER_SCORE_KEY"
    val DEFAULT_USER_SCORE = 5000


    fun saveUserScore(score: Int) {
        editor.putInt(
            USER_SCORE_KEY, score
        )
        editor.commit()
    }

    fun getUserScore(): Int {
        val score = sp.getInt(
            USER_SCORE_KEY, DEFAULT_USER_SCORE
        )!!
        return score
    }

    private val SOUND_KEY = "SOUND_KEY"
    const val SOUND_1 = 0
    const val SOUND_2 = 1
    const val SOUND_3 = 2

    fun saveSoundStateSetting(sound: Int) {
        editor.putInt(
            SOUND_KEY, sound
        )
        editor.commit()
    }

    fun getSoundStateSetting(): Int {
        val savedStateSound = sp.getInt(
            SOUND_KEY, SOUND_1
        )!!
        return savedStateSound
    }

}