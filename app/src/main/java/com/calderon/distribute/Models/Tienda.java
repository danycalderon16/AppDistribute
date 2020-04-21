package com.calderon.distribute.Models;

public class Tienda {

    private String nombre;
    private String tipo;
    private String horario;

    public Tienda(String nombre, String tipo, String horario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.horario = horario;
    }

    public Tienda() {
        this.nombre = "Tienda Local";
        this.tipo = "Abarrotes";
        this.horario = "7:00 - 20:00";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
