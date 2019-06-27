package interfaz.handlers;

import interfaz.AbrirInterfazCrafteo;
import interfaz.CrafteoController;
import interfaz.Inventario;
import interfaz.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;

public class EntradaTecladoHandler implements EventHandler<KeyEvent> {
    private Mover moverJugador;
    private CrafteoController crafteoController;


    public EntradaTecladoHandler(Tablero tablero, Mapa mapa, Jugador jugador, Inventario inventario){
        this.moverJugador = new Mover(tablero, mapa, jugador, inventario);
        this.crafteoController = new CrafteoController(tablero.obtenerJuego());
    }

    @Override
    public void handle(KeyEvent key) {
        if(key.getCode() == KeyCode.C) this.crafteoController.iniciarInterfaz();
        this.moverJugador.moverseHacia(key.getCode());
    }
}
