package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLinealFactor;
import main.estrategias.EstrategiaDesgaste;
import main.materiales.Madera;
import main.materiales.Material;
import main.materiales.Piedra;

public class Hacha extends Herramienta {

    /*----- Hacha Madera -----*/
    private static final int DURABILIDAD_HACHA_MADERA = 100;
    private static final int FUERZA_HACHA_MADERA = 2;
    private static final double FACTOR_DESGASTE_MADERA = 1;
    /*----- Hacha Piedra -----*/
    private static final int DURABILIDAD_HACHA_PIEDRA = 200;
    private static final int FUERZA_HACHA_PIEDRA = 5;
    private static final double FACTOR_DESGASTE_PIEDRA = 1;
    /*----- Hacha Metal -----*/
    private static final int DURABILIDAD_HACHA_METAL = 400;
    private static final int FUERZA_HACHA_METAL = 10;
    private static final double FACTOR_DESGASTE_METAL = 0.5;

    private Hacha(EstrategiaDesgaste estrategia, int durabilidad, int fuerza) {
        this.estrategia = estrategia;
        this.estado = new EstadoVivo(durabilidad);
        this.fuerza = fuerza;
    }

    public static Hacha nuevaHachaMadera() {
        return (new Hacha(new DesgasteLinealFactor(FACTOR_DESGASTE_MADERA), DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA));
    }

    public static Hacha nuevaHachaPiedra() {
        return (new Hacha(new DesgasteLinealFactor(FACTOR_DESGASTE_PIEDRA), DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA));
    }

    public static Hacha nuevaHachaMetal() {
        return (new Hacha(new DesgasteLinealFactor(FACTOR_DESGASTE_METAL), DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL));
    }

    @Override
    protected void desgastarMaterial(Material material) {
        material.desgastarCon(this);
    }

    @Override
    public void desgastarMadera(Madera madera) {
        madera.reducirDurabilidad(this.fuerza);
    }
}
