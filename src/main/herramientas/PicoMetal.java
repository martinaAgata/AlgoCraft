package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteAbrupto;
import main.materiales.Material;

public class PicoMetal extends Herramienta {

    public static final int DURABILIDAD_PICO_METAL = 400;
    public static final int FUERZA_PICO_METAL = 12;
    public static final DesgasteAbrupto DESGASTE = new DesgasteAbrupto();

    public PicoMetal() {
        this.estado = new EstadoVivo(DURABILIDAD_PICO_METAL);
        this.estrategia = DESGASTE;
        this.fuerza = FUERZA_PICO_METAL;
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
