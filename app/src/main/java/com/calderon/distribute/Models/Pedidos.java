package com.calderon.distribute.Models;

public class Pedidos {

    private String hora;
    private int cantidad;
    private String direcciones;
    private boolean status;

    public Pedidos(String hora, int cantidad, String direcciones, boolean status) {
        this.hora = hora;
        this.cantidad = cantidad;
        this.direcciones = direcciones;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }
}
