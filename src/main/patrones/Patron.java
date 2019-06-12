package main.patrones;

import main.mapa.Mapa;
import main.mapa.Ubicacion;
import main.materiales.Madera;

public abstract class Patron {
    private static final int CANTIDAD_FILAS = 3;
    private static final int CANTIDAD_COLUMNAS = 3;
    Mapa tablero = new Mapa(CANTIDAD_FILAS, CANTIDAD_COLUMNAS);

    public Patron() {
        this.inicializarPatron();
    }

    public void inicializarPatron() {
        this.colocarMango();
    }

    public void colocarMango() {
        Ubicacion ubicacionA = new Ubicacion(2, 2);
        Ubicacion ubicacionB = new Ubicacion(3, 2);
        Madera madera = new Madera();
        this.tablero.ubicarEnCasillero(madera, ubicacionA);
        this.tablero.ubicarEnCasillero(madera, ubicacionB);
    }
}
