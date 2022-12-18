package com.example.mydb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mydb.R;
import com.example.mydb.model.Category;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(Context context, List<Category> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obteniendo el dato
        Category category = getItem(position);
        // inicializando el layout correspondiente al item (Categoria)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext() ).inflate(R.layout.item_category, parent, false);
        }
        TextView txvCategoria = convertView.findViewById(R.id.txvIDCategoria);
        TextView txvNombreCate = convertView.findViewById(R.id.txvNombreCategoria);
        // mostrar los datos
        txvCategoria.setText(category.getId_categoria() );
        txvNombreCate.setText(category.getNombre() );
        // Return la convertView ya con los datos
        return convertView;
    }
    //Irnos al mainActivity
}
