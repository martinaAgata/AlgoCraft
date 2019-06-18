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
    public Optional<Desgastable> desgastarContra(Desgastable desgastable) {
        return desgastable.desgastarContra(this);
    }

    @Override
    public Optional<Desgastable> desgastarContra(Hacha hacha) {
        return hacha.desgastarContra(this);
    }


    public boolean esIgualA(Madera m) {
        if (this == m) return true;
        if (m == null || getClass() != m.getClass()) return false;
        return true;
    }
}
