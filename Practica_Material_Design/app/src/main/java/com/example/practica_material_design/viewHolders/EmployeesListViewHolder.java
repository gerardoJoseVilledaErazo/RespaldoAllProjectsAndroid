package com.example.practica_material_design.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica_material_design.R;

public class EmployeesListViewHolder extends RecyclerView.ViewHolder {

    ImageView imgAvatar;
    TextView tvName, tvLastName;

    public EmployeesListViewHolder(@NonNull View itemView) {
        super(itemView);

        imgAvatar   = itemView.findViewById(R.id.ivAvatar);
        tvName      = itemView.findViewById(R.id.tvName);
        tvLastName  = itemView.findViewById(R.id.tvLastName);
    }

    public ImageView getImgAvatar() {
        return imgAvatar;
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvLastName() {
        return tvLastName;
    }
}
