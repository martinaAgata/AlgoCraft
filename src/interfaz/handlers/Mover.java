package interfaz.handlers;

import interfaz.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;
import javafx.scene.input.KeyEvent;

public class Mover implements EventHandler<KeyEvent> {

    private final Jugador jugador;
    private Mapa mapa;
    private Tablero tablero;

    public Mover(Tablero tablero, Mapa mapa, Jugador jugador) {
        this.mapa = mapa;
        this.jugador = jugador;
        this.tablero = tablero;
    }

    @Override
    public void handle(KeyEvent event) {
        if(event.getCode() == KeyCode.W) jugador.moverseArriba(this.mapa);
        if(event.getCode() == KeyCode.D) jugador.moverseALaDerecha(this.mapa);
        if(event.getCode() == KeyCode.A) jugador.moverseALaIzquierda(this.mapa);
        if(event.getCode() == KeyCode.S) jugador.moverseAbajo(this.mapa);
        this.tablero.actualizarTablero();
    }
}
