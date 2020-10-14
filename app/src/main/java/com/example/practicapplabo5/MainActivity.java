package com.example.practicapplabo5;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements Dialog.NameDialogListener {
    private ProductoAdapter productoAdapter;
    public List<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lista de productos
        this.productos = new ArrayList<Producto>();
        loadTestList(this.productos);

        // Obtengo el Recycler y le configuro un layoutmanager (hay varios tipos)
        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        // Vinculo mi adapater con mi RecyclerView
        productoAdapter = new ProductoAdapter(this.productos, this);
        rv.setAdapter(productoAdapter);

    }

    public void controlStock(Producto producto, int buttonId){
        switch(buttonId) {
            case R.id.btnAdd:
                producto.setCantidad(producto.getCantidad() + 1);
                this.productos.set(this.productos.indexOf(producto), producto);
                showToast(getString(R.string.btnSumarMensaje) + "\n" + getProductMessage(producto));
                break;
            case R.id.btnDelete:
                producto.setCantidad(producto.getCantidad() - 1);
                this.productos.set(this.productos.indexOf(producto), producto);
                showToast(getString(R.string.btnRestarMensaje) + "\n" + getProductMessage(producto));
                break;
            case R.id.btnEdit:
                openDialog(producto);
                break;
            default:
                Log.d("Click","Easter egg");
        }

        this.productoAdapter.notifyDataSetChanged();
    }

    private void openDialog(Producto producto) {
        Dialog dialog = new Dialog(producto);
        dialog.show(getSupportFragmentManager(),"Modifique");
    }

    private void showToast(String message){
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void loadTestList(List<Producto> productos){
        if(Locale.getDefault().toString().equals("es_ES")) {
            productos.add(new Producto(17, 530, "Arroz"));
            productos.add(new Producto(16, 554, "Fideos"));
            productos.add(new Producto(51, 455, "Manteca"));
            productos.add(new Producto(15, 545, "Aceite"));
            productos.add(new Producto(31, 545, "Gaseosa"));
        }else {
            productos.add(new Producto(17, 530, "Rice"));
            productos.add(new Producto(16, 554, "Noodles"));
            productos.add(new Producto(51, 455, "Butter"));
            productos.add(new Producto(15, 545, "Oil"));
            productos.add(new Producto(31, 545, "Soda"));
        }
    }

    private String getProductMessage(Producto producto){
        return  getString(R.string.producto) +
                producto.getNombreProducto() + "\n" +
                getString(R.string.precioUnidad) +
                Double.toString(producto.getPrecioUnidad());
    }

    @Override
    public void modificarNombre(String nombre, Producto producto) {
        producto.setNombreProducto(nombre);
        Log.d("p", producto.toString());
        this.productos.set(this.productos.indexOf(producto), producto);
        this.productoAdapter.notifyDataSetChanged();
    }
}