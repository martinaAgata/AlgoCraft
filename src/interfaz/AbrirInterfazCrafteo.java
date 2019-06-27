package interfaz;

import interfaz.handlers.CraftearHerramientaHandle;
import interfaz.handlers.SeleccionarMaterialCrafteoHandler;
import interfaz.handlers.UbicarMaterialCrafteoHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.juego.NullUbicable;
import modelo.mapa.Casillero;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static interfaz.ConstantesInterfaz.*;


public class AbrirInterfazCrafteo {
    private Stage ventanaEmergente;
    private AnchorPane tableroCraft;
    private GridPane tableroGrid;
    private HBox inventarioMateriales;
    private ImageView herramientaCrafteable;
    private HashMap<String, Image> imagenPorMaterial;

    public AbrirInterfazCrafteo(){
        this.imagenPorMaterial = new HashMap<>();
        this.cargarimagenPorMaterial();

    }

    public void iniciar(SeleccionarMaterialCrafteoHandler seleccionarHandler, UbicarMaterialCrafteoHandler ubicarHandler, CraftearHerramientaHandle craftHandle) {
        ventanaEmergente = new Stage();
        ventanaEmergente.setTitle("Mesa de Crafteo");
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        FileInputStream fxmlStream;
        try{
            fxmlStream = new FileInputStream("src/interfaz/tableroCraft.fxml");//Cambiar x path correspondiente
            tableroCraft = (AnchorPane) loader.load(fxmlStream);}
        catch (IOException IOExp){
            System.err.println("Error en la ruta de carga de tableroCraft.fxml");
            return;
        }
        ImageView backgroundImgV = (ImageView) tableroCraft.getChildren().get(0);
        backgroundImgV.setImage(new Image(RUTA_IMG_TABLERO_CRAFTEO));
        this.tableroGrid = (GridPane) tableroCraft.getChildren().get(1);
        inicializarGridPanetablero(ubicarHandler);
        this.inventarioMateriales = (HBox) tableroCraft.getChildren().get(2);
        testearInventarioHBox(seleccionarHandler);
        this.herramientaCrafteable = (ImageView) tableroCraft.getChildren().get(3);
        this.herramientaCrafteable.setOnMouseClicked(craftHandle);
        Scene scene = new Scene(tableroCraft, tableroCraft.getMaxWidth(), tableroCraft.getMaxHeight());
        ventanaEmergente.setScene(scene);
        ventanaEmergente.show();
    }


    private void inicializarGridPanetablero(UbicarMaterialCrafteoHandler ubicarHandler){
        double linesGap = 10;
        tableroGrid.setHgap(3);
        for(int x=0; x < 3; x++){
            for(int y=0; y < 3; y++){
                ImageView imgV = new ImageView(new Image(RUTA_IMG_EMPTY_CRAFT_SPACE));
                imgV.setFitWidth((tableroGrid.getColumnConstraints().get(0).getPrefWidth()-linesGap));
                imgV.setFitHeight((tableroGrid.getRowConstraints().get(0).getPrefHeight()-linesGap));
                imgV.setOnMouseClicked(ubicarHandler/*EventHandler para colocar el material donde corresponde*/);
                tableroGrid.add(imgV,y,x);
            }
        }
    }

    private void testearInventarioHBox(SeleccionarMaterialCrafteoHandler seleccionarHandler){
        inventarioMateriales.setSpacing(14);
        ImageViewMaterial imgV;
        ArrayList<String> rutasMateriales = new ArrayList<>();
        rutasMateriales.add(RUTA_IMG_DIAMANTE);
        rutasMateriales.add(RUTA_IMG_MADERA);
        rutasMateriales.add(RUTA_IMG_PIEDRA);
        rutasMateriales.add(RUTA_IMG_METAL);
        for (String path : rutasMateriales) {
            imgV = new ImageViewMaterial(new Image(path,45,45,false,true));
            imgV.setOnMouseClicked(seleccionarHandler/*EventHandler para seleccionar el material a colocar*/);
            imgV.setMaterial(new Madera());
            inventarioMateriales.getChildren().add(imgV);
        }
    }

    private void cargarimagenPorMaterial(){
        this.imagenPorMaterial.put((new Madera()).getClass().getName(), new Image(RUTA_IMG_MADERA, 45, 45, false, true));
        this.imagenPorMaterial.put((new Piedra()).getClass().getName(), new Image(RUTA_IMG_PIEDRA, 45, 45, false, true));
        this.imagenPorMaterial.put((new Metal()).getClass().getName(), new Image(RUTA_IMG_METAL, 45, 45, false, true));
        this.imagenPorMaterial.put((new Diamante()).getClass().getName(), new Image(RUTA_IMG_DIAMANTE, 45, 45, false, true));
        this.imagenPorMaterial.put((new NullUbicable(null)).getClass().getName(), new Image(RUTA_IMG_EMPTY_CRAFT_SPACE, 45, 45, false, true));

    }

    public void actualizarTableroCrafteoGrid(Mapa tableroCrafteo, UbicarMaterialCrafteoHandler ubicarHandler){
        ImageView imgV;
        for(int x=0; x < tableroCrafteo.obtenerCantidadFilas(); x++){
            for(int y=0; y < tableroCrafteo.obtenerCantidadColumnas(); y++){
                Casillero casillero = tableroCrafteo.obtenerCasillero(new Ubicacion(x+1,y+1));
                imgV = new ImageView(this.imagenPorMaterial.get(casillero.obtenerUbicable().getClass().getName()));
                imgV.setFitWidth((tableroGrid.getColumnConstraints().get(0).getPrefWidth()-10));
                imgV.setFitHeight((tableroGrid.getRowConstraints().get(0).getPrefHeight()-10));
                imgV.setOnMouseClicked(ubicarHandler);
                this.tableroGrid.add(imgV,y,x);
            }
        }

    }

    public void actualizarInventarioHbox(HashMap<Material, Integer> inventarioMaterialesJugador, SeleccionarMaterialCrafteoHandler seleccionarHandler){
        Set<Material> materiales = inventarioMaterialesJugador.keySet();
        inventarioMateriales.setSpacing(14);
        ImageViewMaterial imgV;
        for(Material material : materiales){
            imgV = new ImageViewMaterial(this.imagenPorMaterial.get(material.getClass().getName()));
            imgV.setMaterial(material);
            imgV.setOnMouseClicked(seleccionarHandler/*EventHandler para seleccionar el material a colocar*/);
            if(inventarioMaterialesJugador.get(material) > 0) this.inventarioMateriales.getChildren().add(imgV);
        }
    }


}
