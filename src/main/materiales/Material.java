package main.materiales;
import main.Estado;
import main.Ubicable;
import main.herramientas.Hacha;
import main.herramientas.Herramienta;
import main.herramientas.Pico;
import main.herramientas.PicoFino;

public abstract class Material implements Desgastable, Ubicable {

    protected Estado estado;

    public Material desgastarCon(Herramienta herramienta){ return this; }
    public void reducirDurabilidad(int fuerza) {
        estado = estado.desgastar(fuerza);
    }

    public int getDurabilidad() {
        return this.estado.getDurabilidad();
    }

    public Desgastable desgastarContra(Desgastable desgastable){ return null;}
    public Desgastable desgastarContra(Pico pico){ return null; }
    public Desgastable desgastarContra(Hacha pico){ return null; }
    public Desgastable desgastarContra(PicoFino pico){ return null; }
    public Desgastable desgastarContra(Madera madera){ return null; }
    public Desgastable desgastarContra(Piedra piedra){ return null; }
    public Desgastable desgastarContra(Metal metal){ return null; }
    public Desgastable desgastarContra(Diamante diamante){ return null; }
}
