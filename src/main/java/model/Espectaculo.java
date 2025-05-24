package model;

import java.util.ArrayList;
import java.util.List;

public class Espectaculo {
    private String nombre;
    private ArrayList<Funcion> funciones = new ArrayList<>();
    private int codigo = 0;

    public Espectaculo(String nombre) {
        this.nombre = nombre;
        this.codigo = codigo +1;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Funcion> getFunciones() {return funciones;}
}
