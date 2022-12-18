package com.example.sharedpreferencesaristidevsexample2

import android.annotation.SuppressLint
import android.content.Context

class Prefss(context: Context) {
    val SHARED_NAME2 = "Mydtb"
    val SHARED_USER_NAME = "username"
    val SHARED_VIP = "vip"
    val storage = context.getSharedPreferences(SHARED_NAME2, 0)
    fun saveName(name: String) {
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun saveVIP(vip: Boolean) {
        storage.edit().putBoolean(SHARED_VIP, vip).apply()
    }

    fun getName(): String {
        return storage.getString(SHARED_USER_NAME, "")!!
    }

    fun getVIP(): Boolean {
        return storage.getBoolean(SHARED_VIP, false)
    }

    @SuppressLint("CommitPrefEdits")
    fun wipe() {
        storage.edit().clear()
    }
}