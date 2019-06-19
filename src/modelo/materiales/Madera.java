package modelo.materiales;

import modelo.juego.Ubicable;
import modelo.estados.EstadoVivo;
import modelo.herramientas.Hacha;

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


    public boolean esIgualAUbicable(Ubicable ubicable) {
        if(this.getClass() != ubicable.getClass()) return false;
        Madera madera = (Madera) ubicable;
        if(this.getDurabilidad() != madera.getDurabilidad()) return false;
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
