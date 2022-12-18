package com.example.guia1_2022_prueba;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import com.example.guia1_2022_prueba.utils.Utils;

public class LoginActivity extends AppCompatActivity {
    // Email
    private TextInputLayout emailTextInput;
    private TextInputEditText emailEditText;
    // Password
    private TextInputLayout passwordTextInput;
    private TextInputEditText passwordEditText;

    //CheckBox Condiciones
    private CheckBox cbCondiciones;

    // Next Button
    MaterialButton loginButton;
    MaterialButton resetButton;

    public static SharedPreferences sharedPreferences;
    public static String NAME_FILE = "configuration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        // Instancias a los componentes graficos **********************************************
        // Email
        this.emailTextInput = (TextInputLayout ) findViewById(R.id.email_text_input_layout);
        this.emailEditText = (TextInputEditText ) findViewById(R.id.email_edit_text);
        // Password
        this.passwordTextInput = (TextInputLayout ) findViewById(R.id.password_text_input_layout);
        this.passwordEditText = (TextInputEditText ) findViewById(R.id.password_edit_text);

        //CheckBox Condiciones
        cbCondiciones = (CheckBox) findViewById(R.id.cbCondiciones);

        // Login Button
        this.loginButton = (MaterialButton ) findViewById(R.id.btnLogin);
        this.resetButton = (MaterialButton) findViewById(R.id.btnReset);

        // Eventos
        // Evento Reset o Cancel
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                //startActivity(intent);
            }
        });

        // Evento Login
        loginButton.setOnClickListener( v -> {
            addUser();

            String user = sharedPreferences.getString("USER", "");
            Toast.makeText(
                    LoginActivity.this,
                    "Hello, "+user+"!",
                    Toast.LENGTH_SHORT
            ).show();
        });

    }// Termina OnCreate

    private void addUser(){
        //
        if(Utils.verifyEditText(emailEditText) && Utils.verifyEditText(passwordEditText)) {
            if (!cbCondiciones.isChecked()){
                //
                String s = "Estado: " + (cbCondiciones.isChecked() ? "Terminos y condiciones aceptados" : "Acepte terminos y condiciones");
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                cbCondiciones.requestFocus();
                return;
            }
            else{

                // Fetching the stored data
                // from the SharedPreference
                sharedPreferences = getSharedPreferences(NAME_FILE, MODE_PRIVATE);

                SharedPreferences.Editor editorConfig = sharedPreferences.edit();
                editorConfig.putString("USER", emailEditText.getText().toString());
                editorConfig.putString("PASSWD", passwordEditText.getText().toString());
                editorConfig.commit();
                Intent intent = new Intent(this, MainActivity.class);
                //Inicia Activity
                startActivity(intent);
            }

        }
    }

    // Fetch the stored data in onResume()
    // Because this is what will be called
    // when the app opens again
    @Override
    protected void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        //SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        sharedPreferences = getSharedPreferences(NAME_FILE, MODE_PRIVATE);

        String user = sharedPreferences.getString("USER", "");
        String passwd = sharedPreferences.getString("PASSWD", "");
        //int a = sh.getInt("age", 0);

        // Setting the fetched data
        // in the EditTexts
        emailEditText.setText(user);
        passwordEditText.setText(passwd);
        //age.setText(String.valueOf(a));
    }

    // Store the data in the SharedPreference
    // in the onPause() method
    // When the user closes the application
    // onPause() will be called
    // and data will be stored
    @Override
    protected void onPause() {
        super.onPause();

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        //SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        //SharedPreferences.Editor myEdit = sharedPreferences.edit();

        sharedPreferences = getSharedPreferences(NAME_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editorConfig = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        //myEdit.putString("name", name.getText().toString());
        //myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
        //myEdit.apply();

        editorConfig.putString("USER", emailEditText.getText().toString());
        editorConfig.putString("PASSWD", passwordEditText.getText().toString());
        editorConfig.apply();
    }

    void reset(){
        emailEditText.setText("");
        passwordEditText.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}