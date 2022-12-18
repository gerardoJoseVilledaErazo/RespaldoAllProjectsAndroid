package com.example.sharedpreferencesaristidevsexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.example.sharedpreferencesaristidevsexample.UserVipApplication.Companion.prefss

class MainActivity2 : AppCompatActivity() {
    private lateinit var tvName2: TextView
    private lateinit var btnContinue: Button
    private lateinit var etName2: EditText
    private lateinit var cbVip: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btnContinue = findViewById(R.id.btnContinue)
        etName2 = findViewById(R.id.etName2)
        tvName2 = findViewById(R.id.tvName2)
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
        if (etName2.text.toString().isNotEmpty()) {
            // Guardar usuario
            prefss.saveName(etName2.text.toString())
            prefss.saveVIP(cbVip.isChecked)
            goToDetail()
        } else {
        }
    }

    fun goToDetail() {
        startActivity(Intent(this, ResultActivity::class.java))
    }
}