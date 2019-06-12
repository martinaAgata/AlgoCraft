package main.materiales;

import main.estados.EstadoVivo;
import main.herramientas.Pico;

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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
