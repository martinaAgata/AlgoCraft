package modelo.patrones;

import modelo.mapa.Ubicacion;
import modelo.materiales.Material;
import static modelo.juego.ConstantesJuego.MATERIAL_MANGO;

public class PatronHacha extends Patron {

    public PatronHacha(Material material) {
        this.inicializarPatron(material);
    }

    public void inicializarPatron(Material material) {
        this.colocarMango(MATERIAL_MANGO);
        this.colocarCabeza(material);
    }

    public void colocarCabeza(Material material) {
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(1, 2);
        this.tablero.ubicarEnCasillero(material, ubicacionA);
        this.tablero.ubicarEnCasillero(material, ubicacionB);
        this.tablero.ubicarEnCasillero(material, ubicacionC);
    }
}