package com.example.sharedpreferencesaristidevsexample

import android.app.Application

class UserVipApplication : Application() {
    companion object {
        lateinit var prefss: Prefss
    }

    override fun onCreate() {
        super.onCreate()
        prefss = Prefss(applicationContext)
    }
}