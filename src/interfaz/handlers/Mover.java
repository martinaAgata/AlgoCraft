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

    public Mover(Tablero tablero, Mapa mapa, Jugador jugador) {
        this.mapa = mapa;
        this.jugador = jugador;
        //tablero.actualizarTablero();
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCharacter().toLowerCase()) { // atajar excepciones
            case "w":
                //jugador.moverseArriba(this.mapa);
                System.out.println("Arriba");
                break;
            case "s":
                //jugador.moverseAbajo(this.mapa);
                System.out.println("Abajo");
                break;
            case "d":
                //jugador.moverseALaDerecha(this.mapa);
                System.out.println("Derecha");
                break;
            case "a":
                //jugador.moverseALaIzquierda(this.mapa);
                System.out.println("Izquierda");
                break;
            case "c":
                //Abrir Inventario
                System.out.println("Crafteo");
                break;
        }
    }
}
