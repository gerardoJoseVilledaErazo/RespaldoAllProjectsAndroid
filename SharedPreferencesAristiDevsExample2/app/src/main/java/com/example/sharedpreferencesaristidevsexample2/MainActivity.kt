package com.example.sharedpreferencesaristidevsexample2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.example.sharedpreferencesaristidevsexample2.UserVipApplication.Companion.prefss

class MainActivity : AppCompatActivity() {
    private lateinit var btnContinue: Button
    private lateinit var etName: EditText
    private lateinit var cbVip: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnContinue = findViewById(R.id.btnContinue)
        etName = findViewById(R.id.etName)
        cbVip = findViewById(R.id.cbVip)
        initUI()
        checkUserValues()
    }

    private fun checkUserValues() {
        if (prefss.getName().isNotEmpty()) {
            goToDetail()
        }
    }

    private fun initUI() {
        btnContinue.setOnClickListener { accessToDetail() }
    }

    private fun accessToDetail() {
        if (etName.text.toString().isNotEmpty()) {
            // Guardar usuario
            prefss.saveName(etName.text.toString())
            prefss.saveVIP(cbVip.isChecked)
            goToDetail()
        } else {
        }
    }

    fun goToDetail() {
        startActivity(Intent(this, ResultActivity::class.java))
    }
}