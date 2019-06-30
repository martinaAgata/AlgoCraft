package interfaz;

import interfaz.handlers.CraftearHerramientaHandle;
import interfaz.handlers.SalirCrafteoHandler;
import interfaz.handlers.SeleccionarMaterialCrafteoHandler;
import interfaz.handlers.UbicarMaterialCrafteoHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.herramientas.Hacha;
import modelo.herramientas.Herramienta;
import modelo.herramientas.Pico;
import modelo.herramientas.PicoFino;
import modelo.juego.NullUbicable;
import modelo.mapa.Casillero;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static interfaz.ConstantesInterfaz.*;
import static modelo.juego.ConstantesJuego.*;


public class AbrirInterfazCrafteo {
    private final double EMPTY_SQUARE_WIDTH = 45;
    private final double EMPTY_SQUARE_HEIGHT = 45;
    private Stage ventanaEmergente;
    private AnchorPane tableroCraft;
    private GridPane tableroGrid;
    private HBox inventarioMateriales;
    private ImageView herramientaCrafteable;
    private HashMap<String, Image> imagenPorMaterial;
    private HashMap<Herramienta, Image> imagenPorHerramienta;

    public AbrirInterfazCrafteo(){
        this.imagenPorMaterial = new HashMap<>();
        this.cargarimagenPorMaterial();
        this.imagenPorHerramienta = new HashMap<>();
        this.cargarImagenPorHerramienta();

    }

    public void iniciar(SeleccionarMaterialCrafteoHandler seleccionarHandler, UbicarMaterialCrafteoHandler ubicarHandler, CraftearHerramientaHandle craftHandle, SalirCrafteoHandler salirHandler) {
        ventanaEmergente = new Stage();
        ventanaEmergente.getIcons().add(new Image(RUTA_IMG_LOGO));
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
        this.herramientaCrafteable = (ImageView) tableroCraft.getChildren().get(3);
        this.herramientaCrafteable.setOnMouseClicked(craftHandle);
        Scene scene = new Scene(tableroCraft, tableroCraft.getMaxWidth(), tableroCraft.getMaxHeight());
        ventanaEmergente.setOnCloseRequest(salirHandler);
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
                tableroGrid.add(imgV,x,y);
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
            imgV = new ImageViewMaterial(new Image(path,EMPTY_SQUARE_WIDTH,EMPTY_SQUARE_HEIGHT,false,true));
            imgV.setOnMouseClicked(seleccionarHandler/*EventHandler para seleccionar el material a colocar*/);
            imgV.setMaterial(new Madera());
            inventarioMateriales.getChildren().add(imgV);
        }
    }

    private void cargarimagenPorMaterial(){
        this.imagenPorMaterial.put((new Madera()).getClass().getName(), new Image(RUTA_IMG_MADERA, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));
        this.imagenPorMaterial.put((new Piedra()).getClass().getName(), new Image(RUTA_IMG_PIEDRA, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));
        this.imagenPorMaterial.put((new Metal()).getClass().getName(), new Image(RUTA_IMG_METAL, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));
        this.imagenPorMaterial.put((new Diamante()).getClass().getName(), new Image(RUTA_IMG_DIAMANTE, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));
        this.imagenPorMaterial.put((new NullUbicable(null)).getClass().getName(), new Image(RUTA_IMG_EMPTY_CRAFT_SPACE, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));

    }

    private void cargarImagenPorHerramienta(){
        this.imagenPorHerramienta.put(new Hacha(DESGASTE_HACHA_MADERA, DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, new Madera()), new Image(RUTA_IMG_HACHA_MADERA, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));
        this.imagenPorHerramienta.put(new Hacha(DESGASTE_HACHA_PIEDRA, DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, new Piedra()), new Image(RUTA_IMG_HACHA_PIEDRA, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));
        this.imagenPorHerramienta.put(new Hacha(DESGASTE_HACHA_METAL, DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, new Metal()), new Image(RUTA_IMG_HACHA_METAL, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));
        this.imagenPorHerramienta.put(new Pico(DESGASTE_PICO_MADERA, DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera()), new Image(RUTA_IMG_PICO_MADERA, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));
        this.imagenPorHerramienta.put(new Pico(DESGASTE_PICO_PIEDRA, DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra()), new Image(RUTA_IMG_PICO_PIEDRA, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));
        this.imagenPorHerramienta.put(new Pico(DESGASTE_PICO_METAL, DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal()), new Image(RUTA_IMG_PICO_METAL, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));
        this.imagenPorHerramienta.put(new PicoFino(DESGASTE_PICO_FINO, DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO), new Image(RUTA_IMG_PICO_FINO, EMPTY_SQUARE_WIDTH, EMPTY_SQUARE_HEIGHT, false, true));

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
                this.tableroGrid.add(imgV,x,y);
            }
        }

    }

    public void actualizarInventarioHbox(HashMap<Material, Integer> inventarioMaterialesJugador, SeleccionarMaterialCrafteoHandler seleccionarHandler){
        this.inventarioMateriales.getChildren().remove(0, this.inventarioMateriales.getChildren().size());
        Set<Material> materiales = inventarioMaterialesJugador.keySet();
        inventarioMateriales.setSpacing(14);
        StackPane imgAndCounterContainer;
        ImageViewMaterial imgV;
        for(Material material : materiales){
            if(inventarioMaterialesJugador.get(material) <= 0) continue;
            imgAndCounterContainer = new StackPane();
            imgAndCounterContainer.setPrefWidth(EMPTY_SQUARE_WIDTH);
            imgAndCounterContainer.setPrefHeight(EMPTY_SQUARE_HEIGHT);
            imgV = new ImageViewMaterial(this.imagenPorMaterial.get(material.getClass().getName()));
            imgV.setMaterial(material);
            imgV.setOnMouseClicked(seleccionarHandler/*EventHandler para seleccionar el material a colocar*/);
            Label cantMaterial = new Label();
            cantMaterial.setFont(new Font(15));
            cantMaterial.setText(inventarioMaterialesJugador.get(material).toString());
            imgAndCounterContainer.getChildren().add(imgV);
            imgAndCounterContainer.getChildren().add(cantMaterial);
            imgAndCounterContainer.setAlignment(Pos.TOP_CENTER);
            imgAndCounterContainer.setAlignment(cantMaterial, Pos.TOP_RIGHT);
            this.inventarioMateriales.getChildren().add(imgAndCounterContainer);
        }
    }

    public void actualizarHerramientaCrafteable(Herramienta herramienta){
        Image imgHerramienta;
        if(herramienta == null) imgHerramienta = new Image(RUTA_IMG_EMPTY_CRAFT_SPACE);
        else imgHerramienta = this.imagenPorHerramienta.get(herramienta);
        this.herramientaCrafteable.setImage(imgHerramienta);
    }


}
