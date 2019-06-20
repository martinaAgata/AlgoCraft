package interfaz;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.herramientas.Hacha;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.juego.Ubicable;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;

public class ContenedorTablero extends GridPane {
    private static final String RUTA_IMG_PASTO = "file:src/imagenes/pasto.jpg";
    private final GridPane grid = new GridPane();
    private Juego juego;
    private final Mapa mapa;
    private final int alto, ancho;

    public ContenedorTablero() {
        this.juego = new Juego();
        this.mapa = juego.obtenerMapa();
        this.alto = juego.obtenerMapa().obtenerCantidadFilas();
        this.ancho = juego.obtenerMapa().obtenerCantidadColumnas();
        crearContenidoTablero();
    }
    private void crearContenidoTablero() {
        this.grid.setHgap(5);
        this.grid.setVgap(5);
        this.grid.setPrefSize(600, 600);
        for (int y=0; y<this.alto; y++) {
            for (int x=0; x<this.ancho; x++) {
                Image img = new Image(RUTA_IMG_PASTO);
                ImageView imgV = new ImageView(img);
                imgV.setFitHeight(40);
                imgV.setFitWidth(40);
                this.grid.add(imgV, x, y);
            }
        }
        this.getChildren().addAll(this.grid);
    }

    private void colocarImagen() {/*
        Ubicable ubicable;
        for (int y=0; y<this.alto; y++) {
            for (int x=0; x<this.ancho; x++) {
                Ubicable ubicable = this.mapa.obtenerCasillero(new Ubicacion(x,y)).obtenerUbicable();
                Image img = new Image(RUTA_IMG_PASTO);
                ImageView imgV = new ImageView(img);
                imgV.setFitHeight(40);
                imgV.setFitWidth(40);
                this.grid.add(imgV, x, y);
            }
        }*/
    }

    private void identificadorUbicable() {};


}