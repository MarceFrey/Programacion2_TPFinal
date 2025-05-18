package model;

public class SedeConSectores extends Sede{
    private Integer asientoPorFila;
    private String [] sectores;
    private int[] capacidad;
    private int [] porcentajeAdic;

    public SedeConSectores(String nombre, Integer capacidadMax, String direccion, Integer asientoPorFila,
                           String[] sectores, int[] capacidad, int[] porcentajeAdic) {
        super(nombre, capacidadMax, direccion);
        this.asientoPorFila = asientoPorFila;
        this.sectores = sectores;
        this.capacidad = capacidad;
        this.porcentajeAdic = porcentajeAdic;
    }
}
