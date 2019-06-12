package main;
import main.herramientas.ConstructorHacha;
import main.herramientas.Hacha;
import main.herramientas.Herramienta;
import main.mapa.Mapa;
import main.mapa.Ubicacion;

public class Jugador implements Ubicable {

    private Herramienta herramientaActual;
    private Ubicacion ubicacion;

    public Jugador() {
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
        this.herramientaActual = hachaMadera;
    }

    public void setUbicacion(Ubicacion u) { this.ubicacion = u; }

    public Herramienta obtenerHerramientaActual() {
        return herramientaActual;
    }

    public void moverseALaDerecha(Mapa mapa) {
        this.ubicacion = ubicacion.derecha();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseALaIzquierda(Mapa mapa) {
        this.ubicacion = ubicacion.izquierda();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseArriba(Mapa mapa) {
        this.ubicacion = ubicacion.arriba();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseAbajo(Mapa mapa) {
        this.ubicacion = ubicacion.abajo();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseArribaDerecha(Mapa mapa) {
        this.ubicacion = ubicacion.arribaDerecha();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseArribaIzquierda(Mapa mapa) {
        this.ubicacion = ubicacion.arribaIzquierda();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseAbajoDerecha(Mapa mapa) {
        this.ubicacion = ubicacion.abajoDerecha();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseAbajoIzquierda(Mapa mapa) {
        this.ubicacion = ubicacion.abajoIzquierda();
        mapa.ubicarEnCasillero(this, ubicacion);
    }

}