package main.herramientas;

import main.estados.EstadoVivo;
import main.estrategias.EstrategiaDesgaste;
import main.materiales.Desgastable;
import main.materiales.Diamante;

import java.util.Optional;

public class PicoFino extends Herramienta {

        private static final int DURABILIDAD_PICO_FINO = 1000;
        private static final int FUERZA_PICO_FINO = 20;
        private static final double FACTOR_DESGASTE = 0.1;

    /* por si hacemos que sea un pico
    private PicoFino(EstrategiaDesgaste estrategia, int durabilidad, int fuerza){
        this.estado = new EstadoVivo(durabilidad);
        this.estrategia = estrategia;
        this.fuerza = fuerza;
    }*/

    public PicoFino(EstrategiaDesgaste estrategia, int durabilidad, int fuerza) {
        this.estado = new EstadoVivo(durabilidad);
        this.estrategia = estrategia;
        this.fuerza = fuerza;
    }


/*    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }*/
    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}
    @Override
    public Optional<Desgastable> desgastarContra(Diamante diamante){
    //if(diamante == null) return null;
    this.desgastarMaterial(diamante);
    return Optional.empty();
    }

    public void desgastarMaterial(Diamante diamante) {
        diamante.reducirDurabilidad(this.fuerza);
    }

}