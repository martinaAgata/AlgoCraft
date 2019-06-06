package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLinealMitad;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class HachaMetal extends Herramienta {

    public static final int DURABILIDAD_HACHA_METAL = 400;
    public static final int FUERZA_HACHA_METAL = 10;
    public static final DesgasteLinealMitad DESGASTE = new DesgasteLinealMitad();

    public HachaMetal() {
        this.estado = new EstadoVivo(DURABILIDAD_HACHA_METAL);
        this.estrategia = DESGASTE;
        this.fuerza = FUERZA_HACHA_METAL;
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
