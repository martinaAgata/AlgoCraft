package main.patrones;

import main.mapa.Mapa;
import main.mapa.Ubicacion;
import main.materiales.Madera;
import main.materiales.Material;
import main.materiales.Metal;
import main.materiales.Piedra;

public abstract class Patron {
    private static final int CANTIDAD_FILAS = 3;
    private static final int CANTIDAD_COLUMNAS = 3;
    Madera MATERIAL_MANGO = new Madera();
    Mapa tablero = new Mapa(CANTIDAD_FILAS, CANTIDAD_COLUMNAS);

    public void colocarMango(Material material) {
        Ubicacion ubicacionA = new Ubicacion(2, 2);
        Ubicacion ubicacionB = new Ubicacion(2, 3);
        this.tablero.ubicarEnCasillero(material, ubicacionA);
        this.tablero.ubicarEnCasillero(material, ubicacionB);
    }

    public Mapa getMapa() { return this.tablero; }
}
