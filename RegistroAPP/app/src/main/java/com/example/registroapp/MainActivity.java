package com.example.registroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_direccion,et_dui,et_fecha_nacimiento;
    private Spinner spinner_genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText)findViewById(R.id.txt_nombre);
        et_direccion = (EditText)findViewById(R.id.txt_direccion);
        et_dui = (EditText)findViewById(R.id.txt_dui);
        et_fecha_nacimiento = (EditText)findViewById(R.id.txt_fecha_nacimiento);
        spinner_genero = (Spinner)findViewById(R.id.spinner_genero);
        // Crear arreglo o vector que nos permita agregar todos los textos al spinner
        String [] opciones = { "Masculino" , "Femenino" , "Otro" } ;

        // Adaptador para comunicar a spinner
        ArrayAdapter<String> adapter = new ArrayAdapter <String> (this , R.layout.spinner_item_gerardo , opciones ) ;
        spinner_genero.setAdapter ( adapter ) ;

        TextWatcher tw = new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            // Cuando el usuario cambia el texto del EditText

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]", "");
                    String cleanC = current.replaceAll("[^\\d.]", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    }else{
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day  = Integer.parseInt(clean.substring(0,2));
                        int mon  = Integer.parseInt(clean.substring(2,4));
                        int year = Integer.parseInt(clean.substring(4,8));

                        if(mon > 12) mon = 12;
                        cal.set(Calendar.MONTH, mon-1);
                        year = (year<1900)?1900:(year>2100)?2100:year;
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE))? cal.getActualMaximum(Calendar.DATE):day;
                        clean = String.format("%02d%02d%02d",day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    et_fecha_nacimiento.setText(current);
                    et_fecha_nacimiento.setSelection(sel < current.length() ? sel : current.length());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };


        et_fecha_nacimiento.addTextChangedListener(tw);

    }

    // Metodo para el boton enviar
    public void Enviar(View view){
        Intent i = new Intent(this, CapturaActivity.class);
        Bundle b = new Bundle();
        b.putString("nombre", et_nombre.getText().toString());
        b.putString("direccion", et_direccion.getText().toString());
        b.putString("dui", et_dui.getText().toString());
        b.putString("fecha_nacimiento", et_fecha_nacimiento.getText().toString());
        i.putExtra("genero", spinner_genero.getSelectedItem().toString());

//        String seleccion = spinner_genero.getSelectedItem().toString();
//        if (seleccion.equals("Masculino")) {
//            i.putExtra("genero_masculino", spinner_genero.getSelectedItem().toString());
//
//        } else if (seleccion.equals("Femenino")) {
//            i.putExtra("genero_femenino", spinner_genero.getSelectedItem().toString());
//
//        } else if (seleccion.equals("Otro")) {
//            i.putExtra("genero_otro", spinner_genero.getSelectedItem().toString());
//
//        }
        i.putExtras(b);
        startActivity(i);
    }

    // Metodo para el boton cancelar
    public void Cancelar(View view){
        et_nombre.setText("");
        et_direccion.setText("");
        et_dui.setText("");
        et_fecha_nacimiento.setText("");
    }
}