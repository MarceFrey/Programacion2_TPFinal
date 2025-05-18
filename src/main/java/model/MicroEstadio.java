package model;

public class MicroEstadio extends SedeConSectores {
    private int cantPuestos;
    private double precioConsumicion;

    public MicroEstadio(String nombre, Integer capacidadMax, String direccion, Integer asientoPorFila, String[] sectores,
                        int[] capacidad, int[] porcentajeAdic, int cantPuestos, double precioConsumicion) {
        super(nombre, capacidadMax, direccion, asientoPorFila, sectores, capacidad, porcentajeAdic);
        this.cantPuestos = cantPuestos;
        this.precioConsumicion = precioConsumicion;
    }
}
