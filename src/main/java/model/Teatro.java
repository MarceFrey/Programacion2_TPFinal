package model;

public class Teatro extends SedeConSectores{
    public Teatro(String nombre, int capacidadMax, String direccion, int asientoPorFila, String[] sectores,
                  int[] capacidad, int[] porcentajeAdic) {
        super(nombre, capacidadMax, direccion, asientoPorFila, sectores, capacidad, porcentajeAdic);
    }

}
