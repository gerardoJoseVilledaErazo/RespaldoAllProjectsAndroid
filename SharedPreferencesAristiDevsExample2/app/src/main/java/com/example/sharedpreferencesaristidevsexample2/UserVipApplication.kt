package com.example.sharedpreferencesaristidevsexample2

import android.app.Application

// recordar ir al manifest
class UserVipApplication : Application() {
    companion object {
        lateinit var prefss: Prefss
    }

    override fun onCreate() {
        super.onCreate()
        prefss = Prefss(applicationContext)
    }
}