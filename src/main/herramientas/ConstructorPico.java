package main.herramientas;
import main.estrategias.DesgasteAbrupto;
import main.estrategias.DesgasteLinealFactor;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;

public class ConstructorPico {

    /*----- PicoMadera -----*/
    private static final double FACTOR_DESGASTE_MADERA = 1.0;
    private static final int DURABILIDAD_PICO_MADERA = 100;
    private static final int FUERZA_PICO_MADERA = 2;
    /*----- PicoPiedra -----*/
    private static final double FACTOR_DESGASTE_PIEDRA = (1 / 1.5);
    private static final int DURABILIDAD_PICO_PIEDRA = 200;
    private static final int FUERZA_PICO_PIEDRA = 4;
    /*----- PicoMetal -----*/
    private static final int DURABILIDAD_PICO_METAL = 400;
    private static final int FUERZA_PICO_METAL = 12;

    public Pico construirPicoPiedra() {
        Pico picoPiedra = new Pico(new DesgasteLinealFactor(FACTOR_DESGASTE_PIEDRA), DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        return picoPiedra;
    }

    public Pico construirPicoMetal() {
        Pico picoMetal = new Pico(new DesgasteAbrupto(), DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        return picoMetal;
    }

    public Pico construirPicoMadera() {
        Pico picoMadera = new Pico(new DesgasteLinealFactor(FACTOR_DESGASTE_MADERA), DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        return picoMadera;
    }

}
