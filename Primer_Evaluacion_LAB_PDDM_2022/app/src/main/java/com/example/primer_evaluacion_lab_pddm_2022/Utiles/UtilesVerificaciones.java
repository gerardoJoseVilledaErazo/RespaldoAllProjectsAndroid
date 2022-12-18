package com.example.primer_evaluacion_lab_pddm_2022.Utiles;

import android.content.Context;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.primer_evaluacion_lab_pddm_2022.SolicitarDatosActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilesVerificaciones {

    public static boolean verificaVacio(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setError("Este campo es requerido.");
            editText.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean estaCheckeado(RadioGroup radioGroup) {
        int id=radioGroup.getCheckedRadioButtonId();
        if (id>0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean verificaTextPersonName(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setError("Este campo es requerido.");
            editText.requestFocus();
            return false;
        } else if (!verificaChars(editText)) {
            editText.setError("Solo se permiten letras.");
            editText.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean verificaChars(EditText editText) {
        //Validamos solo caracteres Expresion regular
        Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
        Matcher ms = ps.matcher(editText.getText().toString());
        boolean bs = ms.matches();
        return bs;
    }
}
