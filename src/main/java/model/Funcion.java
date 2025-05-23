package model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Funcion {
    private String nombreEspectaculo;
    private Sede sede;
    private String fecha;
    private double precioBase;
    private int entradasVendidas = 0;

    private Map<String, Integer> entradasVendidasPorSector = new HashMap<>();

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

    public void agregarEntrada2(String sector , Integer cantidad){
        entradasVendidasPorSector.put(sector , cantidad);
    }

    public Map<String, Integer> getEntradasVendidasPorSector() {
        return entradasVendidasPorSector;
    }

    public int getEntradasVendidasPorSector2(String sector) {
        if(!entradasVendidasPorSector.containsKey(sector))
            return 0;
        else
            return entradasVendidasPorSector.get(sector);
    }
}
