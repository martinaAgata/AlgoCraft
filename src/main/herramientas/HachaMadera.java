package main.herramientas;

import main.estrategias.DesgasteLineal;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class HachaMadera extends Herramienta {

    private static final int DURABILIDAD_HACHA_MADERA = 100;
    private static final int FUERZA_HACHA_MADERA = 2;
    private static final DesgasteLineal DESGASTE = new DesgasteLineal();

    public HachaMadera(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA, DESGASTE);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }
}
