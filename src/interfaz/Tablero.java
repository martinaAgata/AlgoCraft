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
    private static final String RUTA_IMG_PASTO = "file:src/imagenes/pasto.jpg";
    private final GridPane grid = new GridPane(); //borrar esto en todos lados, reemplazar por this
    private Juego juego;
    private final Mapa mapa;
    private final int alto, ancho;
    private final HashMap<String,Image> contenedorImagenes;

    public Tablero(HashMap<String,Image> contenedorImagenes) {
        this.juego = new Juego();
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
        Image img;
        for (int y=0; y<this.alto; y++) {
            for (int x=0; x<this.ancho; x++) {
                ubicable = this.mapa.obtenerCasillero(new Ubicacion(x,y)).obtenerUbicable();
                if(ubicable == null) img = contenedorImagenes.get("");
                else img = contenedorImagenes.get(ubicable.getClass().getName());

                ImageView imgV = new ImageView(img);
                imgV.setFitHeight(40);
                imgV.setFitWidth(40);
                this.grid.add(imgV, x, y);
            }
        }
        this.grid.setAlignment(Pos.CENTER);
    }
}