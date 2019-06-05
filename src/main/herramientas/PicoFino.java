package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLinealDecimal;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class PicoFino extends Herramienta {

    private static final int DURABILIDAD_PICO_FINO = 1000;
    private static final int FUERZA_PICO_FINO = 20;
    private static final DesgasteLinealDecimal DESGASTE = new DesgasteLinealDecimal();


    public PicoFino() {
        this.estado = new EstadoVivo(DURABILIDAD_PICO_FINO);
        this.estrategia = DESGASTE;
        this.fuerza = FUERZA_PICO_FINO;
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}