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
    private Ubicacion ubicacion;
    private HashMap<Material, Integer> inventarioMateriales;

    public Jugador(Herramienta herramientaInicial, HashMap inventarioMateriales) {
        ConstructorHacha constructor = new ConstructorHacha();
        this.herramientaActual = herramientaInicial;
        this.inventarioMateriales = inventarioMateriales;
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
            try {
                this.herramientaActual.usar(material);
            } catch (HerramientaRotaNoPuedeDesgastarseException f) {
            } catch (MaterialSeHaGastadoException g) {
                mapa.eliminarDeCasillero(ubicacionDerecha);
            }
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException h) {
        }
    }

    public void moverseALaIzquierda(Mapa mapa) {
        Ubicacion ubicacionIzquierda = ubicacion.getUbicacionIzquierda();
        try {
            mapa.ubicarEnCasillero(this, ubicacionIzquierda);
            mapa.eliminarDeCasillero(this.ubicacion);
            this.ubicacion = ubicacionIzquierda;
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
            Material material = (Material) mapa.obtenerCasillero(ubicacionIzquierda).obtenerUbicable();
            try {
                this.herramientaActual.usar(material);
            } catch (HerramientaRotaNoPuedeDesgastarseException f) {
            } catch (MaterialSeHaGastadoException g) {

                mapa.eliminarDeCasillero(ubicacionIzquierda);
            }
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException h) {
        }
    }

    public void moverseArriba(Mapa mapa) {
        Ubicacion ubicacionArriba = ubicacion.getUbicacionArriba();
        try {
            mapa.ubicarEnCasillero(this, ubicacionArriba);
            mapa.eliminarDeCasillero(this.ubicacion);
            this.ubicacion = ubicacionArriba;
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
            Material material = (Material) mapa.obtenerCasillero(ubicacionArriba).obtenerUbicable();
            try {
                this.herramientaActual.usar(material);
            } catch (HerramientaRotaNoPuedeDesgastarseException f) {
            } catch (MaterialSeHaGastadoException g) {

                mapa.eliminarDeCasillero(ubicacionArriba);
            }
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException h) {
        }
    }

    public void moverseAbajo(Mapa mapa) {
        Ubicacion ubicacionAbajo = ubicacion.getUbicacionAbajo();
        try {
            mapa.ubicarEnCasillero(this, ubicacionAbajo);
            mapa.eliminarDeCasillero(this.ubicacion);
            this.ubicacion = ubicacionAbajo;
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
            Material material = (Material) mapa.obtenerCasillero(ubicacionAbajo).obtenerUbicable();
            try {
                this.herramientaActual.usar(material);
            } catch (HerramientaRotaNoPuedeDesgastarseException f) {
            } catch (MaterialSeHaGastadoException g) {
                mapa.eliminarDeCasillero(ubicacionAbajo);
            }
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException h) {
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