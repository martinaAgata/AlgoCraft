package main.patrones;

import main.mapa.Mapa;

public abstract class Patron {
    private static final int CANTIDAD_FILAS = 3;
    private static final int CANTIDAD_COLUMNAS = 3;
    Mapa tablero = new Mapa(CANTIDAD_FILAS, CANTIDAD_COLUMNAS);
    public Patron() {
        this.colocarMango();
    }
    public void colocarMango() {
        this.tablero.ubicarEnCasillero();
    }
}
