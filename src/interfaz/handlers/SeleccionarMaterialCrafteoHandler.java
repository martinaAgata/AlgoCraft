package interfaz.handlers;

import interfaz.CrafteoController;
import interfaz.ImageViewMaterial;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public class SeleccionarMaterialCrafteoHandler implements EventHandler<MouseEvent> {
    private CrafteoController craftController;
    public SeleccionarMaterialCrafteoHandler(CrafteoController craftC){
        this.craftController = craftC;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("SeleccionarMaterial");
        ImageViewMaterial imgV = (ImageViewMaterial) event.getSource();
        this.craftController.colocarMaterial(imgV);
    }

}
