package model;

import java.util.Arrays;

public class SedeConSectores extends Sede{
    private Integer asientoPorFila;
    private String [] sectores;
    private int[] capacidad;
    private int [] porcentajeAdic;

    public SedeConSectores(String nombre, Integer capacidadMax, String direccion, Integer asientoPorFila,
                           String[] sectores, int[] capacidad, int[] porcentajeAdic) {
        super(nombre, capacidadMax, direccion);
        this.asientoPorFila = asientoPorFila;
        this.sectores = sectores;
        this.capacidad = capacidad;
        this.porcentajeAdic = porcentajeAdic;
    }

    public Integer getAsientoPorFila() {
        return asientoPorFila;
    }

    public String[] getSectores() {
        return sectores;
    }

    public int[] getCapacidad() {
        return capacidad;
    }

    public int[] getPorcentajeAdic() {
        return porcentajeAdic;
    }

    @Override
    public String toString() {
        return "SedeConSectores{" +
                "asientoPorFila=" + asientoPorFila +
                ", sectores=" + Arrays.toString(sectores) +
                ", capacidad=" + Arrays.toString(capacidad) +
                ", porcentajeAdic=" + Arrays.toString(porcentajeAdic) +
                '}';
    }
}
