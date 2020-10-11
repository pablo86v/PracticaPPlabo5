package com.example.practicapplabo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Producto> productos;
    private ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lista de productos
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto(1,50,"Arroz"));
        productos.add(new Producto(1,55,"Fideos"));

        // Obtengo el Recycler y le configuro un layoutmanager
        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        // Seteo el adapter al recycler
        productoAdapter = new ProductoAdapter(productos);
        rv.setAdapter(productoAdapter);
        productoAdapter.notifyDataSetChanged();



    }



}