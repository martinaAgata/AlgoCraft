package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLinealFactor;
import main.materiales.Material;

public class PicoPiedra extends Herramienta {

    public static final int DURABILIDAD_PICO_PIEDRA = 200;
    public static final int FUERZA_PICO_PIEDRA = 4;
    public static final DesgasteLinealFactor DESGASTE = new DesgasteLinealFactor();


    public PicoPiedra() {
        this.estado = new EstadoVivo(DURABILIDAD_PICO_PIEDRA);
        this.estrategia = DESGASTE;
        this.fuerza = FUERZA_PICO_PIEDRA;
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
