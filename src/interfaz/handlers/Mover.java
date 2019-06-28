package interfaz.handlers;

import interfaz.Inventario;
import interfaz.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;
import javafx.scene.input.KeyEvent;

import java.io.File;

import static interfaz.ConstantesInterfaz.RUTA_SONIDO_MOVIMIENTO;

public class Mover {

    private final Jugador jugador;
    private Mapa mapa;
    private Tablero tablero;
    private Inventario inventario;

    public Mover(Tablero tablero, Mapa mapa, Jugador jugador, Inventario inventario) {
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
        }catch (MediaException mException) {/*Try creado para que se pueda seguir moviendo si no se puede reproducir sonido*/ }
        if(keyPressed == KeyCode.W) jugador.moverseArriba(this.mapa);
        if(keyPressed == KeyCode.D) jugador.moverseALaDerecha(this.mapa);
        if(keyPressed == KeyCode.A) jugador.moverseALaIzquierda(this.mapa);
        if(keyPressed == KeyCode.S) jugador.moverseAbajo(this.mapa);
        this.tablero.actualizarTablero();
        this.inventario.actualizarInventario();
    }
}
