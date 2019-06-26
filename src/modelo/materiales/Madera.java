package modelo.materiales;

import modelo.estados.EstadoVivo;
import modelo.herramientas.Hacha;
import modelo.juego.Ubicable;
import modelo.mapa.Casillero;

import java.util.Objects;
import java.util.Optional;

import static modelo.juego.ConstantesJuego.DURABILIDAD_MADERA;

public class Madera extends Material {

    public Madera() {
        this.casillero = casillero;
        this.estado = new EstadoVivo(DURABILIDAD_MADERA);
    }

    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable) {
        return desgastable.desgastarContra(this);
    }

    @Override
    public Optional<Desgastable> desgastarContra(Hacha hacha) {
        return hacha.desgastarContra(this);
    }


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
