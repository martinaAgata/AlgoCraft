package interfaz;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import modelo.herramientas.Herramienta;
import modelo.juego.Juego;
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
    private HBox hboxTexto;
    private Text texto;

    public Tablero(HashMap<String,Image> contenedorImagenes, Juego juego) {
        this.juego = juego;
        this.setPrefSize(480, 480);
        this.setSpacing(5);
        this.grid.setHgap(5);
        this.grid.setVgap(5);
        this.grid.setPrefSize(600, 600);
        this.grid.setAlignment(Pos.CENTER);
        this.juego.inicializarJuego();
        this.mapa = juego.obtenerMapa();
        this.alto = juego.obtenerMapa().obtenerCantidadFilas();
        this.ancho = juego.obtenerMapa().obtenerCantidadColumnas();
        this.contenedorImagenes = contenedorImagenes;
        this.crearCajaDeTexto();
        this.actualizarTablero();
        this.getChildren().addAll(this.hboxTexto, this.grid);
    }

    public void actualizarTablero() {
        Ubicable ubicable;
        for (int x=1; x<=this.alto; x++) {
            for (int y=1; y<=this.ancho; y++) {
                ubicable = this.mapa.obtenerCasillero(new Ubicacion(x,y)).obtenerUbicable();
                Image img = contenedorImagenes.get(ubicable.getClass().getName());
                ImageView imgV = new ImageView(img);
                imgV.setFitHeight(40);
                imgV.setFitWidth(40);
                this.grid.add(imgV, y, x);
            }
        }
    }

    private void crearCajaDeTexto() {
        this.texto = new Text();
        this.texto.setTextAlignment(TextAlignment.CENTER);
        hboxTexto = new HBox(this.texto);
        hboxTexto.setPadding(new Insets(10, 0, 0, 0));
        this.hboxTexto.setAlignment(Pos.CENTER);
    }

    public void actualizarTexto(String string) {
        this.texto.setText(string);
    }

    public Juego obtenerJuego(){ return this.juego; }

    public void seleccionarHerramientaAUtilizar(Herramienta herramienta){
        this.juego.seleccionarHerramientaAUtilizar(herramienta);
    }
}