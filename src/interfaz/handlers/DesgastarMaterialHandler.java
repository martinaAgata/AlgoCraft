package interfaz.handlers;

import javafx.event.Event;
import javafx.event.EventHandler;

public class DesgastarMaterialHandler implements EventHandler {
    @Override
    public void handle(Event event) {
        //Desgataria el material de ser correspondiente
        System.out.println("Desgastaria el material segun corresponda");
    }
}
