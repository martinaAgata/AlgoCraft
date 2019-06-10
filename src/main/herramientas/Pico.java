package main.herramientas;

import main.Estado;
import main.EstadoVivo;
import main.estrategias.DesgasteLineal;
import main.estrategias.DesgasteLinealFactor;
import main.estrategias.EstrategiaDesgaste;

public class Pico extends Herramienta {

    /*PicoMadera*/
    private static final int DURABILIDAD_PICO_MADERA = 100;
    private static final int FUERZA_PICO_MADERA = 2;
    private static final DesgasteLineal DESGASTE_MADERA = new DesgasteLineal();


    /*PicoPiedra*/
    private static final int DURABILIDAD_PICO_PIEDRA = 200;
    private static final int FUERZA_PICO_PIEDRA = 4;
    private static final DesgasteLinealFactor DESGASTE = new DesgasteLinealFactor();


    private Pico(EstrategiaDesgaste estrategia, int durabilidad, int fuerza){
        this.estado = new EstadoVivo(durabilidad);
        this.estrategia = estrategia;
        this.fuerza = fuerza;
    }

    public static Pico nuevoPicoMadera(){
        Pico picoMadera = new Pico(DESGASTE_MADERA, DURABILIDAD_PICO_MADERA,  FUERZA_PICO_MADERA);
        return  picoMadera;
    }


    public static Pico nuevoPicoPiedra(){
        Pico picoPiedra = new Pico(DESGASTE_PIEDRA, DURABILIDAD_PICO_MADERA,  FUERZA_PICO_MADERA);
        return  picoPiedra;
    }

    public static Pico nuevoPicoMetal(){
        Pico picoMetal = new Pico(DESGASTE_PIEDRA, DURABILIDAD_PICO_MADERA,  FUERZA_PICO_MADERA);
        return  picoMetal;
    }
    
}
