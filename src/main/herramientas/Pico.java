package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLinealFactor;
import main.estrategias.EstrategiaDesgaste;

public class Pico extends Herramienta {

    /*----- PicoMadera -----*/
    private static final int FACTOR_DESGASTE_MADERA = 1;
    private static final int DURABILIDAD_PICO_MADERA = 100;
    private static final int FUERZA_PICO_MADERA = 2;
    /*----- PicoPiedra -----*/
    private static final int FACTOR_DESGASTE_PIEDRA = 1.5;
    private static final int DURABILIDAD_PICO_PIEDRA = 200;
    private static final int FUERZA_PICO_PIEDRA = 4;
    /*----- PicoMetal -----*/
    private static final int FACTOR_DESGASTE_METAL = 0.5;
    private static final int DURABILIDAD_PICO_METAL = 400;
    private static final int FUERZA_PICO_METAL = 12;

    private Pico(EstrategiaDesgaste estrategia, int durabilidad, int fuerza) {
        this.estado = new EstadoVivo(durabilidad);
        this.estrategia = estrategia;
        this.fuerza = fuerza;
    }

    public static Pico nuevoPicoMadera() {
        Pico picoMadera = new Pico(DesgasteLinealFactor(FACTOR_DESGASTE_MADERA), DURABILIDAD_PICO_MADERA,  FUERZA_PICO_MADERA);
        return  picoMadera;
    }


    public static Pico nuevoPicoPiedra() {
        Pico picoPiedra = new Pico(DesgasteLinealFactor(FACTOR_DESGASTE_PIEDRA), DURABILIDAD_PICO_MADERA,  FUERZA_PICO_MADERA);
        return  picoPiedra;
    }

    public static Pico nuevoPicoMetal() {
        Pico picoMetal = new Pico(DesgasteLinealFactor(FACTOR_DESGASTE_METAL), DURABILIDAD_PICO_MADERA,  FUERZA_PICO_MADERA);
        return  picoMetal;
    }

}
