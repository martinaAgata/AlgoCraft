package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLineal;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class HachaMadera extends Herramienta {

    private static final int DURABILIDAD_HACHA_MADERA = 100;
    private static final int FUERZA_HACHA_MADERA = 2;
    private static final DesgasteLineal DESGASTE = new DesgasteLineal();

    public HachaMadera() {
        this.estado = new EstadoVivo(DURABILIDAD_HACHA_MADERA);
        this.estrategia = DESGASTE;
        this.fuerza = FUERZA_HACHA_MADERA;
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }
}
