package interfaz;

import interfaz.Tablero;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.juego.Juego;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static interfaz.ConstantesInterfaz.*;


public class AbrirInterfazCrafteo {
    private Stage ventanaEmergente;
    private Juego juego;

    public AbrirInterfazCrafteo(Tablero tablero){

    }

    public void iniciar() {
        //System.out.println("Iniciar Interfaz Crafteo");
        ventanaEmergente = new Stage();
        ventanaEmergente.setTitle("AlgoCraft");
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        FileInputStream fxmlStream;
        AnchorPane tableroCraft;
        try{
            fxmlStream = new FileInputStream("/home/jenko/Documents/GitHub/AlgoCraft/src/interfaz/tableroCraft.fxml");//Cambiar x path correspondiente
            tableroCraft = (AnchorPane) loader.load(fxmlStream);}
        catch (IOException IOExp){
            System.err.println("Error en la ruta de carga de tableroCraft.fxml");
            return;
        }
        ImageView backgroundImgV = (ImageView) tableroCraft.getChildren().get(0);
        backgroundImgV.setImage(new Image(RUTA_IMG_TABLERO_CRAFTEO));
        GridPane tableroGrid = (GridPane) tableroCraft.getChildren().get(1);
        inicializarGridPanetablero(tableroGrid);
        //tableroCraft.getChildren().set(1, tableroGrid);
        HBox inventarioMateriales = (HBox) tableroCraft.getChildren().get(2);
        inicializarInventarioHBox(inventarioMateriales);
        ImageView herrambientaCrafteable = (ImageView) tableroCraft.getChildren().get(3);
        Scene scene = new Scene(tableroCraft, tableroCraft.getMaxWidth(), tableroCraft.getMaxHeight());
        ventanaEmergente.setScene(scene);
        ventanaEmergente.show();
    }


    private void inicializarGridPanetablero(GridPane gPane){
        double linesGap = 10;
        gPane.setHgap(3);
        for(int x=0; x < 3; x++){
            for(int y=0; y < 3; y++){
                ImageView imgV = new ImageView(new Image(RUTA_IMG_EMPTY_CRAFT_SPACE));
                imgV.setFitWidth((gPane.getColumnConstraints().get(0).getPrefWidth()-linesGap));
                imgV.setFitHeight((gPane.getRowConstraints().get(0).getPrefHeight()-linesGap));
                imgV.setOnMouseClicked(event -> {System.out.println("Casillero");}/*EventHandler para colocar el material donde corresponde*/);
                gPane.add(imgV,y,x);
            }
        }
    }

    private void inicializarInventarioHBox(HBox hBox){
        hBox.setSpacing(14);
        ImageView imgV;
        ArrayList<String> rutasMateriales = new ArrayList<>();
        rutasMateriales.add(RUTA_IMG_DIAMANTE);
        rutasMateriales.add(RUTA_IMG_MADERA);
        rutasMateriales.add(RUTA_IMG_PIEDRA);
        rutasMateriales.add(RUTA_IMG_METAL);
        for (String path : rutasMateriales) {
            imgV = new ImageView(new Image(path,45,45,false,true));
            imgV.setOnMouseClicked(event -> {
                System.out.println("Material elegible");
            }/*EventHandler para seleccionar el material a colocar*/);
            hBox.getChildren().add(imgV);
        }
    }
}
