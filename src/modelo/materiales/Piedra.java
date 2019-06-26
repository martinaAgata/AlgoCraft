package modelo.materiales;

import modelo.estados.EstadoVivo;
import modelo.herramientas.Pico;
import modelo.juego.Ubicable;
import modelo.mapa.Casillero;

import java.util.Objects;
import java.util.Optional;

import static modelo.juego.ConstantesJuego.DURABILIDAD_PIEDRA;

public class Piedra extends Material {
    public Piedra(Casillero casillero) {
        this.casillero = casillero;
        this.estado = new EstadoVivo(DURABILIDAD_PIEDRA);
    }


    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}
    @Override
    public Optional<Desgastable> desgastarContra(Pico pico){ return pico.desgastarContra(this);}
    @Override
    public Optional<Desgastable> desgastarContra(Metal metal){
        return Optional.of(this);
    }

    public boolean esIgualAUbicable(Ubicable ubicable) {
        return(this.getClass() == ubicable.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        return true;
    }
}
