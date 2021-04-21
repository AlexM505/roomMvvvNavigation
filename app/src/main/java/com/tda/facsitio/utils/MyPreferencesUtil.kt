package com.tda.facsitio.utils

import android.content.Context

class MyPreferencesUtil(context: Context?) {
    companion object {
        private const val DARK_MODE = "DARK_MODE"
        private const val SHARED_PREFERENCE = "com.tda.facsitio.MY_SHARED_PREFERENCES"
    }

    private val preferences = context!!.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)

    fun setDarkModeState(state: Boolean?){
        val editor = preferences.edit()
        editor.putBoolean(DARK_MODE,state!!)
        editor.apply()
    }

    fun loadDarkModeState(): Boolean {
        return preferences.getBoolean(DARK_MODE,false)
    }
}