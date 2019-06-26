package modelo.materiales;

import modelo.estados.EstadoVivo;
import modelo.herramientas.Pico;
import modelo.juego.Ubicable;
import modelo.mapa.Casillero;

import java.util.Objects;
import java.util.Optional;

import static modelo.juego.ConstantesJuego.DURABILIDAD_METAL;

public class Metal extends Material {

    public Metal() {
        this.casillero = casillero;
        this.estado = new EstadoVivo(DURABILIDAD_METAL);
    }

    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}
    @Override
    public Optional<Desgastable> desgastarContra(Pico pico){ return pico.desgastarContra(this);}


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

