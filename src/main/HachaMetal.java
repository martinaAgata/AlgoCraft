package main;

public class HachaMetal extends Herramienta {

    public HachaMadera(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        super(durabilidad, fuerza, estrategia);
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastar(this);
    }

}
