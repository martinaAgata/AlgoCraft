package interfaz;

import interfaz.handlers.ElegirHerramientaHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import modelo.herramientas.Herramienta;
import modelo.materiales.*;

import java.util.ArrayList;
import java.util.HashMap;

import static interfaz.ConstantesInterfaz.*;
import static javafx.geometry.Pos.CENTER;

public class Inventario extends VBox {
    private HBox hboxMateriales;
    private HBox hboxHerramientas;
    private HashMap<Material, Integer> inventarioMateriales;
    private HashMap<Herramienta, ArrayList<Herramienta>> inventarioHerramientas;

    public Inventario(HashMap<Material, Integer> inventarioMateriales,
                      HashMap<Herramienta, ArrayList<Herramienta>> inventarioHerramientas) {
        this.inventarioMateriales = inventarioMateriales;
        this.inventarioHerramientas = inventarioHerramientas;
        hboxHerramientas = new HBox(10);
        hboxMateriales = new HBox(10);
        this.crearInventarioMateriales();
        this.crearInventarioHerramientas();
        this.getChildren().add(this.hboxMateriales);
        this.getChildren().add(this.hboxHerramientas);
    }
    private void crearInventarioMateriales() {
        this.hboxMateriales.setAlignment(CENTER);
        this.setPrefWidth(480);
        this.hboxMateriales.setSpacing(5);

        /*----- Contador Madera -----*/
        ImageView imgMadera = new ImageView(new Image(RUTA_IMG_MADERA));
        imgMadera.setFitHeight(40);
        imgMadera.setFitWidth(40);
        Label contadorMadera = new Label();
        contadorMadera.setFont(new Font(20));
        Integer cantidadMaderas = this.inventarioMateriales.get(new Madera());
        contadorMadera.setText("" + cantidadMaderas);
        contadorMadera.setGraphic(imgMadera);

        /*----- Contador Piedra -----*/
        ImageView imgPiedra = new ImageView(new Image(RUTA_IMG_PIEDRA));
        imgPiedra.setFitHeight(40);
        imgPiedra.setFitWidth(40);
        Label contadorPiedra = new Label();
        contadorPiedra.setFont(new Font(20));
        Integer cantidadPiedras = this.inventarioMateriales.get(new Piedra());
        contadorPiedra.setText("" + cantidadPiedras);
        contadorPiedra.setGraphic(imgPiedra);

        /*----- Contador Metal -----*/
        ImageView imgMetal = new ImageView(new Image(RUTA_IMG_METAL));
        imgMetal.setFitHeight(40);
        imgMetal.setFitWidth(40);
        Label contadorMetal = new Label();
        contadorMetal.setFont(new Font(20));
        Integer cantidadMetales = this.inventarioMateriales.get(new Metal());
        contadorMetal.setText("" + cantidadMetales);
        contadorMetal.setGraphic(imgMetal);

        /*----- Contador Diamante -----*/
        ImageView imgDiamante = new ImageView(new Image(RUTA_IMG_DIAMANTE));
        imgDiamante.setFitHeight(40);
        imgDiamante.setFitWidth(40);
        Label contadorDiamante = new Label();
        contadorDiamante.setFont(new Font(20));
        Integer cantidadDiamante = this.inventarioMateriales.get(new Diamante());
        contadorDiamante.setText("" + cantidadDiamante);
        contadorDiamante.setGraphic(imgDiamante);

        this.hboxMateriales.getChildren().addAll(contadorMadera, contadorPiedra, contadorMetal, contadorDiamante);
    }

    private void crearInventarioHerramientas(){
        this.hboxHerramientas.setAlignment(CENTER);
        this.setPrefWidth(480);
        this.hboxHerramientas.setSpacing(7);

        /*----- Contador Hacha Madera -----*/
        ImageView hachaMadera = new ImageView(new Image(RUTA_IMG_HACHA_MADERA));
        hachaMadera.setFitHeight(40);
        hachaMadera.setFitWidth(40);
        Label contadorHachaMadera = new Label();
        contadorHachaMadera.setFont(new Font(20));
        contadorHachaMadera.setText("4" /*+ variable*/);
        contadorHachaMadera.setGraphic(hachaMadera);
        contadorHachaMadera.setOnMouseClicked(new ElegirHerramientaHandler());

        /*----- Contador Hacha Piedra -----*/
        ImageView hachaPiedra = new ImageView(new Image(RUTA_IMG_HACHA_PIEDRA));
        hachaPiedra.setFitHeight(40);
        hachaPiedra.setFitWidth(40);
        Label contadorHachaPiedra = new Label();
        contadorHachaPiedra.setFont(new Font(20));
        contadorHachaPiedra.setText("4" /*+ variable*/);
        contadorHachaPiedra.setGraphic(hachaPiedra);
        contadorHachaPiedra.setOnMouseClicked(new ElegirHerramientaHandler());

        /*----- Contador Hacha Metal -----*/
        ImageView hachaMetal = new ImageView(new Image(RUTA_IMG_HACHA_METAL));
        hachaMetal.setFitHeight(40);
        hachaMetal.setFitWidth(40);
        Label contadorHachaMetal = new Label();
        contadorHachaMetal.setFont(new Font(20));
        contadorHachaMetal.setText("4" /*+ variable*/);
        contadorHachaMetal.setGraphic(hachaMetal);
        contadorHachaMetal.setOnMouseClicked(new ElegirHerramientaHandler());

        /*----- Contador Pico Madera -----*/
        ImageView picoMadera = new ImageView(new Image(RUTA_IMG_PICO_MADERA));
        picoMadera.setFitHeight(40);
        picoMadera.setFitWidth(40);
        picoMadera.setOnMouseClicked(new ElegirHerramientaHandler());
        Label contadorPicoMadera = new Label();
        contadorPicoMadera.setFont(new Font(20));
        contadorPicoMadera.setText("4" /*+ variable*/);
        contadorPicoMadera.setGraphic(picoMadera);
        contadorPicoMadera.setOnMouseClicked(new ElegirHerramientaHandler());

        /*----- Contador Pico Piedra -----*/
        ImageView picoPiedra = new ImageView(new Image(RUTA_IMG_PICO_PIEDRA));
        picoPiedra.setFitHeight(40);
        picoPiedra.setFitWidth(40);
        Label contadorPicoPiedra = new Label();
        contadorPicoPiedra.setFont(new Font(20));
        contadorPicoPiedra.setText("4" /*+ variable*/);
        contadorPicoPiedra.setGraphic(picoPiedra);
        contadorPicoPiedra.setOnMouseClicked(new ElegirHerramientaHandler());
        picoPiedra.setOnMouseClicked(new ElegirHerramientaHandler());

        /*----- Contador Pico Metal -----*/
        ImageView picoMetal = new ImageView(new Image(RUTA_IMG_PICO_METAL));
        picoMetal.setFitHeight(40);
        picoMetal.setFitWidth(40);
        picoMetal.setOnMouseClicked(new ElegirHerramientaHandler());
        Label contadorPicoMetal = new Label();
        contadorPicoMetal.setFont(new Font(20));
        contadorPicoMetal.setText("4" /*+ variable*/);
        contadorPicoMetal.setGraphic(picoMetal);
        contadorPicoMetal.setOnMouseClicked(new ElegirHerramientaHandler());

        /*----- Contador Pico Fino -----*/
        ImageView picoFino = new ImageView(new Image(RUTA_IMG_PICO_FINO));
        picoFino.setFitHeight(40);
        picoFino.setFitWidth(40);
        Label contadorPicoFino = new Label();
        contadorPicoFino.setFont(new Font(20));
        contadorPicoFino.setText("4" /*+ variable*/);
        contadorPicoFino.setGraphic(picoFino);
        contadorPicoFino.setOnMouseClicked(new ElegirHerramientaHandler());

        this.hboxHerramientas.getChildren().addAll(contadorHachaMadera, contadorHachaPiedra, contadorHachaMetal,
                                                   contadorPicoMadera,  contadorPicoPiedra,  contadorPicoMetal,
                                                   contadorPicoFino);
    }
}
