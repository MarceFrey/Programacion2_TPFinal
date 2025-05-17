package model;

import java.util.ArrayList;

public class Espectaculo {
    private String nombre;
    private ArrayList<Funcion> funciones;
    private String codigo;

    public Espectaculo(String nombre, ArrayList<Funcion> funciones, String codigo) {
        this.nombre = nombre;
        this.funciones = funciones;
        this.codigo = codigo;
    }
}
