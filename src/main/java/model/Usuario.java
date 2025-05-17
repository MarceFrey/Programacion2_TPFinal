package model;

import java.util.List;

public class Usuario {
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private String contrasenia;
    private List<Entrada> entradas;

    public Usuario(String nombreUsuario, String nombre, String apellido, String contrasenia, List<Entrada> entradas) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.entradas = entradas;
    }
}
