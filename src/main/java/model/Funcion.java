package model;

import Service.IEntrada;

import java.util.*;

public class Funcion {
    private String nombreEspectaculo;
    private Sede sede;
    private String fecha;
    private double precioBase;
    private List<IEntrada> entradasVendidas = new ArrayList<>();

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

    public void agregarEntrada(Entrada entrada){
        entradasVendidas.add(entrada);
    }

    public List<IEntrada> getEntradasVendidas() {
        return entradasVendidas;
    }
}
