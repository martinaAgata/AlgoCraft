package modelo.patrones;

import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Material;
import static modelo.juego.ConstantesJuego.CANTIDAD_COLUMNAS_CRAFTEO;
import static modelo.juego.ConstantesJuego.CANTIDAD_FILAS_CRAFTEO;

public abstract class Patron {

    Mapa tablero = new Mapa(CANTIDAD_FILAS_CRAFTEO, CANTIDAD_COLUMNAS_CRAFTEO);

    public void colocarMango(Material material) {
        Ubicacion ubicacionA = new Ubicacion(2, 2);
        Ubicacion ubicacionB = new Ubicacion(2, 3);
        this.tablero.ubicarEnCasillero(material, ubicacionA);
        this.tablero.ubicarEnCasillero(material, ubicacionB);
    }

    public Mapa getMapa() { return this.tablero; }
}
