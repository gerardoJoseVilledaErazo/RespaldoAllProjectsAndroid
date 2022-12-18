package com.example.mydbexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydbexample.adapters.CategoryAdapter;
import com.example.mydbexample.db.DB;
import com.example.mydbexample.model.Category;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DB db;
    private CategoryAdapter categoryAdapter;
    private ListView listView;
    private TextView txvIDCategoria;
    private EditText edtNombre;
    private Button btnGuardar, btnModificar, btnEliminar;
    private ArrayList<Category> lstCategoria; // Lista de datos (categoria)
    private Category categoriaTmp = null; // Sirve para manejar la eliminación

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvIDCategoria = findViewById(R.id.txv_id_categoria);
        edtNombre      = findViewById(R.id.edtCategoria);
        btnGuardar     = findViewById(R.id.btnGuardarCategoria);
        btnModificar   = findViewById(R.id.btnModificar);
        btnEliminar    = findViewById(R.id.btnEliminar);
        listView       = findViewById(R.id.lstCategoria);

        // Inicializando lista y db
        db = new DB(MainActivity.this);
        lstCategoria = db.getArrayCategoria(db.getCursorCategoria());


        if ( lstCategoria == null ) { // no hay datos
            lstCategoria = new ArrayList<>();

            categoryAdapter = new CategoryAdapter(this, lstCategoria);
            listView.setAdapter(categoryAdapter);

            // Eventos
            btnGuardar.setOnClickListener( v -> {
                guardar();
                //Toast.makeText(this, "HOLA", Toast.LENGTH_SHORT).show();
            });

            btnEliminar.setOnClickListener( v -> {
                eliminar();
            });

            btnModificar.setOnClickListener( v -> {
                // TERMINARLO
            });

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    seleccionar(lstCategoria.get(position));
                }
            });
        } 
        limpiar();
    }

    private void guardar() {
        Category categoria = new Category(txvIDCategoria.getText().toString(),edtNombre.getText().toString());
        categoriaTmp=null;
        if(db.guardar_O_ActualizarCategoria(categoria)){
            Toast.makeText(this,"Se guardo categoria",Toast.LENGTH_SHORT).show();
            // Limpiar los que existen y agregar nuevos
            lstCategoria.clear();
            lstCategoria.addAll(db.getArrayCategoria(
                    db.getCursorCategoria()
            ));

            categoryAdapter.notifyDataSetChanged();
            limpiar();
        }else{
            Toast.makeText(this,"Ocurrio un error al guardar",Toast.LENGTH_SHORT).show();
        }

    }

    private void eliminar() {
        if ( categoriaTmp != null ) {
            db.borrarCategoria(categoriaTmp.getId_categoria());
            lstCategoria.remove(categoriaTmp);
            categoryAdapter.notifyDataSetChanged();
            categoriaTmp = null;
            Toast.makeText(this, "Se eliminó la categoria", Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    private void seleccionar(Category category) {
        categoriaTmp = category;
        txvIDCategoria.setText(categoriaTmp.getId_categoria());
        edtNombre.setText(categoriaTmp.getNombre());
    }

    private void limpiar() {
        txvIDCategoria.setText(null);
        edtNombre.setText(null);
    }

}