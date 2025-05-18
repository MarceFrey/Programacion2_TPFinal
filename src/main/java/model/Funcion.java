package model;

import java.util.Date;

public class Funcion {
    private String nombreEspectaculo;
    private String sede;
    private String fecha;
    private double precioBase;

    public Funcion(String nombreEspectaculo, String sede, String fecha, double precioBase) {
        this.nombreEspectaculo = nombreEspectaculo;
        this.sede = sede;
        this.fecha = fecha;
        this.precioBase = precioBase;
    }
}
