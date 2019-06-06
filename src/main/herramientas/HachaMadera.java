package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLineal;
import main.materiales.Material;

public class HachaMadera extends Herramienta {

    public static final int DURABILIDAD_HACHA_MADERA = 100;
    public static final int FUERZA_HACHA_MADERA = 2;
    public static final DesgasteLineal DESGASTE = new DesgasteLineal();

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
