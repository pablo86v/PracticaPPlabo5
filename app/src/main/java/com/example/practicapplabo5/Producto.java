package com.example.practicapplabo5;

public class Producto {
    private int cantidad;
    private double precioUnidad;
    private String nombreProducto;

    public Producto(int cantidad, double precioUnidad, String nombreProducto) {
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.nombreProducto = nombreProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "cantidad=" + cantidad +
                ", precioUnidad=" + precioUnidad +
                ", nombreProducto='" + nombreProducto + '\'' +
                '}';
    }
}
