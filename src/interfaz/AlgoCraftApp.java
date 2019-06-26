package interfaz;

import interfaz.handlers.Mover;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.juego.Juego;

public class AlgoCraftApp extends Application {
    private Inicio inicio;
    private static Juego juego;
    private static final int ANCHO = 564;
    private static final int ALTO = 564;

    @Override
    public void start(Stage stage) {
        //juego = new Juego();
        stage.setTitle("AlgoCraft");
        inicio = new Inicio(stage);
        Scene scene = new Scene(inicio, ANCHO, ALTO, Color.BLACK );
        //moverJugador = new Mover(null, juego.obtenerMapa(), juego.obtenerJugador());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //juego = new Juego();
        //juego.jugar();
        launch(args);
    }

}