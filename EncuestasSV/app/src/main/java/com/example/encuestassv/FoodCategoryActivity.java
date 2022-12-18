package com.example.encuestassv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FoodCategoryActivity extends AppCompatActivity {
    String name,gender;
    int edad;
    RadioButton rbMeat,rbSalad,rbFruit,rbCategory;
    RadioGroup rgFoodCategory;
    TextView tvChooseCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rgFoodCategory = (RadioGroup) findViewById(R.id.rgFoodCategory);
        name = getIntent().getExtras().getString("NAME");
        gender= getIntent().getExtras().getString("GENDER");
        edad = getIntent().getExtras().getInt("EDAD");
        rbMeat = (RadioButton) findViewById(R.id.rbMeat);
        rbSalad = (RadioButton) findViewById(R.id.rbSalad);
        rbFruit = (RadioButton) findViewById(R.id.rbFruit);
        tvChooseCategory = (TextView) findViewById(R.id.tvChooseCategory);
        tvChooseCategory.setText(name + ", Elige una categoria de comida.");

    }

    public void FoodNext(View view){

        int id = rgFoodCategory.getCheckedRadioButtonId();
        rbCategory = (RadioButton) findViewById(id);

        if(rgFoodCategory.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(), "Por favor seleccione una opcion",
                    Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, FoodListActivity.class);

            Bundle extras = new Bundle();
            extras.putString("NAME",name);
            extras.putString("GENDER",gender);
            extras.putInt("EDAD", edad);
            extras.putString("CATEGORY",rbCategory.getText().toString());
            //Agrega el objeto bundle a el Intent
            intent.putExtras(extras);
            //Inicia Activity
            startActivity(intent);
        }

        //MANERA ALTERNATIVA
        /*if(rbMeat.isChecked() || rbSalad.isChecked()
                || rbFruit.isChecked() ){

            if(rbMeat.isChecked() ){
                Toast.makeText(this,"Lista de carnes!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MeatListActivity.class);
                Bundle extras = new Bundle();
                extras.putString("NAME",name);
                extras.putString("GENDER",gender);
                extras.putInt("EDAD", edad);
                extras.putString("CATEGORY",rbCategory.getText().toString());
                //Agrega el objeto bundle a el Intent
                intent.putExtras(extras);
                //Inicia Activity
                startActivity(intent);
            }else{
                if(rbSalad.isChecked() ){
                    Toast.makeText(this,"Lista de ensaladas!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, SaladListActivity.class);
                    Bundle extras = new Bundle();
                    extras.putString("NAME",name);
                    extras.putString("GENDER",gender);
                    extras.putInt("EDAD", edad);
                    extras.putString("CATEGORY",rbCategory.getText().toString());
                    //Agrega el objeto bundle a el Intent
                    intent.putExtras(extras);
                    //Inicia Activity
                    startActivity(intent);
                }else{
                    if(rbFruit.isChecked() ){
                        //
                        Toast.makeText(this,"Lista de frutas!",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(this, FruitListActivity.class);
                        Bundle extras = new Bundle();
                        extras.putString("NAME",name);
                        extras.putString("GENDER",gender);
                        extras.putInt("EDAD", edad);
                        extras.putString("CATEGORY",rbCategory.getText().toString());
                        //Agrega el objeto bundle a el Intent
                        intent.putExtras(extras);
                        //Inicia Activity
                        startActivity(intent);
                    }
                }
            }
        }else{
            Toast.makeText(getApplicationContext(), "Por favor seleccione una opcion", Toast.LENGTH_LONG).show();
            //rbMeat.requestFocus();
            //return;
        }*/
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}