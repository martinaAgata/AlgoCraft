package main.herramientas;

import main.Estado;
import main.EstadoVivo;
import main.materiales.*;
import main.estrategias.EstrategiaDesgaste;
import sun.security.krb5.internal.crypto.Des;

public abstract class Herramienta implements Desgastable{

    protected Estado estado;
    protected EstrategiaDesgaste estrategia;
    protected int fuerza;
    protected Material material;

    public void usar(Material material) {
        this.desgastarContra(material);
        this.estado = estrategia.desgastar(fuerza, estado);
    }

    public int getDurabilidad() {
        return estado.getDurabilidad();
    }

    public int getFuerza() {
        return fuerza;
    }

    protected void desgastarMaterial(Material material){
        this.desgastarMaterial(material.desgastarCon(this));
    }

/*    public void desgastarMaterial(Piedra piedra) { }

    public void desgastarMaterial(Metal metal) { }

    public void desgastarMaterial(Madera madera) { }

    public void desgastarMaterial(Diamante diamante) { }*/

    public Desgastable desgastarContra(Desgastable desgastable){ return null;}
    public Desgastable desgastarContra(Pico pico){ return null; }
    public Desgastable desgastarContra(Hacha pico){ return null; }
    public Desgastable desgastarContra(PicoFino pico){ return null; }
    public Desgastable desgastarContra(Madera madera){ return null; }
    public Desgastable desgastarContra(Piedra piedra){ return null; }
    public Desgastable desgastarContra(Metal metal){ return null; }
    public Desgastable desgastarContra(Diamante diamante){ return null; }


}