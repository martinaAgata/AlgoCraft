package main.materiales;

import main.estados.EstadoVivo;
import main.herramientas.PicoFino;

import java.util.Objects;
import java.util.Optional;

public class Diamante extends Material {

    public static final int DURABILIDAD_DIAMANTE = 100;
    public Diamante() {
        this.estado = new EstadoVivo(DURABILIDAD_DIAMANTE);
    }

/*    @Override
    public void desgastar(PicoFino pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }*/

    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}
    @Override
    public Optional<Desgastable> desgastarContra(PicoFino pico){ return pico.desgastarContra(this); }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(estado, material.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado);
    }
    }
}
