package com.example.practicapplabo5;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder {
    public TextView tvNombreProducto;

    public ProductoViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNombreProducto = itemView.findViewById(R.id.tvNombreProducto);
    }
}
