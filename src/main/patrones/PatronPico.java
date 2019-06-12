package main.patrones;

import main.mapa.Ubicacion;
import main.materiales.Material;

public class PatronPico extends Patron {

    public PatronPico(Material material) {
        this.inicializarPatron(material);
    }

    public void inicializarPatron(Material material) {
        this.colocarMango(MATERIAL_MANGO);
        this.colocarCabeza(material);
    }

    public void colocarCabeza(Material material) {
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 2);
        Ubicacion ubicacionC = new Ubicacion(1, 3);
        this.tablero.ubicarEnCasillero(material, ubicacionA);
        this.tablero.ubicarEnCasillero(material, ubicacionB);
        this.tablero.ubicarEnCasillero(material, ubicacionC);
    }
}
