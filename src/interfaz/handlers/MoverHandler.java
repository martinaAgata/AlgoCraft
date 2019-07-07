package interfaz.handlers;

import interfaz.Inventario;
import interfaz.Tablero;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.MaterialSeHaGastadoException;
import modelo.exceptions.NoExisteNingunCasilleroParaLaUbicacionDadaException;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;
import java.io.File;
import static interfaz.ConstantesInterfaz.RUTA_SONIDO_MOVIMIENTO;

public class MoverHandler {

    private final Jugador jugador;
    private Mapa mapa;
    private Tablero tablero;
    private Inventario inventario;

    public MoverHandler(Tablero tablero, Mapa mapa, Jugador jugador, Inventario inventario) {
        this.mapa = mapa;
        this.jugador = jugador;
        this.tablero = tablero;
        this.inventario = inventario;
    }

    public void moverseHacia(KeyCode keyPressed) {
        Media sonido = new Media(new File(RUTA_SONIDO_MOVIMIENTO).toURI().toString());
        try {
            MediaPlayer mediaPlayer = new MediaPlayer(sonido);
            mediaPlayer.setVolume(0.05);
            mediaPlayer.play();
        } catch (MediaException mException) { /* Para que se pueda seguir moviendo si falla el sonido*/ }
        try {
            if (keyPressed == KeyCode.W) jugador.moverseArriba(this.mapa);
            if (keyPressed == KeyCode.D) jugador.moverseALaDerecha(this.mapa);
            if (keyPressed == KeyCode.A) jugador.moverseALaIzquierda(this.mapa);
            if (keyPressed == KeyCode.S) jugador.moverseAbajo(this.mapa);
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException e) {
            this.tablero.actualizarTexto("No hay un casillero en la posición a la que intentaste moverte");
        } catch (MaterialSeHaGastadoException f) {
            this.tablero.actualizarTexto("Se ha guardado un nuevo material en el inventario");
        } catch (HerramientaRotaNoPuedeDesgastarseException g) {
            this.tablero.actualizarTexto("La herramienta actual se ha roto. Clickear sobre otra herramienta para seguir jugando.");
        }
        this.tablero.actualizarTablero();
        this.inventario.actualizarInventario();
    }
}
