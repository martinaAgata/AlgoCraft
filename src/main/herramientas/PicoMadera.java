package main.herramientas;

import main.estrategias.DesgasteLineal;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class PicoMadera extends Herramienta {

    private static final int DURABILIDAD_PICO_MADERA = 100;
    private static final int FUERZA_PICO_MADERA = 2;
    private static final DesgasteLineal DESGASTE = new DesgasteLineal();

    public PicoMadera(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, DESGASTE);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
