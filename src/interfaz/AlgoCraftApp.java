package interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AlgoCraftApp extends Application {
    private Inicio inicio;

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoCraft");
        inicio = new Inicio(stage);
        Scene scene = new Scene(inicio, 564, 564, Color.BLACK ); // no hardcodear estos nums
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }

}