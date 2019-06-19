package interfaz;

import javafx.scene.layout.*;
import main.Juego;
import main.mapa.Mapa;

public class Contenedor extends GridPane {

    private Juego juego;
    private Mapa mapa;

    public Contenedor() {
        this.juego = new Juego();
        this.mapa = this.juego.obtenerMapa();
    };
}