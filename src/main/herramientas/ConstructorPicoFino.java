package main.herramientas;

import main.estrategias.DesgasteLinealFactor;

public class ConstructorPicoFino {

    private static final int DURABILIDAD_PICO_FINO = 1000;
    private static final int FUERZA_PICO_FINO = 20;
    private static final double FACTOR_DESGASTE = 0.1;


    public PicoFino construirPicoFino() {
        PicoFino picoFino = new picoFino(new DesgasteLinealFactor(FACTOR_DESGASTE), DURABILIDAD_PICO_FINO, FUERZA_PICO_FINO);
        return  picoFino;
    }

}
