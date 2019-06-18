package main.materiales;

import main.estados.EstadoVivo;
import main.herramientas.Pico;

import java.util.Objects;
import java.util.Optional;

public class Metal extends Material {

    public static final int DURABILIDAD_METAL = 50;
    public Metal() {
        this.estado = new EstadoVivo(DURABILIDAD_METAL);
    }

    /*    @Override
        public void desgastar(PicoPiedra pico) {
            int fuerza = pico.getFuerza();
            this.reducirDurabilidad(fuerza);
        }*/
    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}
    @Override
    public Optional<Desgastable> desgastarContra(Pico pico){ return pico.desgastarContra(this);}


    public boolean esIgualA(Metal m) {
        if (this == m) return true;
        if (m == null || getClass() != m.getClass()) return false;
        return true;
    }
}

