package modelo.juego;

import modelo.exceptions.*;
import modelo.herramientas.ConstructorHacha;
import modelo.herramientas.Herramienta;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Material;
import java.util.HashMap;

public class Jugador extends Ubicable {

    private Herramienta herramientaActual;
    private HashMap<Material, Integer> inventarioMateriales;

    public Jugador(Herramienta herramientaInicial, HashMap inventarioMateriales, Ubicacion inicial) {
        super(inicial);
        this.herramientaActual = herramientaInicial;
        this.inventarioMateriales = inventarioMateriales;
    }

    public void setUbicacion(Ubicacion u) { this.ubicacion = u; }
    public void setHerramientaActual(Herramienta herramienta){
        this.herramientaActual = herramienta;
    }

    public Herramienta obtenerHerramientaActual() {
        return herramientaActual;
    }

    public void moverseALaDerecha(Mapa mapa) {
        Ubicacion ubicacionDerecha = ubicacion.getUbicacionDerecha();
        moverse(mapa, ubicacionDerecha);
    }

    public void moverseALaIzquierda(Mapa mapa) {
        Ubicacion ubicacionArriba = ubicacion.getUbicacionIzquierda();
        moverse(mapa, ubicacionArriba);
    }

    public void moverseArriba(Mapa mapa) {
        Ubicacion ubicacionArriba = ubicacion.getUbicacionArriba();
        moverse(mapa, ubicacionArriba);
    }

    public void moverseAbajo(Mapa mapa) {
        Ubicacion ubicacionAbajo = ubicacion.getUbicacionAbajo();
        moverse(mapa, ubicacionAbajo);
    }

    public void moverse(Mapa mapa, Ubicacion ubicacion) {
        try {
            mapa.ubicarEnCasillero(this, ubicacion);
            mapa.eliminarDeCasillero(this.ubicacion);
            this.ubicacion = ubicacion;
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
            Material material = (Material) mapa.obtenerCasillero(ubicacion).obtenerUbicable();
            this.herramientaActual.usar(material);
        }
    }

    private void agregarAInventario(Material material) {
        this.inventarioMateriales.put(material, this.inventarioMateriales.get(material)+1);
    }

    public Ubicacion obtenerUbicacion(){
        return ubicacion;
    }

    @Override
    public boolean esIgualAUbicable(Ubicable ubicable) {
        return this.getClass() == ubicable.getClass();
    }
}