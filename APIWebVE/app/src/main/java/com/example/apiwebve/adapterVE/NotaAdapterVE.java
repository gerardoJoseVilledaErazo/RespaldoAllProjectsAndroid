package com.example.apiwebve.adapterVE;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiwebve.NewVE_NotaActivity;
import com.example.apiwebve.R;
import com.example.apiwebve.daoVE.NotaDaoVE;
import com.example.apiwebve.modelVE.NotaVE;

import java.util.List;

public class NotaAdapterVE extends RecyclerView.Adapter<NotaAdapterVE.ViewHolder> {

    List<NotaVE> notas;
    Context context; // Para saber de donde viene la llamada de esa accion
    NotaDaoVE daoVE;

    //constructor del adapter
    public NotaAdapterVE(List<NotaVE> notas, Context context, NotaDaoVE daoVE) {
        this.notas = notas;
        this.context = context;
        this.daoVE = daoVE;
    }

    // Manipulacion de vista(xml)
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtId;
        TextView txtTitulo;
        TextView txtDescripcion;
        TextView txtFecha;
        TextView txtUsuario;
        Button btnModificar;
        Button btnEliminar;
        Context context;

        public ViewHolder(/*@NonNull @org.jetbrains.annotations.NotNull*/
                View itemView,
                Context context
        ) {
            super(itemView);

            txtId=(TextView) itemView.findViewById(R.id.txtId);
            txtTitulo=(TextView) itemView.findViewById(R.id.txtTitulo);
            txtDescripcion=(TextView) itemView.findViewById(R.id.txtDescripcion);
            txtFecha=(TextView) itemView.findViewById(R.id.txtFecha);
            txtUsuario=(TextView) itemView.findViewById(R.id.txtUsuario);
            btnModificar=(Button) itemView.findViewById(R.id.btnModificar);
            btnEliminar=(Button) itemView.findViewById(R.id.btnEliminar);

            this.context=context;
        }
    }

    // Configuraciones
    @NonNull
    @Override
    public NotaAdapterVE.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota_ve,parent,false);
        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaAdapterVE.ViewHolder holder, int position) {
        NotaVE notaVE = notas.get(position );
        holder.txtId.setText("" + notaVE.getId() );
        holder.txtTitulo.setText(notaVE.getTitulo() );
        holder.txtDescripcion.setText(notaVE.getDescripcion() );
        holder.txtFecha.setText(notaVE.getFecha().toString() );
        holder.txtUsuario.setText(notaVE.getUsuario() );

        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daoVE.delete(notaVE);
                notas =daoVE.getAll();
                notifyDataSetChanged();
                Toast.makeText(context.getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, NewVE_NotaActivity.class);
                intent.putExtra("estado",1); // 1 : Update
                intent.putExtra("nota",notaVE);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.notas.size();
    }
}
