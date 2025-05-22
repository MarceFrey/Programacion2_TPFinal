package model;

import java.util.Date;

public class Funcion {
    private String nombreEspectaculo;
    private Sede sede;
    private String fecha;
    private double precioBase;
    private int entradasVendidas = 0;

    public Funcion(String nombreEspectaculo, Sede sede, String fecha, double precioBase) {
        this.nombreEspectaculo = nombreEspectaculo;
        this.sede = sede;
        this.fecha = fecha;
        this.precioBase = precioBase;
    }

    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }

    public String getFecha() {
        return fecha;
    }

    public double getPrecioBase() {return precioBase;}

    public Sede getSede() {return sede;}

    public void agregarEntrada(int cantEntradas){
        this.entradasVendidas += cantEntradas;
    }

    public int getEntradasVendidas() {
        return entradasVendidas;
    }
}
