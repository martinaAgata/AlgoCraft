package interfaz.handlers;

import interfaz.*;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;

import java.io.File;

import static interfaz.ConstantesInterfaz.RUTA_SONIDO_MOVIMIENTO;

public class EntradaTecladoHandler implements EventHandler<KeyEvent> {
    private MoverHandler moverJugador;
    private CrafteoController crafteoController;
    private PantallaPrincipal pantallaPrincipal;


    public EntradaTecladoHandler(Tablero tablero, Mapa mapa, Jugador jugador, Inventario inventario){
        this.moverJugador = new MoverHandler(tablero, mapa, jugador, inventario);
        this.crafteoController = new CrafteoController(tablero.obtenerJuego(), tablero);
        this.pantallaPrincipal = (PantallaPrincipal) tablero.getParent();
    }

    @Override
    public void handle(KeyEvent key) {
        if(key.getCode() == KeyCode.C) {
            try {
                Media sonido = new Media(new File(RUTA_SONIDO_MOVIMIENTO).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sonido);
                mediaPlayer.setVolume(0.05);
                mediaPlayer.play();
            }
            catch (MediaException e){/*Try creado para que se pueda seguir si no se puede reproducir sonido*/ }
            this.crafteoController.iniciarInterfaz();
        }
        else this.moverJugador.moverseHacia(key.getCode());
        this.pantallaPrincipal.actualizarInventariosInterfaz();
    }
}
