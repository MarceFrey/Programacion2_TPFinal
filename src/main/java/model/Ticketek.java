package model;
import Service.IEntrada;
import Service.ITicketek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ticketek implements ITicketek {
    List<Estadio> estadios = new ArrayList<>();
    List<Teatro> teatros = new ArrayList<>();
    List<MicroEstadio> microEstadios = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    List<Espectaculo> espectaculos = new ArrayList<>();
    List<Funcion> funciones = new ArrayList<>();

    public Ticketek() {
    }

    @Override
    //Registro de estadios
    public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
        for (Estadio estadio : estadios){
            if (estadio.getNombre().equals(nombre)){
                throw new RuntimeException("el nombre del estadio ya existe");
            }
        }
        estadios.add(new Estadio(nombre,capacidadMaxima,direccion));
    }

    @Override
    //Registro de teatros
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        for (Teatro teatro : teatros){
            if (teatro.getNombre().equals(nombre)){
                throw new RuntimeException("el nombre del teatro ya existe");
            }
        }
        teatros.add(new Teatro(nombre,capacidadMaxima,direccion,asientosPorFila,sectores, capacidad,porcentajeAdicional));
    }

    @Override
    //registro de microestadios
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        for (MicroEstadio microEstadio : microEstadios){
            if (microEstadio.getNombre().equals(nombre)){
                throw new RuntimeException("el nombre del microestadio ya existe");
            }
        }
        microEstadios.add(new MicroEstadio(nombre,capacidadMaxima,direccion,asientosPorFila,sectores, capacidad,porcentajeAdicional, cantidadPuestos, precioConsumicion));
    }

    @Override
    //registro de usuarios
    public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
        for (Usuario usuario : usuarios){
            if (usuario.getEmail().equals(email)){
                throw new RuntimeException("el email ya existe");
            }
        }
        usuarios.add(new Usuario(email,nombre,apellido,contrasenia));
    }

    @Override
    //registro de espectaculo
    public void registrarEspectaculo(String nombre) {
        for (Espectaculo espectaculo : espectaculos){
            if (espectaculo.getNombre().equals(nombre)){
                throw new RuntimeException("el espectaculo ya existe");
            }
        }
        espectaculos.add(new Espectaculo(nombre));
    }

    @Override
    //registro de funcion
    public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
        for (Funcion funcion : funciones){
            if (funcion.getNombreEspectaculo().equals(nombreEspectaculo) && funcion.getFecha().equals(fecha)){
                    throw new RuntimeException("ya existe una fecha para la función");
            }
        }
        funciones.add(new Funcion(nombreEspectaculo, sede, fecha, precioBase));
    }

    @Override
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, int cantidadEntradas) {
        List<IEntrada> entradasAVender = new ArrayList<>();
        for(Funcion funcion : funciones){
            if(funcion.getNombreEspectaculo().equals(nombreEspectaculo) && entradasAVender.size() < cantidadEntradas){
                entradasAVender.add(new Entrada(fecha, funcion.getPrecioBase()));
            }
        }

        boolean existeEspectaculo = false;
        boolean existeEmail = false;
        boolean existeContrasenia = false;

        for(Espectaculo espectaculo : espectaculos){
            existeEspectaculo = existeEspectaculo || espectaculo.getNombre().equals(nombreEspectaculo);
        }
        for(Usuario usuario : usuarios){
            existeEmail = existeEmail || usuario.getEmail().equals(email);
            existeContrasenia = existeContrasenia || usuario.getContrasenia().equals(contrasenia);
            System.out.println(usuario.getEmail());
        }

        if(!existeEspectaculo){
            throw new RuntimeException("Espectaculo invalido");
        }
        if(!existeEmail){
            throw new RuntimeException("Espectaculo invalido");
        }
        if(!existeContrasenia){
            throw new RuntimeException("Espectaculo invalido");
        }

        for(Usuario usuario : usuarios) {
            usuario.setEntradas(entradasAVender);
        }

        return entradasAVender;
    }

    @Override
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, String sector, int[] asientos) {
        List<IEntrada> entradasAVender = new ArrayList<>();
        for(int i = 0 ; i < asientos.length ; i++){
            entradasAVender.add(new Entrada(nombreEspectaculo, sector, asientos[i], fecha));
        }
        boolean existeEspectaculo = false;
        boolean existeEmail = false;
        boolean existeContrasenia = false;


        for(Espectaculo espectaculo : espectaculos){
            existeEspectaculo = existeEspectaculo || espectaculo.getNombre().equals(nombreEspectaculo);
        }
        for(Usuario usuario : usuarios){
            existeEmail = existeEmail || usuario.getEmail().equals(email);
            existeContrasenia = existeContrasenia || usuario.getContrasenia().equals(contrasenia);
            System.out.println(usuario.getEmail());
        }

        if(!existeEspectaculo){
            throw new RuntimeException("Espectaculo invalido");
        }
        if(!existeEmail){
            throw new RuntimeException("Espectaculo invalido");
        }
        if(!existeContrasenia){
            throw new RuntimeException("Espectaculo invalido");
        }
        if(asientos.length == 0){
            throw new RuntimeException("Espectaculo invalido");
        }

        return entradasAVender;
    }

    @Override
    public String listarFunciones(String nombreEspectaculo) {
        String auxFuncion = "";
        for(Funcion funcion : funciones){
            auxFuncion = funcion.toString();
        }
        return auxFuncion;
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

    //---------------------------------------PRUEBAS-----------------------------------------------------------------------

    public List<Estadio> getEstadios() {
        return estadios;
    }

    public void  verFunciones() {
        for (Funcion funcion : funciones) {
            System.out.println("PROBANDO FUNCIONES : " + funcion.getNombreEspectaculo() + funcion.getPrecioBase() + funcion.getFecha());
        }
    }

    public void verTeatros(){
        for (Teatro teatro : teatros){
            System.out.println(teatro.toString());
        }
    }
}
