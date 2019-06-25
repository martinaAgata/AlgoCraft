package interfaz;

import interfaz.handlers.Salir;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import interfaz.handlers.Jugar;
import static interfaz.ConstantesInterfaz.RUTA_IMG_INICIAL;


public class Inicio extends HBox {

    public Inicio(Stage stage) {

        this.setPrefSize(600, 600);
        Jugar jugarHandler = new Jugar(stage);
        Button botonJugar = new Button("Jugar");
        botonJugar.setOnAction(jugarHandler);

        Salir salirHandler = new Salir();
        Button botonSalir = new Button("Salir");
        botonSalir.setOnAction(salirHandler);

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(botonJugar, botonSalir);
        vbox.setAlignment(Pos.CENTER);

        ImageView iv1 = new ImageView(new Image(RUTA_IMG_INICIAL));
        stage.getIcons().add(new Image(RUTA_IMG_INICIAL));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(iv1, vbox);

        this.getChildren().addAll(stackPane);
    }

}
