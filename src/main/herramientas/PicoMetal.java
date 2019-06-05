package main.herramientas;

import main.estrategias.DesgasteAbrupto;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class PicoMetal extends Herramienta {

    private static final int DURABILIDAD_PICO_METAL = 400;
    private static final int FUERZA_PICO_METAL = 12;
    private static final DesgasteAbrupto DESGASTE = new DesgasteAbrupto();


    public PicoMetal(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, DESGASTE);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
