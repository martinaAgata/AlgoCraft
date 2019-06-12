package main.materiales;

import main.estados.EstadoVivo;
import main.herramientas.Hacha;

import java.util.Objects;
import java.util.Optional;

public class Madera extends Material {

    public static final int DURABILIDAD_MADERA = 10;
    public Madera() {
        this.estado = new EstadoVivo(DURABILIDAD_MADERA);
    }

/*    @Override
    public void desgastar(HachaMadera hacha) {
        int fuerza = hacha.getFuerza();
        this.reducirDurabilidad(fuerza);
    }

    @Override
    public void desgastar(HachaMetal hacha) {
        int fuerza = hacha.getFuerza();
        this.reducirDurabilidad(fuerza);
    }

    @Override
    public void desgastar(HachaPiedra hacha) {
        int fuerza = hacha.getFuerza();
        this.reducirDurabilidad(fuerza);
    }*/



    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){
        return desgastable.desgastarContra(this);
    }

    @Override
    public Optional<Desgastable> desgastarContra(Hacha hacha){
        return hacha.desgastarContra(this);
    }


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
