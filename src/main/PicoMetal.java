package main;

public class PicoMetal extends Herramienta {

    public PicoMetal(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(durabilidad, fuerza, estrategia);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
