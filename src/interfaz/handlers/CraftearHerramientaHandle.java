package interfaz.handlers;

import interfaz.CrafteoController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CraftearHerramientaHandle implements EventHandler<MouseEvent> {
    private CrafteoController craftController;
    public CraftearHerramientaHandle(CrafteoController craftC){
        this.craftController = craftC;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("CraftearHerramienta");
        this.craftController.crearHerramientaCrafteada();
    }
}
