package com.example.intentsexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonE, botonI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.botonE = (Button) findViewById(R.id.btnExplicito);
        botonE.setOnClickListener(this);

        this.botonI = (Button) findViewById(R.id.btnImplicito);
        botonI.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnExplicito:

                /// Intent Explicito
                explicito();
                break;

            case R.id.btnImplicito:

                /// Intent Implicito
                enviarSMS();
                break;
        }
    }

    public void explicito(){
        Toast.makeText(this, "Hola, este es un Intent Explicito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    /// intents implicitos
    public void abrirNavegador(){
        Toast.makeText(this, "Hola, este es un Intent Implicito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com.sv"));
        startActivity(intent);
    }
    public void abrirMapa(){
        Toast.makeText(this, "Hola, este es un Intent Implicito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-31.417, -64.183"));
        startActivity(intent);
    }
    public void abrirContactos(){
        Toast.makeText(this, "Hola, este es un Intent Implicito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
        startActivity(intent);
    }
    public void abrirCamara(){
        Toast.makeText(this, "Hola, este es un Intent Implicito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }
    public void abrirMarcadorTelefonico(){
        Toast.makeText(this, "Hola, este es un Intent Implicito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:1234567"));
        startActivity(intent);
    }
    public void enviarSMS(){
        Toast.makeText(this, "Hola, este es un Intent Implicito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("sms:1234567"));
        startActivity(intent);
    }
}