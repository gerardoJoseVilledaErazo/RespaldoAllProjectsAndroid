package com.example.registroapp_p3_prtl1_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registroapp_p3_prtl1_2021.UtilsVE.UtilsVE;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre, edtGenero, edtEdad, edtDireccion;
    private CheckBox chbTerminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ******************* Instancias a los componentes graficos *********************
        this.edtNombre = (EditText) findViewById(R.id.edtNombre);
        this.edtGenero = (EditText) findViewById(R.id.edtGenero);
        this.edtEdad = (EditText) findViewById(R.id.edtEdad);
        this.edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        this.chbTerminos = (CheckBox) findViewById(R.id.checkBox);
    }

    /**
     * Al dar clic en el botón “Cancelar”
     * Debe borrar el texto o valor de todos los componentes del formulario.
     */
    public void Cancelar(View view){
        edtNombre.setText("");
        edtGenero.setText("");
        edtEdad.setText("");
        edtDireccion.setText("");
    }

    /**
     * Al dar clic en el botón “Registrar”
     * Debe validar el valor del campo "Edad", y si es mayor a 18,
     * Mostrar un mensaje con mayusculas "BIENVENIDO NOMBRE (el valor del campo "Nombre")",
     * De lo contrario mostrar un mensaje en rojo "Usted es menor de edad, no se puede registrar".
     */
    public void Registrar(View view){
        String s = "Estado: " + (chbTerminos.isChecked() ? "Marcado" : "No Marcado");
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

        if (UtilsVE.verifyEditTextNombre(edtNombre) &&
                UtilsVE.verifyEditText(edtGenero) &&
                UtilsVE.verifyEditText(edtEdad) &&
                UtilsVE.verifyEditText(edtDireccion) &&
                UtilsVE.verifyCheckBox(chbTerminos)
        ){
            Toast.makeText(this,"Formulario completo!",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getBaseContext(), ValidacionActivity.class);
            // Envio de parametros a otra vista
            String nombre = edtNombre.getText().toString();
            int edad = Integer.parseInt(String.valueOf(edtEdad.getText()));
            Bundle bundle = new Bundle();
            bundle.putString("NOMBRE",nombre);
            bundle.putInt("EDAD",edad);
            // Agrega el objeto bundle a el Intent
            intent.putExtras(bundle);
            // Inicia Activity
            startActivity(intent);
        }
    }
}