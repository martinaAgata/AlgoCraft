package interfaz;

import static interfaz.ConstantesInterfaz.*;
import interfaz.handlers.EntradaTecladoHandler;
import interfaz.handlers.MoverHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import modelo.juego.Juego;
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
    private Inventario parteInferior;
    private Juego juego;

    public PantallaPrincipal() {
        super();
        this.setPrefSize(480,480);
        this.inicializarContenedorImagenes();
        this.juego = new Juego();
        this.tablero = new Tablero(this.contenedorImagenes, this.juego);
        this.tablero.setPrefSize(480,480);
        this.parteInferior = new Inventario(this.juego.obtenerInventarioMaterialesJugador(),
                                          this.juego.obtenerInventarioHerramientas());
        this.tablero.getChildren().add(parteInferior);
        this.getChildren().addAll(tablero);
        this.tablero.actualizarTexto("¡Bienvenidx! Usar teclas WASD para moverse y " +
                "recolectar materiales, tecla C para\n construir herramientas y click sobre una herramienta " +
                "para elegirla para ser utilizada.");

    }

    public Tablero obtenerTablero(){
        return tablero;
    }

    private void inicializarContenedorImagenes() {
        this.contenedorImagenes = new HashMap<>();
        this.contenedorImagenes.put((new Madera()).getClass().getName(), new Image(RUTA_IMG_MADERA_CON_PASTO));
        this.contenedorImagenes.put((new Piedra()).getClass().getName(), new Image(RUTA_IMG_PIEDRA_CON_PASTO));
        this.contenedorImagenes.put((new Metal()).getClass().getName(), new Image(RUTA_IMG_METAL_CON_PASTO));
        this.contenedorImagenes.put((new Diamante()).getClass().getName(), new Image(RUTA_IMG_DIAMANTE_CON_PASTO));
        this.contenedorImagenes.put(new Jugador(null,null,null).getClass().getName(), new Image(RUTA_IMG_JUGADOR));
        this.contenedorImagenes.put(new NullUbicable(null).getClass().getName(), new Image(RUTA_IMG_PASTO));
    }

    public Scene getEscena() {
        Scene escenaJuego = new Scene(this);
        escenaJuego.setOnKeyPressed(new EntradaTecladoHandler(this.tablero, this.juego.obtenerMapa(),
                                this.juego.obtenerJugador(), this.parteInferior));
        return escenaJuego;
    }

    public void actualizarInventariosInterfaz(){
        this.parteInferior.actualizarInventarioMateriales();
        this.parteInferior.actualizarInventarioHerramientas();
    }
}
