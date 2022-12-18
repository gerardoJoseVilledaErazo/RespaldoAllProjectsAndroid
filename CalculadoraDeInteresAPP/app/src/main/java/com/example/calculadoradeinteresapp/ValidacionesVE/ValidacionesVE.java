package com.example.calculadoradeinteresapp.ValidacionesVE;

import android.widget.EditText;

public class ValidacionesVE {

    // Metodo para Validar si EditText Monto se encuentra vacio
    public static boolean esEditTextVacio(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setError("Campo requerido.");
            editText.requestFocus();
            return false;
        }
        return true;
    }
    // Metodo para Validar si un EditText Porcentaje se encuentra vacio y rango: 0-100%
    public static boolean esEditTextVacioPorcentaje(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setError("Campo requerido.");
            editText.requestFocus();
            return false;
        } else if (!esPorcentaje(editText)) {
            editText.setError("Porcentaje indebido.");
            editText.requestFocus();
            return false;
        }
        return true;
    }

    // Metodo para Validar rango 0-100%
    public static boolean esPorcentaje(EditText editText) {
        if (Double.parseDouble(editText.getText().toString())<=100 && Double.parseDouble(editText.getText().toString())>=0) {
            return true;
        } else {
            editText.setError("Porcentaje indebido.");
            editText.requestFocus();
            return false;
        }
    }
}
