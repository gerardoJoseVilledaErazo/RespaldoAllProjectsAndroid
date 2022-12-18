package com.example.sharedpreferencesaristidevsexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val EMPTY_VALUE = ""
    private lateinit var tvName: TextView

    //    private lateinit var btnContinue: Button
    private lateinit var btnDeleteValue: Button
    private lateinit var btnSaveValue: Button
    private lateinit var etName: EditText
//    private lateinit var cbVip: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        btnContinue = findViewById(R.id.btnContinue)
        btnDeleteValue = findViewById(R.id.btnDeleteValue)
        btnSaveValue = findViewById(R.id.btnSaveValue)
        etName = findViewById(R.id.etName)
        tvName = findViewById(R.id.tvName)
//        cbVip = findViewById(R.id.cbVip)
        configView()
        btnSaveValue.setOnClickListener {
            SharedApp.prefs.name = etName.text.toString()
            configView()
        }
        btnDeleteValue.setOnClickListener {
            SharedApp.prefs.name = EMPTY_VALUE
            configView()
        }
//        initUI()
//        checkUserValues()
    }

    private fun configView() {
        if (isSavedName()) showProfile() else showGuest()
    }

    private fun showGuest() {
        tvName.visibility = View.INVISIBLE
        btnDeleteValue.visibility = View.INVISIBLE
        etName.visibility = View.VISIBLE
        btnSaveValue.visibility = View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    private fun showProfile() {
        tvName.visibility = View.VISIBLE
        tvName.text = "Hola ${SharedApp.prefs.name}"
        btnDeleteValue.visibility = View.VISIBLE
        etName.visibility = View.INVISIBLE
        btnSaveValue.visibility = View.INVISIBLE
    }

    private fun isSavedName(): Boolean {
        val myName = SharedApp.prefs.name
        return myName != EMPTY_VALUE

    }

//    private fun checkUserValues() {
//        if (prefs.getName().isNotEmpty()) {
//            goToDetail()
//        }
//    }

//    private fun initUI() {
//        btnContinue.setOnClickListener { accessToDetail() }
//    }

//    private fun accessToDetail() {
//        if (etName.text.toString().isNotEmpty()) {
//            // Guardar usuario
//            prefs.saveName(etName.text.toString())
//            prefs.saveVIP(cbVip.isChecked)
//            goToDetail()
//        } else {
//        }
//    }

//    fun goToDetail() {
//        startActivity(Intent(this, ResultActivity::class.java))
//    }
}