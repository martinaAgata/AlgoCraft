package interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import modelo.juego.Juego;

public class AlgoCraftApp extends Application {

    Juego juego = new Juego();
    //GraficadorTableroPrincipal graficador = new GraficadorTableroPrincipal(juego);
    GridPane grid = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoCraft");

        //graficador.crearContenido(grid);
        crearContenido(this.grid);
        Scene scene = new Scene(grid, 350, 350);

        stage.setScene(scene);
        stage.show();
    }

    public void crearContenido(GridPane grid) {
        grid.setPrefSize(3, 3);
        for (int y=0; y<3; y++) {
            for (int x=0; x<3; x++) {
                Rectangle r = new Rectangle();
                r.setWidth(2);
                r.setHeight(2);
                r.setFill(Color.RED);
                //GridPane.setRowIndex(r, y);
                //GridPane.setColumnIndex(r, x);
                //grid.getChildren().addAll(r);
                // square.widthProperty().bind(root.widthProperty().divide(size));
                // square.heightProperty().bind(root.heightProperty().divide(size));
                grid.add(r, x, y);
            }
        }
    }
}
