package com.example.practicapplabo5;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {

    private List<Producto> productos = new ArrayList<>();
    private MainActivity mainActivity;

    public ProductoAdapter(List<Producto> productos, MainActivity mainActivity) {
        this.productos = productos;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Genero mi vista en memoria en base a mi layout customizado
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ProductoViewHolder productoViewHolder = new ProductoViewHolder(v, this.mainActivity);
        return productoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto p = productos.get(position);
        holder.producto = p;
        holder.tvNombreProducto.setText(p.getNombreProducto());
        holder.txtCantidad.setText(Integer.toString(p.getCantidad()));
        holder.txtPrecioUnidad.setText(Double.toString(p.getPrecioUnidad()));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }
}
