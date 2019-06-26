package interfaz.handlers;

import interfaz.PantallaPrincipal;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Jugar implements EventHandler<ActionEvent> {

    private final Stage stage;

    public Jugar(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        PantallaPrincipal pantalla = new PantallaPrincipal();
        Scene escenaJuego = pantalla.getEscena();
        this.stage.setScene(escenaJuego);
    }
}

