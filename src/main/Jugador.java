package main;
import main.herramientas.Hacha;
import main.herramientas.Herramienta;
import main.mapa.Ubicacion;

public class Jugador implements Ubicable {

    private Herramienta herramientaActual;
    private Ubicacion ubicacion;

    public Jugador() {
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
        this.herramientaActual = hachaMadera;
    }
    public setUbicacion(Ubicacion u) { this.ubicacion = u; }

    public Herramienta obtenerHerramientaActual() {
        return herramientaActual;
    }

    public moverseALaDerecha() {
        this.ubicacion = ubicacion.derecha();
    }
    public moverseALaIzquierda() {
        this.ubicacion = ubicacion.izquierda();
    }
    public moverseArriba() {
        this.ubicacion = ubicacion.arriba();
    }
    public moverseAbajo() {
        this.ubicacion = ubicacion.abajo();
    }
    public moverseArribaDerecha() {
        this.ubicacion = ubicacion.arribaDerecha();
    }
    public moverseArribaIzquierda() {
        this.ubicacion = ubicacion.arribaIzquierda();
    }
    public moverseAbajoDerecha() {
        this.ubicacion = ubicacion.abajoDerecha();
    }
    public moverseAbajoIzquierda() {
        this.ubicacion = ubicacion.abajoIzquierda();
    }

}