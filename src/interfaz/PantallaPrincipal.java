package interfaz;

import static interfaz.ConstantesInterfaz.*;

import interfaz.handlers.Mover;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import modelo.juego.Jugador;
import modelo.juego.NullUbicable;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import java.util.HashMap;


public class PantallaPrincipal extends VBox {
    private Tablero tablero;
    private HashMap<String, Image> contenedorImagenes;
    private Inventario inventarios;
    private Mover moverHandler;

    public PantallaPrincipal() {
        super();
        this.setPrefSize(480,480);
        this.inicializarContenedorImagenes();
        this.tablero = new Tablero(this.contenedorImagenes);
        this.tablero.setPrefSize(480,480);
        this.inventarios = new Inventario();
        this.tablero.getChildren().add(inventarios);
        this.getChildren().addAll(tablero);
    }

    private void inicializarContenedorImagenes() {
        this.contenedorImagenes = new HashMap<>();
        this.contenedorImagenes.put((new Madera()).getClass().getName(), new Image(RUTA_IMG_MADERA_CON_PASTO));
        this.contenedorImagenes.put((new Piedra()).getClass().getName(), new Image(RUTA_IMG_PIEDRA_CON_PASTO));
        this.contenedorImagenes.put((new Metal()).getClass().getName(), new Image(RUTA_IMG_METAL_CON_PASTO));
        this.contenedorImagenes.put((new Diamante()).getClass().getName(), new Image(RUTA_IMG_DIAMANTE_CON_PASTO));
        this.contenedorImagenes.put(new Jugador(null).getClass().getName(), new Image(RUTA_IMG_JUGADOR));
        this.contenedorImagenes.put(new NullUbicable().getClass().getName(), new Image(RUTA_IMG_PASTO));
    }

}
