package model;

import java.util.Date;

public class Funcion {
    private String sede;
    private Date fecha;
    private Integer precioBase;

    public Funcion(String sede, Date fecha, Integer precioBase) {
        this.sede = sede;
        this.fecha = fecha;
        this.precioBase = precioBase;
    }
}
