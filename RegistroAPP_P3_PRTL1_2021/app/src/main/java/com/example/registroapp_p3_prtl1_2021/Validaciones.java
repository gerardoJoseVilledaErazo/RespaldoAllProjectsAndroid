package com.example.registroapp_p3_prtl1_2021;

import android.text.TextUtils;
import android.widget.EditText;

public class Validaciones {

    // Metodo para Validar si un EditText se encuentra vacio
    public boolean Vacio(EditText campo){
        String dato = campo.getText().toString().trim();
        if (TextUtils.isEmpty(dato)){
            campo.setError("Campo Requerido");
            campo.requestFocus();
            return true;
        } else {
            return false;
        }
    }
}
