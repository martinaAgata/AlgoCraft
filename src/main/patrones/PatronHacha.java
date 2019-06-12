package main.patrones;

import main.mapa.Ubicacion;
import main.materiales.Material;

public class PatronHacha extends Patron {

    public void colocarCabeza(Material material) {
        Ubicacion ubicacionA = new Ubicacion(2, 1);
        Ubicacion ubicacionB = new Ubicacion(1, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        this.tablero.ubicarEnCasillero(material, ubicacionA);
        this.tablero.ubicarEnCasillero(material, ubicacionB);
    }
}