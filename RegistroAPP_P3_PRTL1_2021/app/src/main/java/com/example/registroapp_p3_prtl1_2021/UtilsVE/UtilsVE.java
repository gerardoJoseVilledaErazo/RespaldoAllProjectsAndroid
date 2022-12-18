package com.example.registroapp_p3_prtl1_2021.UtilsVE;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registroapp_p3_prtl1_2021.MainActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsVE {

    public static boolean verifyEditTextNombre(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setError("Este campo es requerido.");
            editText.requestFocus();
            return false;
        } else if (!verifyChars(editText)) {
            editText.setError("Solo se permiten letras.");
            editText.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean verifyEditText(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setError("Este campo es requerido.");
            editText.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean verifyCheckBox(CheckBox checkBox){
        if (!checkBox.isChecked()){
            checkBox.setError("Acepte terminos y condiciones.");
            checkBox.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean verifyChars(EditText editText) {
        //Validamos solo caracteres Expresion regular
        Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
        Matcher ms = ps.matcher(editText.getText().toString());
        boolean bs = ms.matches();
        return bs;
    }
}
