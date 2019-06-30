package modelo.juego;

import modelo.estrategias.EstrategiaDesgaste;
import modelo.exceptions.NoSePuedeEliminarPorqueEstaVacioException;
import modelo.exceptions.NoHayHerramientaParaCrearException;
import modelo.herramientas.*;
import modelo.mapa.Mapa;
import modelo.mapa.ObservadorUbicable;
import modelo.mapa.ObservadorUbicableImpl;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;
import modelo.patrones.DetectorPatron;
import modelo.patrones.DetectorPatronHacha;
import modelo.patrones.DetectorPatronPico;
import modelo.patrones.DetectorPatronPicoFino;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static modelo.juego.ConstantesJuego.*;

public class Juego {

    private Mapa mapa;
    private Jugador jugador;
    private DetectorPatron detectorPatron;
    private Mapa tableroCrafteo;
    private HashMap<Material, Integer> inventarioTablero;
    private HashMap<Material, Integer> inventarioMaterialesJugador;
    private HashMap<Herramienta, ArrayList<Herramienta>> inventarioHerramientas;
    private Optional<Herramienta> herramientaCreada;
    public static final Madera madera = new Madera();
    public static final Piedra piedra = new Piedra();
    public static final Metal metal = new Metal();
    public static final Diamante diamante = new Diamante();

    //NO ESTAMOS LLAMANDO INICIALIZAR JUEGO CUANDO CREO EL JUEGO

    public Juego() { // ver lo del booleano para inicializar
        this.mapa = new Mapa(CANTIDAD_FILAS, CANTIDAD_COLUMNAS);
        this.tableroCrafteo = new Mapa(CANTIDAD_FILAS_TABLERO_HERRAMIENTAS, CANTIDAD_COLUMNAS_TABLERO_HERRAMIENTAS);
        this.inventarioHerramientas = new HashMap<>();
        this.inventarioTablero = new HashMap<>();
        this.inventarioMaterialesJugador = new HashMap<>();
    }

    public void actualizarInventarios(Ubicable ubicable) {
        inventarioTablero.put((Material) ubicable, inventarioTablero.get(ubicable) - 1);
        inventarioMaterialesJugador.put((Material) ubicable, inventarioMaterialesJugador.get(ubicable) + 1);
    }

    public void inicializarInventarioTablero() {
        inventarioTablero.put(madera, 0);
        inventarioTablero.put(piedra, 0);
        inventarioTablero.put(metal, 0);
        inventarioTablero.put(diamante, 0);
    }

    /* Pre: Se debe tener inicializado el inventarioHerramientas */
    public void inicializarJugador() {
        Hacha hachaInicial = (Hacha) new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        Ubicacion ubicacionJugador = new Ubicacion(1, 6);
        this.jugador = new Jugador(hachaInicial, this.inventarioMaterialesJugador, ubicacionJugador);
        this.mapa.ubicarEnCasillero(jugador, ubicacionJugador);
        inventarioHerramientas.get(hachaInicial).add(hachaInicial);
    }

    public void inicializarJuego() {
        inicializarInventarioMaterial();
        inicializarInventarioHerramienta();
        inicializarJugador();
        inicializarMapaConMateriales();
        inicializarPatrones();
    }

    public void inicializarInventarioMaterial() {
        inventarioMaterialesJugador.put(madera, 0);
        inventarioMaterialesJugador.put(metal, 0);
        inventarioMaterialesJugador.put(piedra, 0);
        inventarioMaterialesJugador.put(diamante, 0);
    }

    public void inicializarInventarioHerramienta() {
        agregarListaDeHerramientasAinventarioHerramientas(new ConstructorHacha(), new Madera(),
                DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, DESGASTE_HACHA_MADERA);
        agregarListaDeHerramientasAinventarioHerramientas(new ConstructorHacha(), new Piedra(),
                DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, DESGASTE_HACHA_PIEDRA);
        agregarListaDeHerramientasAinventarioHerramientas(new ConstructorHacha(), new Metal(),
                DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, DESGASTE_HACHA_METAL);
        agregarListaDeHerramientasAinventarioHerramientas(new ConstructorPico(), new Madera(),
                DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, DESGASTE_PICO_MADERA);
        agregarListaDeHerramientasAinventarioHerramientas(new ConstructorPico(), new Piedra(),
                DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, DESGASTE_PICO_PIEDRA);
        agregarListaDeHerramientasAinventarioHerramientas(new ConstructorPico(), new Metal(),
                DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, DESGASTE_PICO_METAL);
        agregarListaDeHerramientasAinventarioHerramientas(new ConstructorPicoFino(), new Metal(),
                DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO, DESGASTE_PICO_FINO);
    }

    private void agregarListaDeHerramientasAinventarioHerramientas(ConstructorHerramientaAbstracto constructor,
                                                                   Material material, int durabilidad, int fuerza, EstrategiaDesgaste desgaste) {
        constructor.conMaterial(material).conDurabilidad(durabilidad)
                .conDesgaste(desgaste)
                .conFuerza(fuerza);
        inventarioHerramientas.put(constructor.construir(), new ArrayList<>());
    }

    private void inicializarPatrones() {
        DetectorPatron dPHachaMadera = new DetectorPatronHacha(madera, () -> new ConstructorHacha()
                .conMaterial(madera)
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        DetectorPatron dPHachaPiedra = new DetectorPatronHacha(piedra, () -> new ConstructorHacha()
                .conMaterial(piedra)
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir(), dPHachaMadera);
        DetectorPatron dPHachaMetal = new DetectorPatronHacha(metal, () -> new ConstructorHacha()
                .conMaterial(metal)
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir(), dPHachaPiedra);
        DetectorPatron dPPicoMadera = new DetectorPatronPico(madera, () -> new ConstructorPico()
                .conMaterial(madera)
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir(), dPHachaMetal);
        DetectorPatron dPPicoPiedra = new DetectorPatronPico(piedra, () -> new ConstructorPico()
                .conMaterial(piedra)
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .construir(), dPPicoMadera);
        DetectorPatron dPPicoMetal = new DetectorPatronPico(metal, () -> new ConstructorPico()
                .conMaterial(metal)
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir(), dPPicoPiedra);
        DetectorPatron dPPicoFino = new DetectorPatronPicoFino(metal, () -> new ConstructorPicoFino()
                .conMaterial(piedra)
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir(), dPPicoMetal);
        this.detectorPatron = dPPicoFino;
    }

    private void detectarHerramientatableroCrafteo() {
        this.herramientaCreada = this.detectorPatron.resolverPatron(this.tableroCrafteo);
    }

    public void ubicarMaterialTableroCrafteo(Ubicacion ubicacion, Material material) {
        this.tableroCrafteo.ubicarEnCasillero(material, ubicacion);
        detectarHerramientatableroCrafteo();
    }

    public void quitarMaterialTableroCrafteo(Ubicacion ubicacion) {
        this.tableroCrafteo.eliminarDeCasillero(ubicacion);
        detectarHerramientatableroCrafteo();
    }

    public Mapa obtenerTableroCrafteo() {
        return this.tableroCrafteo;
    }

    public HashMap<Material, Integer> obtenerInventarioMaterialesJugador() {
        return this.inventarioMaterialesJugador;
    }

    public HashMap<Material, Integer> obtenerInventarioTablero() {
        return this.inventarioTablero;
    }

    public HashMap<Herramienta, ArrayList<Herramienta>> obtenerInventarioHerramientas() {
        return this.inventarioHerramientas;
    }

    private void agregarHerramientaAlInventario() {
        inventarioHerramientas.get(herramientaCreada.get()).add(herramientaCreada.get());
    }

    private void eliminarMaterialesDelInventario() {
        for (int x = 1; x <= CANTIDAD_FILAS_TABLERO_HERRAMIENTAS; x++) {
            for (int y = 1; y <= CANTIDAD_COLUMNAS_TABLERO_HERRAMIENTAS; y++) {
                try {
                    Material eliminar = (Material) this.tableroCrafteo.eliminarDeCasillero(new Ubicacion(x, y));
                    this.inventarioMaterialesJugador.put(eliminar, this.inventarioMaterialesJugador.get(eliminar) - 1);
                } catch (NoSePuedeEliminarPorqueEstaVacioException casilleroVacio) {/*Hacer nada*/}
            }
        }
    }

    public void crearHerramienta() {
        if (!this.herramientaCreada.isPresent())
            throw new NoHayHerramientaParaCrearException("No se puede crear ninguna herramienta con la combinacion actual");
        eliminarMaterialesDelInventario();
        agregarHerramientaAlInventario();
    }

    public void inicializarMapaConMateriales() {
        ObservadorUbicable observadorMateriales = new ObservadorUbicableImpl(this);
        this.inicializarInventarioTablero();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                Ubicacion ubicacion = new Ubicacion(i, j);
                Madera madera = new Madera(ubicacion, Optional.of(observadorMateriales));
                inventarioTablero.put(madera, inventarioTablero.get(madera) + 1);
                this.mapa.ubicarEnCasillero(madera, ubicacion);
            }
        }

        for (int i = 4; i <= 7; i++) {
            for (int j = 4; j <= 7; j++) {
                Ubicacion ubicacion = new Ubicacion(i, j);
                Piedra piedra = new Piedra(ubicacion, Optional.of(observadorMateriales));
                inventarioTablero.put(piedra, inventarioTablero.get(piedra) + 1);
                this.mapa.ubicarEnCasillero(piedra, ubicacion);
            }
        }

        for (int i = 8; i <= 9; i++) {
            for (int j = 8; j <= 9; j++) {
                Ubicacion ubicacion = new Ubicacion(i, j);
                Metal metal = new Metal(ubicacion, Optional.of(observadorMateriales));
                inventarioTablero.put(metal, inventarioTablero.get(metal) + 1);
                this.mapa.ubicarEnCasillero(metal, ubicacion);
            }
        }

        Ubicacion ubicacion = new Ubicacion(10, 10);
        Diamante diamante = new Diamante(ubicacion, Optional.of(observadorMateriales));
        inventarioTablero.put(diamante, inventarioTablero.get(diamante) + 1);
        this.mapa.ubicarEnCasillero(diamante, ubicacion);
    }

    public void seleccionarHerramientaAUtilizar(Herramienta herramienta){
        Herramienta herramientaSeleccionada = null;
        for(Herramienta herramientaEnInventario : this.inventarioHerramientas.get(herramienta)){
            if(!herramienta.esIgualA(herramientaEnInventario)) continue;
            herramientaSeleccionada = herramientaEnInventario;
            break;
        }
        this.jugador.setHerramientaActual(herramientaSeleccionada);
    }

    public Mapa obtenerMapa() {
        return this.mapa;
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }
    public Herramienta obtenerHerramientaCrafteable(){
        if (this.herramientaCreada.isPresent()) return this.herramientaCreada.get();
        return null;
    }

}
