package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteAbrupto;
import main.estrategias.DesgasteLinealFactor;
import main.estrategias.EstrategiaDesgaste;
import main.materiales.*;

public class Pico extends Herramienta {

    /*----- PicoMadera -----*/
    private static final double FACTOR_DESGASTE_MADERA = 1.0;
    private static final int DURABILIDAD_PICO_MADERA = 100;
    private static final int FUERZA_PICO_MADERA = 2;
    /*----- PicoPiedra -----*/
    private static final double FACTOR_DESGASTE_PIEDRA = (1 / 1.5);
    private static final int DURABILIDAD_PICO_PIEDRA = 200;
    private static final int FUERZA_PICO_PIEDRA = 4;
    /*----- PicoMetal -----*/
    private static final double FACTOR_DESGASTE_METAL = 0.5;
    private static final int DURABILIDAD_PICO_METAL = 400;
    private static final int FUERZA_PICO_METAL = 12;

    private Pico(EstrategiaDesgaste estrategia, int durabilidad, int fuerza, Material material) {
        this.estado = new EstadoVivo(durabilidad);
        this.estrategia = estrategia;
        this.fuerza = fuerza;
        this.material = material;
    }

    public static Pico nuevoPicoMadera() {
        Pico picoMadera = new Pico(new DesgasteLinealFactor(FACTOR_DESGASTE_MADERA), DURABILIDAD_PICO_MADERA, FUERZA_PICO_MADERA, new Madera());
        return picoMadera;
    }

    public static Pico nuevoPicoPiedra() {
        Pico picoPiedra = new Pico(new DesgasteLinealFactor(FACTOR_DESGASTE_PIEDRA), DURABILIDAD_PICO_PIEDRA, FUERZA_PICO_PIEDRA, new Piedra());
        return picoPiedra;
    }

    public static Pico nuevoPicoMetal() {
        Pico picoMetal = new Pico(new DesgasteAbrupto(), DURABILIDAD_PICO_METAL, FUERZA_PICO_METAL, new Metal());
        return picoMetal;
    }

    /*@Override
    public void desgastarMaterial(Material material){
        material.desgastarCon(this);
    }*/
    @Override
    public Desgastable desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}
    @Override
    public Desgastable desgastarContra(Piedra piedra){
        piedra.reducirDurabilidad(this.fuerza);
        return null;
    }
    @Override
    public Desgastable desgastarContra(Metal metal){
        //Razonar mejor para tripledispatch.. QUITAR
        if(this.material.desgastarContra(metal) == null) return null;
        metal.reducirDurabilidad(this.fuerza);
        return null;
    }


    //@Override
    //public void desgastarPiedra(Piedra piedra) { this.material.desgastarPiedra(piedra, fuerza); }
}
