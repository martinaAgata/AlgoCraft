package interfaz;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import static interfaz.ConstantesInterfaz.*;

public class Inventario extends VBox {
    private HBox hboxMateriales;
    private HBox hboxHerramientas;

    public Inventario() {
        hboxHerramientas = new HBox(10);
        hboxMateriales = new HBox(10);
        this.crearInventarioMateriales();
        this.crearInventarioHerramientas();
        this.getChildren().add(this.hboxMateriales);
        this.getChildren().add(this.hboxHerramientas);
    }
    private void crearInventarioMateriales() {
        this.hboxMateriales.setAlignment(Pos.CENTER);
        this.setPrefWidth(480);
        this.hboxMateriales.setSpacing(5);
        ImageView madera = new ImageView(new Image(RUTA_IMG_MADERA));
        madera.setFitHeight(40);
        madera.setFitWidth(40);
        ImageView piedra = new ImageView(new Image(RUTA_IMG_PIEDRA));
        piedra.setFitHeight(40);
        piedra.setFitWidth(40);
        ImageView metal = new ImageView(new Image(RUTA_IMG_METAL));
        metal.setFitHeight(40);
        metal.setFitWidth(40);
        ImageView diamante = new ImageView(new Image(RUTA_IMG_DIAMANTE));
        diamante.setFitHeight(40);
        diamante.setFitWidth(40);
        this.hboxMateriales.getChildren().addAll(madera, piedra, metal, diamante);
    }

    private void crearInventarioHerramientas(){
        this.hboxHerramientas.setAlignment(Pos.CENTER);
        this.setPrefWidth(480);
        this.hboxHerramientas.setSpacing(7);
        ImageView hachaMadera = new ImageView(new Image(RUTA_IMG_HACHA_MADERA));
        hachaMadera.setFitHeight(40);
        hachaMadera.setFitWidth(40);
        hachaMadera.setOnMouseClicked((e) ->{ /*Elegir herramienta?*/System.out.println("Es una herramienta");});
        ImageView hachaPiedra = new ImageView(new Image(RUTA_IMG_HACHA_PIEDRA));
        hachaPiedra.setFitHeight(40);
        hachaPiedra.setFitWidth(40);
        hachaPiedra.setOnMouseClicked((e) ->{ /*Elegir herramienta?*/System.out.println("Es una herramienta");});
        ImageView hachaMetal = new ImageView(new Image(RUTA_IMG_HACHA_METAL));
        hachaMetal.setFitHeight(40);
        hachaMetal.setFitWidth(40);
        hachaMetal.setOnMouseClicked((e) ->{ /*Elegir herramienta?*/System.out.println("Es una herramienta");});
        ImageView picoMadera = new ImageView(new Image(RUTA_IMG_PICO_MADERA));
        picoMadera.setFitHeight(40);
        picoMadera.setFitWidth(40);
        picoMadera.setOnMouseClicked((e) ->{ /*Elegir herramienta?*/System.out.println("Es una herramienta");});
        ImageView picoPiedra = new ImageView(new Image(RUTA_IMG_PICO_PIEDRA));
        picoPiedra.setFitHeight(40);
        picoPiedra.setFitWidth(40);
        picoPiedra.setOnMouseClicked((e) ->{ /*Elegir herramienta?*/System.out.println("Es una herramienta");});
        ImageView picoMetal = new ImageView(new Image(RUTA_IMG_PICO_METAL));
        picoMetal.setFitHeight(40);
        picoMetal.setFitWidth(40);
        picoMetal.setOnMouseClicked((e) ->{ /*Elegir herramienta?*/System.out.println("Es una herramienta");});
        ImageView picoFino = new ImageView(new Image(RUTA_IMG_PICO_FINO));
        picoFino.setFitHeight(40);
        picoFino.setFitWidth(40);
        picoFino.setOnMouseClicked((e) ->{ /*Elegir herramienta?*/System.out.println("Es una herramienta");});
        this.hboxHerramientas.getChildren().addAll(hachaMadera, hachaPiedra, hachaMetal, picoMadera, picoPiedra, picoMetal, picoFino);
    }
}
