package interfaz;


import interfaz.handlers.Salir;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import interfaz.handlers.Jugar;


import static interfaz.ConstantesInterfaz.*;


public class Inicio extends HBox {

    public Inicio(Stage stage) {
        this.setPrefSize(600, 600);

        stage.getIcons().add(new Image(RUTA_IMG_LOGO));

        Jugar jugarHandler = new Jugar(stage);
        Hyperlink botonJugar = new Hyperlink();
        botonJugar.setGraphic(new ImageView(new Image(RUTA_IMG_JUGAR)));
        botonJugar.setBorder(Border.EMPTY);
        botonJugar.setAlignment(Pos.CENTER);
        botonJugar.setOnAction(jugarHandler);

        Salir salirHandler = new Salir();
        Hyperlink botonSalir = new Hyperlink();
        botonSalir.setGraphic(new ImageView(new Image(RUTA_IMG_SALIR)));
        botonJugar.setBorder(Border.EMPTY);
        botonSalir.setAlignment(Pos.CENTER);
        botonSalir.setOnAction(salirHandler);

        ImageView titulo = new ImageView(new Image(RUTA_IMG_TITULO));
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(titulo);
        hbox.setPadding(new Insets(0,0,30,0));

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(hbox, botonJugar, botonSalir);
        vbox.setAlignment(Pos.CENTER);

        ImageView fondo = new ImageView(new Image(RUTA_IMG_INICIAL));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(fondo, vbox);

        this.getChildren().addAll(stackPane);
    }

}
