package main.herramientas;

import main.estrategias.DesgasteLinealMitad;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class HachaMetal extends Herramienta {

    private static final int DURABILIDAD_HACHA_METAL = 400;
    private static final int FUERZA_HACHA_METAL = 10;
    private static final DesgasteLinealMitad DESGASTE = new DesgasteLinealMitad();

    public HachaMadera(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL, DESGASTE);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
