package interfaz.handlers;

import interfaz.Tablero;
import javafx.event.EventHandler;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;
import modelo.exceptions.NoExisteNingunCasilleroParaLaUbicacionDadaException;
import modelo.exceptions.NoSePuedeUbicarPorqueEstaOcupadoException;
import javafx.scene.input.KeyEvent;


import static javafx.scene.input.KeyCode.*;

public class Mover implements EventHandler<KeyEvent> {

    private final Jugador jugador;
    private Mapa mapa;
    private Tablero tablero;

    public Mover(Tablero tablero, Mapa mapa, Jugador jugador) {
        this.mapa = mapa;
        this.jugador = jugador;
        this.tablero = tablero;
        //tablero.actualizarTablero();
    }

    @Override
    public void handle(KeyEvent event) {
    try {
            switch (event.getCharacter().toLowerCase()) { // atajar excepciones
                case "w":
                    jugador.moverseArriba(this.mapa);
                    break;
                case "s":
                    jugador.moverseAbajo(this.mapa);
                    break;
                case "d":
                    jugador.moverseALaDerecha(this.mapa);
                    break;
                case "a":
                    jugador.moverseALaIzquierda(this.mapa);
                    break;
                case "c":
                    //Abrir Inventario
                    break;
            }
            tablero.actualizarTablero(false);
        }catch (Exception e){};
    }
}
