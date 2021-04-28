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

}