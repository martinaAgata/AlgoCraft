package main.herramientas;

import main.estrategias.DesgasteLineal;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class HachaPiedra extends Herramienta {

    private static final int DURABILIDAD_HACHA_PIEDRA = 200;
    private static final int FUERZA_HACHA_PIEDRA = 5;
    private static final DesgasteLineal DESGASTE = new DesgasteLineal();

    public HachaPiedra(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA, DESGASTE);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }
}
