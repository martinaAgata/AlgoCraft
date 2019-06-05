package main.herramientas;

import main.estrategias.DesgasteLinealDecimal;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class PicoFino extends Herramienta {

    private static final int DURABILIDAD_PICO_FINO = 1000;
    private static final int FUERZA_PICO_FINO = 20;
    private static final DesgasteLinealDecimal DESGASTE = new DesgasteLinealDecimal();


    public PicoFino(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO, DESGASTE);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}