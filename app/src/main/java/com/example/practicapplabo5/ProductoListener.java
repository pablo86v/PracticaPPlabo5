package com.example.practicapplabo5;

import android.os.ProxyFileDescriptorCallback;
import android.util.Log;
import android.view.View;

public class ProductoListener implements View.OnClickListener {

    private MainActivity mainActivity;
    private ProductoViewHolder productoViewHolder;

    public ProductoListener(ProductoViewHolder productoViewHolder, MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.productoViewHolder = productoViewHolder;
    }

    @Override
    public void onClick(View view) {
        this.mainActivity.controlStock(this.productoViewHolder.producto, view.getId());
    }
}
