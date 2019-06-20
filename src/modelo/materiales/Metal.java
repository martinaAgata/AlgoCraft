package modelo.materiales;

import modelo.juego.Ubicable;
import modelo.estados.EstadoVivo;
import modelo.herramientas.Pico;

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


    public boolean esIgualAUbicable(Ubicable ubicable) {
        return (this.getClass() == ubicable.getClass());
        // aca sacamos lo de ver si las durabilidades coinciden
        //xq los materiales estan nuevos cuando inicializo el juego
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

