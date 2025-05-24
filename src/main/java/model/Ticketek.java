package model;
import Service.IEntrada;
import Service.ITicketek;

import java.util.*;

public class Ticketek implements ITicketek {
    //private List<Funcion> funciones = new ArrayList<>();

    private Map<String, Sede> sedes = new HashMap<>();
    private Map<String, Espectaculo> espectaculos_ = new HashMap<>();
    private Map<String, Funcion> funciones = new HashMap<>();
    private Map<String, Usuario> usuarios = new HashMap<>();

    public Ticketek() {
    }

    @Override
    //Registro de estadios
    public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
        if (sedes.containsKey(nombre)){
            throw new RuntimeException("el nombre del estadio ya existe");
        }
        sedes.put(nombre, new Estadio(nombre,capacidadMaxima,direccion));
    }

    @Override
    //Registro de teatros
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        if (sedes.containsKey(nombre)){
            throw new RuntimeException("el nombre del Teatro ya existe");
        }
        sedes.put(nombre, new Teatro(nombre,capacidadMaxima,direccion,asientosPorFila,sectores, capacidad,porcentajeAdicional));
    }

    @Override
    //registro de microestadios
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        if (sedes.containsKey(nombre)){
            throw new RuntimeException("el nombre del microestadio ya existe");
        }
        sedes.put(nombre, new MicroEstadio(nombre,capacidadMaxima,direccion,asientosPorFila,sectores,
                capacidad,porcentajeAdicional, cantidadPuestos, precioConsumicion));
    }

    @Override
    //registro de usuarios
    public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
        if(usuarios.containsKey(email)){
            throw new RuntimeException("el Usuario ya existe");
        }
        usuarios.put(email, new Usuario(email,nombre,apellido,contrasenia));
    }

    @Override
    //registro de espectaculo
    public void registrarEspectaculo(String nombre) {
        /*for (Espectaculo espectaculo : espectaculos){
            if (espectaculo.getNombre().equals(nombre)){
                throw new RuntimeException("el espectaculo ya existe");
            }
        }
        espectaculos.add(new Espectaculo(nombre));*/

        if(!espectaculos_.containsKey(nombre)){
            espectaculos_.put(nombre , new Espectaculo(nombre));
        }
        else throw new RuntimeException("el espectaculo ya existe");

    }

    @Override
    //registro de funcion
    public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
        for (Funcion funcion : funciones.values()){
            if (funcion.getNombreEspectaculo().equals(nombreEspectaculo) && funcion.getFecha().equals(fecha)){
                    throw new RuntimeException("ya existe una fecha para la función");
            }
        }
        funciones.put(fecha , new Funcion(nombreEspectaculo, sedes.get(sede), fecha, precioBase));
    }

    @Override
    //Venta entradas estadio
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, int cantidadEntradas) {
        if(!usuarios.containsKey(email)|| !usuarios.get(email).getContrasenia().equals(contrasenia)){
            throw new RuntimeException("Usuario o contraseña invalido");
        }

        if(!espectaculos_.containsKey(nombreEspectaculo)){
            throw new RuntimeException("Espectaculo invalido");
        }


        List<IEntrada> entradasAVender = new ArrayList<>();

        for(Funcion funcion : funciones.values()){
            System.out.println("abc" + funcion.getNombreEspectaculo());
            if(funcion.getNombreEspectaculo().equals(nombreEspectaculo)){
                System.out.println(nombreEspectaculo);
                System.out.println(funcion.getPrecioBase());
                entradasAVender.add(new Entrada(fecha, funcion.getPrecioBase()));
                funcion.agregarEntrada(cantidadEntradas);
            }
        }
        System.out.println( "prueba" + entradasAVender.toArray().length);
        for(Usuario usuario : usuarios.values()) {
            usuario.setEntradas(entradasAVender);
        }

        return entradasAVender;

        /*for (Funcion funcion : funciones.values()) {
            if (funcion.getNombreEspectaculo().equals(nombreEspectaculo)) {
                while (entradasAVender.size() < cantidadEntradas) {
                    entradasAVender.add(new Entrada(fecha, funcion.getPrecioBase()));
                }
                funcion.agregarEntrada(cantidadEntradas); // Esto sigue siendo confuso
                break; // Sal del bucle para no seguir recorriendo otras funciones
            }
        }

        for(Usuario usuario : usuarios.values()) {
            usuario.setEntradas(entradasAVender);
        }

        return entradasAVender;*/
    }

    //Venta entradas sedes con sectores
    @Override
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, String sector, int[] asientos) {
        if(!usuarios.containsKey(email)){
            throw new RuntimeException("Usuario invalido");
        }

        if(!usuarios.get(email).getContrasenia().equals(contrasenia)){
            throw new RuntimeException("Espectaculo invalido");
        }

        if(asientos.length == 0){throw new RuntimeException("Espectaculo invalido");}

        if(!espectaculos_.containsKey(nombreEspectaculo)){
            throw new RuntimeException("Espectaculo invalido");
        }

        List<IEntrada> entradasAVender = new ArrayList<>();

        /*for(Funcion funcion : funciones.values()){
            if(funcion.getNombreEspectaculo().equals(nombreEspectaculo) && funcion.getFecha().equals(fecha)) {
                funcion.agregarEntrada2(sector, asientos.length);
                entradasAVender.add(new Entrada(fecha, funcion.getPrecioBase()));
            }
        }*/
        for(int i = 0 ; i < asientos.length ; i++){
            entradasAVender.add(new Entrada(nombreEspectaculo, sector, asientos[i], fecha));
            //entradasVendidasPorSector.put(sector , asientos[i]);
        }

        return entradasAVender;
    }

    @Override
    public String listarFunciones(String nombreEspectaculo) {
        StringBuilder resultado = new StringBuilder();

        for (Funcion funcion : funciones.values()) {
            if (funcion.getNombreEspectaculo().equals(nombreEspectaculo)) {
                Sede sede = funcion.getSede();

                resultado.append(" - (" +funcion.getFecha() + ") " + sede.getNombre() + " - ") ;

                if (sede instanceof Estadio) {
                    resultado.append(funcion.getEntradasVendidas())
                            .append("/")
                            .append(sede.getCapacidadMax());
                }
                else if (sede instanceof Teatro || sede instanceof MicroEstadio ) {
                    SedeConSectores sedeConSectores = (SedeConSectores) sede;
                    String[] sectores = sedeConSectores.getSectores();
                    int[] capacidades = sedeConSectores.getCapacidad();

                    List<String> sectoresInfo = new ArrayList<>();
                    for (int i = 0; i < sectores.length; i++) {
                        sectoresInfo.add(sectores[i] + ": " + funcion.getEntradasVendidasPorSector2(sectores[i])+ "/" + capacidades[i]);
                    }
                    resultado.append(String.join(" | ", sectoresInfo));
                }

                resultado.append("\n");
            }
        }
        return resultado.toString();
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

}
