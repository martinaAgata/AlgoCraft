package main;

import main.estrategias.EstrategiaDesgaste;
import main.exceptions.NoHayHerramientaParaCrearException;
import main.herramientas.*;
import main.mapa.Mapa;
import main.mapa.Ubicacion;
import main.materiales.*;
import main.patrones.DetectorPatron;
import main.patrones.DetectorPatronHacha;
import main.patrones.DetectorPatronPico;
import main.patrones.DetectorPatronPicoFino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Supplier;
import static main.ConstantesJuego.*;

public class Juego {

    private Mapa mapa;
    private Jugador jugador;
    private DetectorPatron detectorPatron;
    private Mapa mapaHerramientas;
    private HashMap<Material, ArrayList<Material>> inventarioMateriales;
    private HashMap<Herramienta, ArrayList<Herramienta>> inventarioHerramientas;
    private Optional<Herramienta> herramientaCreada;

    public Juego() {
        mapa = new Mapa(CANTIDAD_FILAS, CANTIDAD_COLUMNAS);
        ConstructorHerramientaAbstracto constructor = new ConstructorHacha();
        Hacha hachaInicial = (Hacha) constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        jugador = new Jugador(hachaInicial);
        herramientaCreada = Optional.empty();
        mapa.ubicarEnCasilleroAleatorio(jugador);
        posicionarNMateriales(mapa, CANTIDAD_MADERAS, () -> new Madera());
        posicionarNMateriales(mapa, CANTIDAD_PIEDRAS, () -> new Piedra());
        posicionarNMateriales(mapa, CANTIDAD_METALES, () -> new Metal());
        posicionarNMateriales(mapa, CANTIDAD_DIAMANTES, () -> new Diamante());
        inicializarInventarios();
        inventarioHerramientas.get(hachaInicial).add(hachaInicial);
        crearPatrones();
        crearMapaHerramientas();
    }

    private void inicializarInventarios(){
        inventarioMateriales = new HashMap<>();
        inventarioMateriales.put(new Madera(), new ArrayList<>());
        inventarioMateriales.put(new Metal(), new ArrayList<>());
        inventarioMateriales.put(new Piedra(), new ArrayList<>());
        inventarioMateriales.put(new Diamante(), new ArrayList<>());

        inventarioHerramientas = new HashMap<>();
        /*HashMap<Material, ArrayList<Herramienta>> subtiposArmas = new HashMap<>();
        subtiposArmas.put(new Madera(), new ArrayList<>());
        subtiposArmas.put(new Metal(), new ArrayList<>());
        subtiposArmas.put(new Piedra(), new ArrayList<>());*/
        agregarHerramientaAinventarioHerramientas(new ConstructorHacha(), new Madera(),
                DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, DESGASTE_HACHA_MADERA);
        agregarHerramientaAinventarioHerramientas(new ConstructorHacha(), new Piedra(),
                DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, DESGASTE_HACHA_PIEDRA);
        agregarHerramientaAinventarioHerramientas(new ConstructorHacha(), new Metal(),
                DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, DESGASTE_HACHA_METAL);
        agregarHerramientaAinventarioHerramientas(new ConstructorPico(), new Madera(),
                DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, DESGASTE_PICO_MADERA);
        agregarHerramientaAinventarioHerramientas(new ConstructorPico(), new Piedra(),
                DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, DESGASTE_PICO_PIEDRA);
        agregarHerramientaAinventarioHerramientas(new ConstructorPico(), new Metal(),
                DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, DESGASTE_PICO_METAL);
        agregarHerramientaAinventarioHerramientas(new ConstructorPicoFino(), new Metal(),
                DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO, DESGASTE_PICO_FINO);

    }

    private void agregarHerramientaAinventarioHerramientas(ConstructorHerramientaAbstracto constructor,
                                                           Material material, int durabilidad, int fuerza, EstrategiaDesgaste desgaste){
        constructor.conMaterial(material).conDurabilidad(durabilidad)
                .conDesgaste(desgaste)
                .conFuerza(fuerza);
        inventarioHerramientas.put(constructor.construir(), new ArrayList<>());
    }

    public Mapa obtenerMapa() {
        return this.mapa;
    }

    private void posicionarNMateriales(Mapa mapa, int n, Supplier<Material> supplier) {
        for (int i=0; i<=n; i++) {
            mapa.ubicarEnCasilleroAleatorio(supplier.get());
        }
    }

    private void crearPatrones() {
        DetectorPatron dp = new DetectorPatronHacha(new Madera(), () -> new ConstructorHacha()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir());
        dp = new DetectorPatronHacha(new Piedra(), () -> new ConstructorHacha()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_HACHA_PIEDRA)
                .conDesgaste(DESGASTE_HACHA_PIEDRA)
                .conFuerza(FUERZA_HACHA_PIEDRA)
                .construir(), dp);
        dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_HACHA_METAL)
                .conDesgaste(DESGASTE_HACHA_METAL)
                .conFuerza(FUERZA_HACHA_METAL)
                .construir(), dp);
        dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico()
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA)
                .construir(), dp);
        dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_PIEDRA)
                .conFuerza(FUERZA_PICO_PIEDRA)
                .conDesgaste(DESGASTE_PICO_PIEDRA)
                .construir(), dp);
        dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico()
                .conMaterial(new Metal())
                .conDurabilidad(DURABILIDAD_PICO_METAL)
                .conDesgaste(DESGASTE_PICO_METAL)
                .conFuerza(FUERZA_PICO_METAL)
                .construir(), dp);
        dp = new DetectorPatronPicoFino(new Piedra(), () -> new ConstructorPicoFino()
                .conMaterial(new Piedra())
                .conDurabilidad(DURABILIDAD_PICO_FINO)
                .conDesgaste(DESGASTE_PICO_FINO)
                .conFuerza(FUERZA_PICO_FINO)
                .construir(), dp);
        this.detectorPatron = dp;
    }

    private void crearMapaHerramientas () {
        mapaHerramientas = new Mapa(CANTIDAD_FILAS_TABLERO_HERRAMIENTAS,CANTIDAD_COLUMNAS_TABLERO_HERRAMIENTAS);

    }

    private void detectarHerramientaMapaHerramientas(){
        this.herramientaCreada = this.detectorPatron.resolver(this.mapaHerramientas);
    }

    public void ubicarMaterialMapaHerramientas(Ubicacion ubicacion, Material material){
        this.mapaHerramientas.ubicarEnCasillero(material, ubicacion);
        detectarHerramientaMapaHerramientas();
    }

    public void quitarMaterialMapaHerramientas(Ubicacion ubicacion){
        this.mapaHerramientas.eliminarDeCasillero(ubicacion);
        detectarHerramientaMapaHerramientas();
    }

    public void forjarHerramientaCreada(){
        if (this.herramientaCreada.isEmpty()) throw new NoHayHerramientaParaCrearException("No se puede crear ninguna herramienta con la combinacion actual");
        //Eliminar cosas del inventario y agregar herramienta al inventario.
    }

    public void jugar() {

    }
}