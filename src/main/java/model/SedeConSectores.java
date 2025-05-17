package model;

public class SedeConSectores extends Sede{
    private Integer asientoPorFila;
    private String [] sectores;
    private Integer [] capacidad;
    private Integer [] porcentajeAdic;

    public SedeConSectores(String nombre, Integer capacidadMax, String direccion, Integer asientoPorFila,
                           String[] sectores, Integer[] capacidad, Integer[] porcentajeAdic) {
        super(nombre, capacidadMax, direccion);
        this.asientoPorFila = asientoPorFila;
        this.sectores = sectores;
        this.capacidad = capacidad;
        this.porcentajeAdic = porcentajeAdic;
    }
}
