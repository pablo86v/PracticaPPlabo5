package com.example.practicapplabo5;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder {
    public TextView tvNombreProducto;
    public TextView txtCantidad;
    public TextView txtPrecioUnidad;
    private MainActivity mainActivity;
    public Producto producto;

    public ProductoViewHolder(@NonNull View itemView, MainActivity mainActivity) {
        super(itemView);

        this.mainActivity = mainActivity;

        tvNombreProducto = itemView.findViewById(R.id.tvNombreProducto);
        txtCantidad = itemView.findViewById(R.id.txtCantidad);
        txtPrecioUnidad = itemView.findViewById(R.id.txtPrecioUnidad);

        itemView.findViewById(R.id.btnAdd).setOnClickListener(new ProductoListener(this, this.mainActivity) );
        itemView.findViewById(R.id.btnDelete).setOnClickListener(new ProductoListener(this,this.mainActivity));
        itemView.findViewById(R.id.btnEdit).setOnClickListener(new ProductoListener(this, this.mainActivity));


    }
}
