package interfaz.handlers;

import interfaz.CrafteoController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;

public class SalirCrafteoHandler implements EventHandler<WindowEvent> {
    private CrafteoController craftController;
    public SalirCrafteoHandler(CrafteoController craftC){
        this.craftController = craftC;
    }


    @Override
    public void handle(WindowEvent event) {
        if(event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) this.craftController.vaciarMatrizCrafteo();
    }
}
