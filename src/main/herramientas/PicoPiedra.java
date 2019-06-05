package main.herramientas;

import main.estrategias.DesgasteLinealFactor;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class PicoPiedra extends Herramienta {

    private static final int DURABILIDAD_PICO_PIEDRA = 200;
    private static final int FUERZA_PICO_PIEDRA = 4;
    private static final DesgasteLinealFactor DESGASTE = new DesgasteLinealFactor();


    public PicoPiedra(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, DESGASTE);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
