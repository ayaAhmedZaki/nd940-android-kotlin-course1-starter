package com.udacity.shoestore

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

object Prefs {


    const val LOGGING = "logging"
    private var prefs: SharedPreferences? = null

    fun getPrefsInstance(ctx: Context): SharedPreferences {
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(ctx)
        }
        return prefs!!
    }

    fun setBoolean(ctx: Context){
        val sp = getPrefsInstance(ctx)
        sp.edit().putBoolean(LOGGING,true).commit()
    }



}