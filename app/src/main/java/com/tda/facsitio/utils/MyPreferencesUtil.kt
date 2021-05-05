package com.tda.facsitio.utils

import android.content.Context

class MyPreferencesUtil(context: Context?) {
    companion object {
        private const val SHARED_PREFERENCE = "com.tda.facsitio.MY_SHARED_PREFERENCES"
        private const val DARK_MODE = "DARK_MODE"
        private const val TAG_FRAGMENT = "TAG_FRAGMENT"
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

    fun setTagFragment(tag: String){
        val editor = preferences.edit()
        editor.putString(TAG_FRAGMENT, tag)
        editor.apply()
    }

    fun loadTagFragment() : String?{
        return preferences.getString(TAG_FRAGMENT,"tag")
    }
}