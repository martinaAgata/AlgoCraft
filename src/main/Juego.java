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
import static main.ConstantesJuego.*;

public class Juego {

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
        mapaHerramientas = new Mapa(3,3);

    }

    public void jugar() {

    }
}