package interfaz.handlers;

import interfaz.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;
import modelo.exceptions.NoExisteNingunCasilleroParaLaUbicacionDadaException;
import modelo.exceptions.NoSePuedeUbicarPorqueEstaOcupadoException;

public class Mover implements EventHandler<KeyEvent> {

    private final Jugador jugador;
    private Mapa mapa;

    public Mover(Tablero tablero, Mapa mapa, Jugador jugador) {
        this.mapa = mapa;
        this.jugador = jugador;
        tablero.actualizarTablero();
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) { // atajar excepciones
            case W:
                jugador.moverseArriba(this.mapa);
                break;
            case S:
                jugador.moverseAbajo(this.mapa);
                break;
            case D:
                jugador.moverseALaDerecha(this.mapa);
                break;
            case I:
                jugador.moverseALaIzquierda(this.mapa);
                break;
        }
    }
}
