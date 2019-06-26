package modelo.juego;

import modelo.exceptions.NoExisteNingunCasilleroParaLaUbicacionDadaException;
import modelo.exceptions.NoSePuedeUbicarPorqueEstaOcupadoException;
import modelo.herramientas.ConstructorHacha;
import modelo.herramientas.Herramienta;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Material;

public class Jugador extends Ubicable {

    private Herramienta herramientaActual;
    private Ubicacion ubicacion;

    public Jugador(Herramienta herramientaInicial) {
        ConstructorHacha constructor = new ConstructorHacha();
        this.herramientaActual = herramientaInicial;
    }

    public void setUbicacion(Ubicacion u) { this.ubicacion = u; }

    public Herramienta obtenerHerramientaActual() {
        return herramientaActual;
    }

    public void moverseALaDerecha(Mapa mapa) {
        Ubicacion ubicacionDerecha = ubicacion.getUbicacionDerecha();
        try {
            mapa.ubicarEnCasillero(this, ubicacionDerecha);
            mapa.eliminarDeCasillero(this.ubicacion);
            this.ubicacion = ubicacionDerecha;
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
            Material material = (Material) mapa.obtenerCasillero(ubicacionDerecha).obtenerUbicable();
            this.herramientaActual.usar(material);
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException e) {}
    }

    public void moverseALaIzquierda(Mapa mapa) {
        Ubicacion ubicacionIzquierda = ubicacion.getUbicacionIzquierda();
        try {
            mapa.ubicarEnCasillero(this, ubicacionIzquierda);
            mapa.eliminarDeCasillero(this.ubicacion);
            this.ubicacion = ubicacionIzquierda;
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
            Material material = (Material) mapa.obtenerCasillero(ubicacionIzquierda).obtenerUbicable();
            this.herramientaActual.usar(material);
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException e) {}
    }

    public void moverseArriba(Mapa mapa) {
        Ubicacion ubicacionArriba = this.ubicacion.getUbicacionArriba();
        Ubicable ubicable = mapa.obtenerCasillero(ubicacionArriba).obtenerUbicable();
        try {
            this.herramientaActual.usar(material);
            mapa.ubicarEnCasillero(this, ubicacionArriba);
            mapa.eliminarDeCasillero(this.ubicacion);
            this.ubicacion = ubicacionArriba;
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException e) {}
    }

    public void moverseAbajo(Mapa mapa) {
        Ubicacion ubicacionAbajo = ubicacion.getUbicacionAbajo();
        try {
            mapa.ubicarEnCasillero(this, ubicacionAbajo);
            mapa.eliminarDeCasillero(this.ubicacion);
            this.ubicacion = ubicacionAbajo;
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
            Material material = (Material) mapa.obtenerCasillero(ubicacionAbajo).obtenerUbicable();
            this.herramientaActual.usar(material);
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException e) {}
    }

    public Ubicacion obtenerUbicacion(){
        return ubicacion;
    }

    @Override
    public boolean esIgualAUbicable(Ubicable ubicable) {
        return this.getClass() == ubicable.getClass();
    }
}