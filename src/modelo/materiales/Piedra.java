package modelo.materiales;

import modelo.juego.Ubicable;
import modelo.estados.EstadoVivo;
import modelo.herramientas.Pico;

import java.util.Objects;
import java.util.Optional;

public class Piedra extends Material {

    public static final int DURABILIDAD_PIEDRA = 30;
    public Piedra() {
        this.estado = new EstadoVivo(DURABILIDAD_PIEDRA);
    }

/*    @Override
    public void desgastar(PicoMadera pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }

    @Override
    public void desgastar(PicoMetal pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }

    @Override
    public void desgastar(PicoPiedra pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }*/

    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}
    @Override
    public Optional<Desgastable> desgastarContra(Pico pico){ return pico.desgastarContra(this);}
    @Override
    public Optional<Desgastable> desgastarContra(Metal metal){
        return Optional.of(this);
    }

    public boolean esIgualAUbicable(Ubicable ubicable) {
        if(this.getClass() != ubicable.getClass()) return false;
        Piedra piedra = (Piedra) ubicable;
        if(this.getDurabilidad() != piedra.getDurabilidad()) return false;
        return true;
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
