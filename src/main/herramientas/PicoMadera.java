package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLineal;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public class PicoMadera extends Herramienta {

    public static final int DURABILIDAD_PICO_MADERA = 100;
    public static final int FUERZA_PICO_MADERA = 2;
    public static final DesgasteLineal DESGASTE = new DesgasteLineal();

    public PicoMadera() {
        this.estado = new EstadoVivo(DURABILIDAD_PICO_MADERA);
        this.estrategia = DESGASTE;
        this.fuerza = FUERZA_PICO_MADERA;
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
