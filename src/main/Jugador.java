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
        Hacha hachaMadera = constructor.construir();
        this.herramientaActual = hachaMadera;
    }

    public void setUbicacion(Ubicacion u) { this.ubicacion = u; }

    public Herramienta obtenerHerramientaActual() {
        return herramientaActual;
    }

    public void moverseALaDerecha(Mapa mapa) {
        this.ubicacion = ubicacion.getUbicacionDerecha();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseALaIzquierda(Mapa mapa) {
        this.ubicacion = ubicacion.getUbicacionIzquierda();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseArriba(Mapa mapa) {
        this.ubicacion = ubicacion.getUbicacionArriba();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
    public void moverseAbajo(Mapa mapa) {
        this.ubicacion = ubicacion.getUbicacionAbajo();
        mapa.ubicarEnCasillero(this, ubicacion);
    }
}