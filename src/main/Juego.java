package main;

import main.mapa.Mapa;

public class Juego {
    private static final int CANTIDAD_MADERAS = 70;
    private static final int CANTIDAD_PIEDRAS = 50;
    private static final int CANTIDAD_METALES = 35;
    private static final int CANTIDAD_DIAMANTES = 10;

    public Juego() {
        private Mapa mapa = new Mapa();
        private Jugador jugador = new Jugador();
        posicionarNUbicables(Ubicable ubicable, int n)
    }

    public void posicionarNUbicables(Ubicable ubicable, int n) {
        for (int i=0; i<=n; i++) {
            mapa.ubicarEnCasillero(ubicable);
    }

}
