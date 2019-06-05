package main.herramientas;

import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class HachaMadera extends Herramienta {

    public HachaMadera(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(durabilidad, fuerza, estrategia);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }
}
