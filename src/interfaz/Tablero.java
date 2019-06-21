package interfaz;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.juego.Juego;
import modelo.juego.Ubicable;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;

import java.util.HashMap;

public class Tablero extends HBox {
    private final GridPane grid = new GridPane();
    private Juego juego;
    private final Mapa mapa;
    private final int alto, ancho;
    private final HashMap<String,Image> contenedorImagenes;

    public Tablero(HashMap<String,Image> contenedorImagenes) {
        this.juego = new Juego();
        this.juego.inicializarJuego();
        this.mapa = juego.obtenerMapa();
        this.alto = juego.obtenerMapa().obtenerCantidadFilas();
        this.ancho = juego.obtenerMapa().obtenerCantidadColumnas();
        this.contenedorImagenes = contenedorImagenes;
        crearContenidoTablero();
        this.getChildren().addAll(this.grid);
    }
    private void crearContenidoTablero() {
        this.grid.setHgap(5);
        this.grid.setVgap(5);
        this.grid.setPrefSize(600, 600);
        Ubicable ubicable;
        for (int y=1; y<=this.alto; y++) {
            for (int x=1; x<=this.ancho; x++) {
                ubicable = this.mapa.obtenerCasillero(new Ubicacion(x,y)).obtenerUbicable();
                Image img;
                if(ubicable == null) img = contenedorImagenes.get("");
                else img = contenedorImagenes.get(ubicable.getClass().getName());

                ImageView imgV = new ImageView(img);
                imgV.setFitHeight(40);
                imgV.setFitWidth(40);
                this.grid.add(imgV, y, x);
            }
        }
        this.grid.setAlignment(Pos.CENTER);
    }
}