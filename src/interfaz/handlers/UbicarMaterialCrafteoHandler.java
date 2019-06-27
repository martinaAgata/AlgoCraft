package interfaz.handlers;

import interfaz.CrafteoController;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class UbicarMaterialCrafteoHandler implements EventHandler<MouseEvent> {
    private CrafteoController craftController;
    public UbicarMaterialCrafteoHandler(CrafteoController craftC){
        this.craftController = craftC;
    }

    @Override
    public void handle(MouseEvent event) {
        ImageView imgV = (ImageView) event.getSource();
        this.craftController.setearMaterial(imgV);
    }
}
