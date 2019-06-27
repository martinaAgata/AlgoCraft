package interfaz.handlers;

import interfaz.Inventario;
import interfaz.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import modelo.juego.Jugador;
import modelo.mapa.Mapa;
import javafx.scene.input.KeyEvent;

public class Mover {

    private final Jugador jugador;
    private Mapa mapa;
    private Tablero tablero;
    private Inventario inventario;

    public Mover(Tablero tablero, Mapa mapa, Jugador jugador, Inventario inventario) {
        this.mapa = mapa;
        this.jugador = jugador;
        this.tablero = tablero;
        this.inventario = inventario;
    }

    public void moverseHacia(KeyCode keyPressed) {
        if(keyPressed == KeyCode.W) jugador.moverseArriba(this.mapa);
        if(keyPressed == KeyCode.D) jugador.moverseALaDerecha(this.mapa);
        if(keyPressed == KeyCode.A) jugador.moverseALaIzquierda(this.mapa);
        if(keyPressed == KeyCode.S) jugador.moverseAbajo(this.mapa);
        this.tablero.actualizarTablero();
        this.inventario.actualizarInventario();
    }
}
