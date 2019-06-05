package main.herramientas;

import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class PicoMetal extends Herramienta {

    public PicoMetal(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(durabilidad, fuerza, estrategia);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
