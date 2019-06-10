package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLineal;
import main.materiales.Material;

public class HachaPiedra extends Herramienta {

    private static final int DURABILIDAD_HACHA_PIEDRA = 200;
    private static final int FUERZA_HACHA_PIEDRA = 5;
    private static final DesgasteLineal DESGASTE = new DesgasteLineal();

    public HachaPiedra() {
        this.estado = new EstadoVivo(DURABILIDAD_HACHA_PIEDRA);
        this.estrategia = DESGASTE;
        this.fuerza = FUERZA_HACHA_PIEDRA;
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }
}
