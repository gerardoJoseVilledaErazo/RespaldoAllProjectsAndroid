package com.example.sharedpreferencesaristidevsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.sharedpreferencesaristidevsexample.UserVipApplication.Companion.prefss

class ResultActivity : AppCompatActivity() {
    private lateinit var btnBack: Button
    private lateinit var tvName2: TextView
    private lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        btnBack = findViewById(R.id.btnBack)
        tvName2 = findViewById(R.id.tvName2)
        container = findViewById(R.id.container)
        initUI()
    }

    fun initUI() {
        btnBack.setOnClickListener {
            prefss.wipe()
            onBackPressed()
        }
        val userName = prefss.getName()
        tvName2.text = "Bienvenido $userName"
        if (prefss.getVIP()) {
            setVIPColorBackground()
        }
    }

    fun setVIPColorBackground() {
        container.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.purple_200
            )
        )
    }
}