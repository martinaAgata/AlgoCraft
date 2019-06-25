package interfaz.handlers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Salir implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) { Platform.exit(); }
}