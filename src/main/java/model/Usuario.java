package model;

import Service.IEntrada;

import java.util.List;

public class Usuario {
    private String email;
    private String nombre;
    private String apellido;
    private String contrasenia;
    private List<IEntrada> entradas;

    public Usuario(String email, String nombre, String apellido, String contrasenia) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setEntradas(List<IEntrada> entradas) {
        this.entradas = entradas;
    }

    public List<IEntrada> getEntradas() {
        return entradas;
    }
}
