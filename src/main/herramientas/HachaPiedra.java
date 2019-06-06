package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLineal;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class HachaPiedra extends Herramienta {

    public static final int DURABILIDAD_HACHA_PIEDRA = 200;
    public static final int FUERZA_HACHA_PIEDRA = 5;
    public static final DesgasteLineal DESGASTE = new DesgasteLineal();

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
