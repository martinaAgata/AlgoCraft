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
        super();

        Jugar jugarHandler = new Jugar(stage);
        Button botonJugar = new Button("Jugar");
        botonJugar.setOnAction(jugarHandler);
        // agregar boton salir

        HBox hbJugar = new HBox();
        hbJugar.getChildren().addAll(botonJugar);
        hbJugar.setAlignment(Pos.CENTER);

        final Image imagenInicial = new Image(RUTA_IMG_INICIAL);
        final ImageView iv1 = new ImageView();
        iv1.setImage(imagenInicial);
        stage.getIcons().add(imagenInicial);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(iv1, hbJugar);

        HBox root = new HBox();
        root.getChildren().add(stackPane);
        this.getChildren().addAll(root);
    }

}
