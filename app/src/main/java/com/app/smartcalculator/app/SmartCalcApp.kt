package com.app.smartcalculator.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class SmartCalcApp: Application() {

    private var sharedPreferences: SharedPreferences? = null

    companion object {
        lateinit var instance: SmartCalcApp
        var isOpenInFailed: Boolean = false

        fun getAppInstance(): SmartCalcApp {
            return instance
        }
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        sharedPreferences = getSharedPreferences(AppConstants.PREFERENCE_NAME, Context.MODE_PRIVATE)
    }


    fun saveDarkMode(isDark: Boolean) {
        sharedPreferences?.edit()?.putBoolean(AppConstants.DARK_MODE, isDark)?.apply()
    }

    fun getDarkMode(): Boolean {
        return sharedPreferences?.getBoolean(AppConstants.DARK_MODE, false)!!
    }

    fun getViewpage(): Boolean {
        return sharedPreferences?.getBoolean(AppConstants.SAVE_PAGE, false)!!
    }

    fun saveViewPage(position: Boolean) {
        sharedPreferences?.edit()?.putBoolean(AppConstants.SAVE_PAGE, position)?.apply()
    }



}