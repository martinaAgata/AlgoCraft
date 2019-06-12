package main;
import main.herramientas.Hacha;
import main.herramientas.Herramienta;
import main.mapa.Mapa;
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

    public moverseALaDerecha(Mapa mapa) {
        this.ubicacion = ubicacion.derecha();
        mapa.ubicarEnCasillero(this);
    }
    public moverseALaIzquierda(Mapa mapa) {
        this.ubicacion = ubicacion.izquierda();
        mapa.ubicarEnCasillero(this);
    }
    public moverseArriba(Mapa mapa) {
        this.ubicacion = ubicacion.arriba();
        mapa.ubicarEnCasillero(this);
    }
    public moverseAbajo(Mapa mapa) {
        this.ubicacion = ubicacion.abajo();
        mapa.ubicarEnCasillero(this);
    }
    public moverseArribaDerecha(Mapa mapa) {
        this.ubicacion = ubicacion.arribaDerecha();
        mapa.ubicarEnCasillero(this);
    }
    public moverseArribaIzquierda(Mapa mapa) {
        this.ubicacion = ubicacion.arribaIzquierda();
        mapa.ubicarEnCasillero(this);
    }
    public moverseAbajoDerecha(Mapa mapa) {
        this.ubicacion = ubicacion.abajoDerecha();
        mapa.ubicarEnCasillero(this);
    }
    public moverseAbajoIzquierda(Mapa mapa) {
        this.ubicacion = ubicacion.abajoIzquierda();
        mapa.ubicarEnCasillero(this);
    }

}