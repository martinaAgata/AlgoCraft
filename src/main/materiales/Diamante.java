package main.materiales;

import main.EstadoVivo;
import main.herramientas.PicoFino;

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
    public Desgastable desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}
    @Override
    public Desgastable desgastarContra(PicoFino pico){ return pico.desgastarContra(this); }
}
