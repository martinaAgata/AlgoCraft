package interfaz;

import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import modelo.juego.Jugador;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;

import java.util.HashMap;

public class PantallaPrincipal extends HBox {

    private static final String RUTA_IMG_MADERA = "file:src/imagenes/madera.jpg";
    private static final String RUTA_IMG_PIEDRA = "file:src/imagenes/piedra.jpg";
    private static final String RUTA_IMG_METAL = "file:src/imagenes/metal.jpg";
    private static final String RUTA_IMG_PASTO = "file:src/imagenes/pasto.jpg";
    private static final String RUTA_IMG_DIAMANTE = "file:src/imagenes/diamante.jpg";
    private static final String RUTA_IMG_JUGADOR = "file:src/imagenes/jugador.jpg";
    private Tablero tablero;
    private HashMap<String, Image> contenedorImagenes;


    public PantallaPrincipal() {
        super();
        this.inicializarContenedorImagenes();
        this.tablero = new Tablero(this.contenedorImagenes);
        this.getChildren().addAll(tablero);
    };

    private void inicializarContenedorImagenes() {
        this.contenedorImagenes = new HashMap<>();
        this.contenedorImagenes.put(Madera.class.getName(), new Image(RUTA_IMG_MADERA));
        this.contenedorImagenes.put(Piedra.class.getName(), new Image(RUTA_IMG_PIEDRA));
        this.contenedorImagenes.put(Metal.class.getName(), new Image(RUTA_IMG_METAL));
        this.contenedorImagenes.put(Diamante.class.getClass().getName(), new Image(RUTA_IMG_DIAMANTE));
        this.contenedorImagenes.put(new Jugador(null).getClass().getName(), new Image(RUTA_IMG_JUGADOR));
        this.contenedorImagenes.put("", new Image(RUTA_IMG_PASTO));
    }

}
