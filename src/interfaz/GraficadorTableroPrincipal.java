/*package interfaz;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Material;

public class GraficadorTableroPrincipal {
    private final Juego juego;
    private static final int TAM_BOTON = 30;
    private int alto, ancho;
    private Rectangle borde = new Rectangle(100, 100);
    private static final String RUTA_PASTO = "file:src/interfaz/imagenes/pasto.jpg";

    public GraficadorTableroPrincipal(Juego juego) {
        this.juego = juego;
        this.ancho = juego.obtenerMapa().obtenerCantidadColumnas();
        this.alto = juego.obtenerMapa().obtenerCantidadFilas();
    }

    public void crearContenido(GridPane grid) {
        grid.setPrefSize(this.ancho, this.alto);
        for (int y=0; y<this.alto; y++) {
            for (int x=0; x<this.ancho; x++) {
                Rectangle r = new Rectangle();
                r.setWidth(2);
                r.setHeight(2);
                r.setFill(Color.RED);
                GridPane.setRowIndex(r, y);
                GridPane.setColumnIndex(r, x);
                //grid.getChildren().addAll(r);
                // square.widthProperty().bind(root.widthProperty().divide(size));
                // square.heightProperty().bind(root.heightProperty().divide(size));
                grid.add(r, x, y);
            }
        }
    }
}
*/