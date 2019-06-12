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

}
