package model;

import Service.IEntrada;

import java.util.Date;

public class Entrada implements IEntrada {
    private String id;
    private String codigoEspectaculo;
    private String sede;
    private String sector;
    private String numeroAsiento;
    private int precio;
    private Date fecha;

    public Entrada(String id, String codigoEspectaculo, String sede, String sector, String numeroAsiento, int precio, Date fecha) {
        this.id = id;
        this.codigoEspectaculo = codigoEspectaculo;
        this.sede = sede;
        this.sector = sector;
        this.numeroAsiento = numeroAsiento;
        this.precio = precio;
        this.fecha = fecha;
    }

    @Override
    public double precio() {
        return 0;
    }

    @Override
    public String ubicacion() {
        return "";
    }
}
