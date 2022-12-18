package com.example.sharedpreferencesaristidevsexample

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {
    val PREFS_NAME = "com.cursokotlin.sharedpreferences"
    val SHARED_NAME = "shared_name"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var name: String?
        get() = prefs.getString(SHARED_NAME, "")
        set(value) = prefs.edit().putString(SHARED_NAME, value).apply()
}

//class Prefs(context: Context) {
//    val SHARED_NAME = "Mydtb"
//    val SHARED_USER_NAME = "username"
//    val SHARED_VIP = "vip"
//    val storage = context.getSharedPreferences(SHARED_NAME, 0)
//    fun saveName(name: String) {
//        storage.edit().putString(SHARED_USER_NAME, name).apply()
//    }
//
//    fun saveVIP(vip: Boolean) {
//        storage.edit().putBoolean(SHARED_VIP, vip).apply()
//    }
//
//    fun getName(): String {
//        return storage.getString(SHARED_USER_NAME, "")!!
//    }
//
//    fun getVIP(): Boolean {
//        return storage.getBoolean(SHARED_VIP, false)
//    }
//
//    @SuppressLint("CommitPrefEdits")
//    fun wipe() {
//        storage.edit().clear()
//    }
//}