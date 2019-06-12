package main.patrones;

import main.mapa.Ubicacion;
import main.materiales.Material;

public class PatronPicoFino extends Patron {

    public PatronPicoFino(Material material) {
        this.inicializarPatron(material);
    }

    public void inicializarPatron(Material material) {
        this.colocarMango(MATERIAL_MANGO);
        this.colocarCabeza(material);
        this.colocarPunta(MATERIAL_PUNTA_PICO_FINO);
    }

    public void colocarCabeza(Material material) {
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 2);
        Ubicacion ubicacionC = new Ubicacion(1, 3);
        this.tablero.ubicarEnCasillero(material, ubicacionA);
        this.tablero.ubicarEnCasillero(material, ubicacionB);
        this.tablero.ubicarEnCasillero(material, ubicacionC);
    }
    public void colocarPunta(Material material) {
        Ubicacion ubicacion = new Ubicacion(2, 1);
        this.tablero.ubicarEnCasillero(material, ubicacion);
    }
}
