package model;

public class Sede {
    private String nombre;
    private Integer capacidadMax;
    private String direccion;

    public Sede(String nombre, Integer capacidadMax, String direccion) {
        this.nombre = nombre;
        this.capacidadMax = capacidadMax;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCapacidadMax() {
        return capacidadMax;
    }

    public String getDireccion() {
        return direccion;
    }


}
