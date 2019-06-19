package interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgoCraftApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoCraft");
        Contenedor contenedor = new Contenedor();
        Scene escena = new Scene(contenedor);
        stage.setScene(escena);
        stage.show();
    }
}
