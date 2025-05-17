package model;

public class Teatro extends SedeConSectores{
    public Teatro(String nombre, Integer capacidadMax, String direccion, Integer asientoPorFila, String[] sectores,
                  Integer[] capacidad, Integer[] porcentajeAdic) {
        super(nombre, capacidadMax, direccion, asientoPorFila, sectores, capacidad, porcentajeAdic);
    }
}
