package model;
import Service.IEntrada;
import Service.ITicketek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ticketek implements ITicketek {
    List<Estadio> estadios = new ArrayList<>();


    public Ticketek() {
    }

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
        for (Estadio estadio : estadios){
            if (estadio.getNombre().equals(nombre)){
                throw new RuntimeException("el nombre del estadio ya existe");
            }
        }
        estadios.add(new Estadio(nombre,capacidadMaxima,direccion));
    }

    public List<Estadio> getEstadios() {
        return estadios;
    }

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {

    }

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {

    }

    @Override
    public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {

    }

    @Override
    public void registrarEspectaculo(String nombre) {

    }

    @Override
    public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {

    }

    @Override
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, int cantidadEntradas) {
        return List.of();
    }

    @Override
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, String sector, int[] asientos) {
        return List.of();
    }

    @Override
    public String listarFunciones(String nombreEspectaculo) {
        return "";
    }

    @Override
    public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
        return List.of();
    }

    @Override
    public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
        return List.of();
    }

    @Override
    public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia) {
        return List.of();
    }

    @Override
    public boolean anularEntrada(IEntrada entrada, String contrasenia) {
        return false;
    }

    @Override
    public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
        return null;
    }

    @Override
    public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {
        return null;
    }

    @Override
    public double costoEntrada(String nombreEspectaculo, String fecha) {
        return 0;
    }

    @Override
    public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
        return 0;
    }

    @Override
    public double totalRecaudado(String nombreEspectaculo) {
        return 0;
    }

    @Override
    public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
        return 0;
    }
}
