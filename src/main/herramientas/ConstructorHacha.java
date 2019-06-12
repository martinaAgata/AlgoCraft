package main.herramientas;

import main.estrategias.DesgasteLinealFactor;

public class ConstructorHacha {

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

    public Hacha construirHachaMadera() {
        return (new Hacha(new DesgasteLinealFactor(FACTOR_DESGASTE_MADERA), DURABILIDAD_HACHA_MADERA, FUERZA_HACHA_MADERA));
    }

    public Hacha construirHachaPiedra() {
        return (new Hacha(new DesgasteLinealFactor(FACTOR_DESGASTE_PIEDRA), DURABILIDAD_HACHA_PIEDRA, FUERZA_HACHA_PIEDRA));
    }

    public Hacha construirHachaMetal() {
        return (new Hacha(new DesgasteLinealFactor(FACTOR_DESGASTE_METAL), DURABILIDAD_HACHA_METAL, FUERZA_HACHA_METAL));
    }

}
