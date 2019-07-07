package interfaz.handlers;

import interfaz.PantallaPrincipal;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import static interfaz.ConstantesInterfaz.RUTA_SONIDO_DESTELLO;

public class JugarHandler implements EventHandler<ActionEvent> {

    private final Stage stage;

    public JugarHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        PantallaPrincipal pantalla = new PantallaPrincipal();
        Scene escenaJuego = pantalla.getEscena();
        this.stage.setScene(escenaJuego);
        Media sonido = new Media(new File(RUTA_SONIDO_DESTELLO).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sonido);
        mediaPlayer.setVolume(0.05);
        mediaPlayer.play();
    }
}

