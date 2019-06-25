package interfaz;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.juego.Juego;
import modelo.juego.NullUbicable;
import modelo.juego.Ubicable;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;

import java.util.HashMap;

public class Tablero extends VBox {
    private final GridPane grid = new GridPane();
    private Juego juego;
    private final Mapa mapa;
    private final int alto, ancho;
    private final HashMap<String,Image> contenedorImagenes;

    public Tablero(HashMap<String,Image> contenedorImagenes) {
        this.setPrefSize(480, 480);
        this.setSpacing(5);
        this.grid.setHgap(5);
        this.grid.setVgap(5);
        this.grid.setPrefSize(600, 600);
        this.grid.setAlignment(Pos.CENTER);
        this.juego = new Juego();
        this.juego.inicializarJuego();
        this.mapa = juego.obtenerMapa();
        this.alto = juego.obtenerMapa().obtenerCantidadFilas();
        this.ancho = juego.obtenerMapa().obtenerCantidadColumnas();
        this.contenedorImagenes = contenedorImagenes;
        this.actualizarTablero();
    }
    public void actualizarTablero() {
        Ubicable ubicable;
        for (int y=1; y<=this.alto; y++) {
            for (int x=1; x<=this.ancho; x++) {
                ubicable = this.mapa.obtenerCasillero(new Ubicacion(x,y)).obtenerUbicable();
                Image img = contenedorImagenes.get(ubicable.getClass().getName());
                ImageView imgV = new ImageView(img);
                imgV.setFitHeight(40);
                imgV.setFitWidth(40);
                if(ubicable.getClass() != NullUbicable.class) {
                    imgV.setOnMouseClicked((e) -> {
                        //Desgaste material contra herramienta
                        System.out.println("Se cliqueo un material");
                    });
                }
                this.grid.add(imgV, y, x);
            }
        }
        this.getChildren().addAll(this.grid);
    }
}