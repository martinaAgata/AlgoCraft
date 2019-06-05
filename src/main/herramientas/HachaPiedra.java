package main.herramientas;

import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class HachaPiedra extends Herramienta {

    public HachaPiedra(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(durabilidad, fuerza, estrategia);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }
}
