package main;

import main.mapa.Mapa;
import main.materiales.Madera;
import main.materiales.Piedra;
import main.materiales.Metal;
import main.materiales.Diamante;

public class Juego {
    private static final int CANTIDAD_MADERAS = 70;
    private static final int CANTIDAD_PIEDRAS = 50;
    private static final int CANTIDAD_METALES = 35;
    private static final int CANTIDAD_DIAMANTES = 10;
    private Mapa mapa;
    private Jugador jugador;
    public Juego() {
        mapa = new Mapa();
        jugador = new Jugador();
        mapa.ubicarEnCasillero(jugador);
        posicionarNMaderas(mapa, CANTIDAD_MADERAS);
        posicionarNPiedras(mapa, CANTIDAD_PIEDRAS);
        posicionarNMetales(mapa, CANTIDAD_METALES);
        posicionarNDiamantes(mapa, CANTIDAD_DIAMANTES);
    }

    public void posicionarNMaderas(Mapa mapa, int n) {
        for (int i=0; i<=n; i++) {
            mapa.ubicarEnCasillero(new Madera());
        }
    }
    public void posicionarNPiedras(Mapa mapa, int n) {
        for (int i=0; i<=n; i++) {
            mapa.ubicarEnCasillero(new Piedra());
        }
    }
    public void posicionarNMetales(Mapa mapa, int n) {
        for (int i=0; i<=n; i++) {
            mapa.ubicarEnCasillero(new Metal());
        }
    }
    public void posicionarNDiamantes(Mapa mapa,  int n) {
        for (int i=0; i<=n; i++) {
            mapa.ubicarEnCasillero(new Diamante());
        }
    }
}