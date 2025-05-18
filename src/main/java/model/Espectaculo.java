package model;

import java.util.ArrayList;

public class Espectaculo {
    private String nombre;
    private ArrayList<Funcion> funciones;
    private int codigo = 0;

    public Espectaculo(String nombre) {
        this.nombre = nombre;
        this.codigo = codigo +1;
    }
}
