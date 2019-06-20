package interfaz;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import handlers.Jugar;


public class Inicio extends HBox {

    private static final String RUTA_IMG_INICIAL = "file:src/imagenes/inicio.jpg";

    public Inicio(Stage stage) {

        Jugar jugarHandler = new Jugar(stage);
        Button botonJugar = new Button("Jugar"); // agregar boton salir
        botonJugar.setOnAction(jugarHandler);

        HBox hbJugar = new HBox();
        hbJugar.getChildren().addAll(botonJugar);
        hbJugar.setAlignment(Pos.CENTER);

        ImageView iv1 = new ImageView(new Image(RUTA_IMG_INICIAL));
        stage.getIcons().add(new Image(RUTA_IMG_INICIAL));

        StackPane stackPane = new StackPane(); // para superponer la img y el boton
        stackPane.getChildren().addAll(iv1, hbJugar);

        this.getChildren().addAll(stackPane);
    }

}
