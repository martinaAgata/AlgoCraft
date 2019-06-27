package interfaz.handlers;

import interfaz.AbrirInterfazCrafteo;
import interfaz.CrafteoController;
import interfaz.Inventario;
import interfaz.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;

import java.io.File;

import static interfaz.ConstantesInterfaz.RUTA_SONIDO_MOVIMIENTO;

public class EntradaTecladoHandler implements EventHandler<KeyEvent> {
    private Mover moverJugador;
    private CrafteoController crafteoController;


    public EntradaTecladoHandler(Tablero tablero, Mapa mapa, Jugador jugador, Inventario inventario){
        this.moverJugador = new Mover(tablero, mapa, jugador, inventario);
        this.crafteoController = new CrafteoController(tablero.obtenerJuego());
    }

    @Override
    public void handle(KeyEvent key) {
        if(key.getCode() == KeyCode.C) {
            Media sonido = new Media(new File(RUTA_SONIDO_MOVIMIENTO).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sonido);
            mediaPlayer.setVolume(0.05);
            mediaPlayer.play();
            this.crafteoController.iniciarInterfaz();
        }
        this.moverJugador.moverseHacia(key.getCode());
    }
}
