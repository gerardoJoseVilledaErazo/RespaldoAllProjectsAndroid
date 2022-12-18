package com.example.kotlinagendatelefonicave

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /// User Name
    private lateinit var userNameEditText: EditText
    /// Phone Number
    private lateinit var phoneNumberEditText: EditText

    /// Botones
    private lateinit var next_button: Button
    private lateinit var cancel_button: Button

    //SharedPreferences
    lateinit var sharedPreferences:SharedPreferences
    var NAME_FILE:String="configuration"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// User name
        userNameEditText = findViewById(R.id.user_name_edit_text)
        /// Phone  Number
        phoneNumberEditText = findViewById(R.id.phone_number_edit_text)

        /// Botones
        next_button = findViewById(R.id.next_button)
        cancel_button = findViewById(R.id.cancel_button)

        next_button.setOnClickListener(this)
        cancel_button.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id)
        {
            R.id.next_button ->
            {
                this.addUser()
                // Ir a lista de contactos
//                startActivity(Intent(this.applicationContext, MostrarListaContactoVE::class.java))
//                startActivity(Intent(this, MostrarListadoContactosVeTextViewActivity::class.java)
//                )
            }
            R.id.cancel_button ->
            {
                //Al dar clic en el botón “Cancelar”
                // debe borrar el texto o valor de todos los componentes.
                userNameEditText.setText("");
                phoneNumberEditText.setText("");
            }
        }
    }

    private fun addUser()
    {
        if (verifyTextPersonName(userNameEditText) && verifyEmpty(phoneNumberEditText)) {

            sharedPreferences = getSharedPreferences(NAME_FILE, MODE_PRIVATE)
            val editorConfig: SharedPreferences.Editor = sharedPreferences.edit()

            // write all the data entered by the user in SharedPreference and apply
            editorConfig.putString("USER", userNameEditText.text.toString())
            editorConfig.putString("PHN", phoneNumberEditText.text.toString())
            editorConfig.apply() /// se cambio commit por apply*************************************************

            // Ir a lista de contactos
            startActivity(Intent(this.applicationContext, MostrarListaContactoVE::class.java))
            val user: String? = sharedPreferences.getString("USER","")
            Toast.makeText(this.applicationContext, "Hello $user!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyTextPersonName(editText: EditText): Boolean {
        if (editText.text.toString().isEmpty()){
            editText.error = "Required field"
            editText.requestFocus()
            return false
        } else if (!verifyChars(editText)) {
            editText.error = "Just letters are allowed"
            editText.requestFocus()
            return false
        }
        return true

    }

    private fun verifyChars(editText: EditText): Boolean
    {
        //Validamos solo caracteres Expresion regular
//        Pattern.compile("^[a-zA-Z ]+$").matcher(editText.text.toString()).matches()

        return Pattern.compile("^[a-zA-Z ]+$").matcher(editText.text.toString()).matches()
    }
    private fun verifyEmpty(editText: EditText): Boolean
    {
        if (editText.text.toString().isEmpty()){
            editText.error = "Required field"
            editText.requestFocus()
            return false
        }
        return true
    }

    // Fetch the stored data in onResume()
    // Because this is what will be called
    // when the app opens again
    override fun onResume() {
        super.onResume()

        // Fetching the stored data
        // from the SharedPreference

        sharedPreferences = getSharedPreferences(NAME_FILE, MODE_PRIVATE)

        val user: String? =sharedPreferences.getString("USER", "")
        val phn: String? =sharedPreferences.getString("PHN", "")

        // Setting the fetched data
        // in the EditTexts
        userNameEditText.setText(user)
        phoneNumberEditText.setText(phn)
    }

    // Store the data in the SharedPreference
    // in the onPause() method
    // When the user closes the application
    // onPause() will be called
    // and data will be stored
    override fun onPause() {
        super.onPause()

        // Creating a shared pref object
        // with a file name "configuration"
        // in private mode

        sharedPreferences = getSharedPreferences(NAME_FILE, MODE_PRIVATE)
        val editorConfig: SharedPreferences.Editor = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreference and apply
        editorConfig.putString("USER", userNameEditText.text.toString())
        editorConfig.putString("PHN", phoneNumberEditText.text.toString())
        editorConfig.apply()
    }
}