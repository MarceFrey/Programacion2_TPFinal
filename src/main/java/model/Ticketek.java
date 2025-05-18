package model;
import Service.IEntrada;
import Service.ITicketek;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ticketek implements ITicketek {
    Set<Estadio> estadios = new HashSet<>();
    Set<Teatro> teatros = new HashSet<>();
    Set<MicroEstadio> microEstadios = new HashSet<>();
    Set<Usuario> usuarios = new HashSet<>();
    Set<Espectaculo> espectaculos = new HashSet<>();
    Set<Funcion> funciones = new HashSet<>();

    public Ticketek() {
    }

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
        if (estadios.contains(nombre)){
            throw new RuntimeException("el nombre del estadio ya existe");
        }else{
            estadios.add(new Estadio(nombre,capacidadMaxima,direccion));
        }
    }

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        if (teatros.contains(nombre)){
            throw new RuntimeException("el nombre del teatro ya existe");
        }else{
            teatros.add(new Teatro(nombre, capacidadMaxima, direccion, asientosPorFila, sectores, capacidad, porcentajeAdicional));
        }
    }

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        if (microEstadios.contains(nombre)){
            throw new RuntimeException("el nombre del microestadio ya existe");
        }else{
            microEstadios.add(new MicroEstadio(nombre, capacidadMaxima, direccion, asientosPorFila, sectores, capacidad, porcentajeAdicional, cantidadPuestos, precioConsumicion));
        }
    }

    @Override
    public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
        if (usuarios.contains(nombre)){
            throw new RuntimeException("el nombre del usuario ya existe");
        }else{
            usuarios.add(new Usuario(email,nombre,apellido,contrasenia));
        }
    }

    @Override
    public void registrarEspectaculo(String nombre) {
        if (espectaculos.contains(nombre)){
            throw new RuntimeException("el nombre del espectaculo ya existe");
        }else{
            espectaculos.add(new Espectaculo(nombre));
        }
    }

    @Override
    public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
        if (espectaculos.contains(nombreEspectaculo)){
            funciones.add(new Funcion(nombreEspectaculo, sede, fecha, precioBase));
        }else{
            throw new RuntimeException("el nombre del espectaculo no existe");
        }
    }

    @Override
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, int cantidadEntradas) {
        if(usuarios.contains(email) && usuarios.contains(contrasenia)){
            
        }
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
