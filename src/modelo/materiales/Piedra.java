package modelo.materiales;

import modelo.estados.EstadoVivo;
import modelo.herramientas.Pico;
import modelo.juego.Ubicable;
import modelo.mapa.ObservadorUbicable;
import modelo.mapa.Ubicacion;
import java.util.Objects;
import java.util.Optional;

import static modelo.juego.ConstantesJuego.DURABILIDAD_PIEDRA;

public class Piedra extends Material {

    public Piedra(Ubicacion ubicacion, Optional<ObservadorUbicable> observadorUbicable) {
        super(ubicacion);
        this.estado = new EstadoVivo(DURABILIDAD_PIEDRA,
                () -> observadorUbicable.ifPresent(observador -> observador.ubicableMuerto(this))
        );
    }

    public Piedra() {
        this(null, Optional.empty());
    }

    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}

    @Override
    public Optional<Desgastable> desgastarContra(Pico pico){ return pico.desgastarContra(this);}

    @Override
    public Optional<Desgastable> desgastarContra(Metal metal){
        return Optional.of(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        return (this.getClass() == obj.getClass());
    }

    public boolean esIgualAUbicable(Ubicable ubicable) {
        return(this.getClass() == ubicable.getClass());
    }
}
