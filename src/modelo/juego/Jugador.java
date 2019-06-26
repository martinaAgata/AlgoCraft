package modelo.juego;
import modelo.exceptions.NoExisteNingunCasilleroParaLaUbicacionDadaException;
import modelo.exceptions.NoSePuedeUbicarPorqueEstaOcupadoException;
import modelo.herramientas.ConstructorHacha;
import modelo.herramientas.Herramienta;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Madera;
import modelo.materiales.Material;

import static modelo.juego.ConstantesJuego.*;

public class Jugador extends Ubicable {

    private Herramienta herramientaActual;
    private Ubicacion ubicacion;

    public Jugador(Herramienta herramientaInicial) {
        ConstructorHacha constructor = new ConstructorHacha();
        Herramienta hachaMadera = constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_HACHA_MADERA)
                .conDesgaste(DESGASTE_HACHA_MADERA)
                .conFuerza(FUERZA_HACHA_MADERA)
                .construir();
        this.herramientaActual = herramientaInicial;
    }

    public void setUbicacion(Ubicacion u) { this.ubicacion = u; }

    public Herramienta obtenerHerramientaActual() {
        return herramientaActual;
    }

    public void moverseALaDerecha(Mapa mapa) {
        Ubicacion ubicacionDerecha = ubicacion;
        try {
            mapa.ubicarEnCasillero(this, ubicacion);
            mapa.eliminarDeCasillero(this.ubicacion);
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
            Material material = (Material) mapa.obtenerCasillero(ubicacionDerecha).obtenerUbicable();
            this.herramientaActual.usar(material);
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException e) {}
    }

    public void moverseALaIzquierda(Mapa mapa) {
        Ubicacion ubicacionIzquierda = ubicacion.getUbicacionIzquierda();
        try {
            mapa.ubicarEnCasillero(this, ubicacion);
            mapa.eliminarDeCasillero(this.ubicacion);
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
            Material material = (Material) mapa.obtenerCasillero(ubicacionIzquierda).obtenerUbicable();
            this.herramientaActual.usar(material);
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException e) {}
    }

    public void moverseArriba(Mapa mapa) {
        Ubicacion ubicacionArriba = ubicacion.getUbicacionArriba();
        try {
            mapa.ubicarEnCasillero(this, ubicacion);
            mapa.eliminarDeCasillero(this.ubicacion);
        } catch (NoSePuedeUbicarPorqueEstaOcupadoException e) {
            Material material = (Material) mapa.obtenerCasillero(ubicacionArriba).obtenerUbicable();
            this.herramientaActual.usar(material);
        } catch (NoExisteNingunCasilleroParaLaUbicacionDadaException e) {}
    }

    public void moverseAbajo(Mapa mapa) {
        Ubicacion ubicacionAbajo = ubicacion.getUbicacionAbajo();
        try {
            mapa.ubicarEnCasillero(this, ubicacion);
            mapa.eliminarDeCasillero(this.ubicacion);
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