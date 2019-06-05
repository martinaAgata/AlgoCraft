package main;

public class Pico extends Herramienta {

    public Pico(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(durabilidad, fuerza, estrategia);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
