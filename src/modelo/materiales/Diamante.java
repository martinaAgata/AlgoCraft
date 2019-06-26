package modelo.materiales;

import modelo.estados.EstadoVivo;
import modelo.herramientas.PicoFino;
import modelo.juego.Ubicable;
import modelo.mapa.Casillero;
import modelo.mapa.Mapa;

import java.util.Objects;
import java.util.Optional;

import static modelo.juego.ConstantesJuego.DURABILIDAD_DIAMANTE;

public class Diamante extends Material {

    public Diamante() {
        this.casillero = casillero;
        this.estado = new EstadoVivo(DURABILIDAD_DIAMANTE);
    }


    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}
    @Override
    public Optional<Desgastable> desgastarContra(PicoFino pico){ return pico.desgastarContra(this); }


    public boolean esIgualAUbicable(Ubicable ubicable) {
        return (this.getClass() == ubicable.getClass());

    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        return (this.getClass() == obj.getClass());
    }
}