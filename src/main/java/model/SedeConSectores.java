package model;

import java.util.Arrays;

public class SedeConSectores extends Sede{
    private int asientoPorFila;
    private String [] sectores;
    private int[] capacidad;
    private int [] porcentajeAdic;

    public SedeConSectores(String nombre, int capacidadMax, String direccion, int asientoPorFila,
                           String[] sectores, int[] capacidad, int[] porcentajeAdic) {
        super(nombre, capacidadMax, direccion);
        this.asientoPorFila = asientoPorFila;
        this.sectores = sectores;
        this.capacidad = capacidad;
        this.porcentajeAdic = porcentajeAdic;
    }

    public int getAsientoPorFila() {
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

}
