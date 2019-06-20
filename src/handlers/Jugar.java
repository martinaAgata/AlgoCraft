package handlers;

import interfaz.ContenedorTablero;
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
        ContenedorTablero contenedor = new ContenedorTablero();
        Scene escenaJuego = new Scene(contenedor);
        this.stage.setScene(escenaJuego);
    }
}

