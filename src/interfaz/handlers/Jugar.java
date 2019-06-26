package interfaz.handlers;

import interfaz.PantallaPrincipal;
import interfaz.Tablero;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Jugar implements EventHandler<ActionEvent> {

    private final Stage stage;

    public Jugar(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        PantallaPrincipal pantalla = new PantallaPrincipal();
        Scene escenaJuego = new Scene(pantalla);
        this.stage.setScene(escenaJuego);
        Tablero tablero = pantalla.obtenerTablero();
        stage.addEventHandler(KeyEvent.KEY_TYPED, new Mover(tablero, tablero.obtenerJuego().obtenerMapa(), tablero.obtenerJuego().obtenerJugador()));
        //Para que Mover actue en el mapa tiene que ser agregado al stage, pero x su constructor necesita que le pasen el tablero
        //Y no es accesible desde aca.
    }
}

