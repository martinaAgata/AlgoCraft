/*package interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.juego.Juego;

public class AlgoCraftApp extends Application {

    Juego juego = new Juego();
    GraficadorTableroPrincipal graficador = new GraficadorTableroPrincipal(juego);
    GridPane grid = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoCraft");

        graficador.crearContenido(grid);
        Scene scene = new Scene(grid, 350, 350);

        stage.setScene(scene);
        stage.show();
    }
}
*/