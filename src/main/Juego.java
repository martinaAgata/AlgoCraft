package main;

import main.herramientas.ConstructorHacha;
import main.herramientas.ConstructorPico;
import main.herramientas.ConstructorPicoFino;
import main.mapa.Mapa;
import main.materiales.*;
import main.patrones.DetectorPatron;
import main.patrones.DetectorPatronHacha;
import main.patrones.DetectorPatronPico;
import main.patrones.DetectorPatronPicoFino;

import java.util.function.Supplier;

public class Juego {
    private static final int CANTIDAD_FILAS = 20;
    private static final int CANTIDAD_COLUMNAS = 20;
    private static final int CANTIDAD_MADERAS = 70;
    private static final int CANTIDAD_PIEDRAS = 50;
    private static final int CANTIDAD_METALES = 35;
    private static final int CANTIDAD_DIAMANTES = 10;

    private Mapa mapa;
    private Jugador jugador;
    private DetectorPatron detectorPatron;
    private Mapa mapaHerramientas;

    public Juego() {
        mapa = new Mapa(CANTIDAD_FILAS, CANTIDAD_COLUMNAS);
        jugador = new Jugador();
        mapa.ubicarEnCasilleroAleatorio(jugador);
        posicionarNMateriales(mapa, CANTIDAD_MADERAS, () -> new Madera());
        posicionarNMateriales(mapa, CANTIDAD_PIEDRAS, () -> new Piedra());
        posicionarNMateriales(mapa, CANTIDAD_METALES, () -> new Metal());
        posicionarNMateriales(mapa, CANTIDAD_DIAMANTES, () -> new Diamante());
        crearPatrones();
        crearMapaHerramientas();
    }

    private void posicionarNMateriales(Mapa mapa, int n, Supplier<Material> supplier) {
        for (int i=0; i<=n; i++) {
            mapa.ubicarEnCasilleroAleatorio(supplier.get());
        }
    }

    private void crearPatrones() {
        DetectorPatron dp = new DetectorPatronHacha(new Madera(), () -> new ConstructorHacha().construirHachaMadera());
        dp = new DetectorPatronHacha(new Piedra(), () -> new ConstructorHacha().construirHachaPiedra(), dp);
        dp = new DetectorPatronHacha(new Metal(), () -> new ConstructorHacha().construirHachaMetal(), dp);
        dp = new DetectorPatronPico(new Madera(), () -> new ConstructorPico().construirPicoMadera(), dp);
        dp = new DetectorPatronPico(new Piedra(), () -> new ConstructorPico().construirPicoPiedra(), dp);
        dp = new DetectorPatronPico(new Metal(), () -> new ConstructorPico().construirPicoMetal(), dp);
        dp = new DetectorPatronPicoFino(new Piedra(), () -> new ConstructorPicoFino().construirPicoFino(), dp);
        this.detectorPatron = dp;
    }

    private void crearMapaHerramientas () {
        mapaHerramientas = new Mapa(3,3);

    }

    public void jugar() {

    }
}