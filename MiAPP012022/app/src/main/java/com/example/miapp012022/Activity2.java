package com.example.miapp012022;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miapp012022.util.Datos;

public class Activity2 extends AppCompatActivity {

    TextView txtNombre;
    Button btnEnviar;
    Button btnCalculo;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @SuppressLint("ResourceAsColor")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //INCIALIZAR INSTANCIAS DE COMPONENTES GRAFICOS
        txtNombre=(TextView) findViewById(R.id.txtNombre);  // devuelve instancias de VIEW(botnes, textos,....)
        btnEnviar=(Button) findViewById(R.id.btnEnviar);
        btnCalculo=(Button) findViewById(R.id.btnCalculo);


        /*Explicaticvo*/
       /* Pila<String> obj=new Pila<String>();

        obj.guardar("Texto1");
        obj.guardar("Texto2");


        Pila<Persona> obj2=new Pila<Persona>();

        Persona p1=new Persona();
        p1.setNombre("Juan Perez");

        obj2.guardar(p1);*/



        //manipular attibutos o propiedades

        //manipulando el componentre grafico -VIEW- TextView
        txtNombre.setTextColor(R.color.purple_700);

        //obteniendo propiedad de texto
        String nombre= txtNombre.getText().toString();

        //asociar o crear evento para un componente especifico
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Bienvenido "+txtNombre.getText()+" !!", Toast.LENGTH_LONG).show();
            }
        });

        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //se crea intent para hacer abrir la activity
                Intent intent= new Intent(getBaseContext(),CalculoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // reciente.
                getBaseContext().startActivity(intent);
            }
        });
    }


    //evento click  asociado por dependencia de elmento VIEW
    public  void saludo(View view){
        //notificaciones
        //Datos obj1=new Datos();
        String s= Datos.texto;
        Toast.makeText(this, "Hola Mundo desde una notificacion, "+s, Toast.LENGTH_SHORT).show();

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}