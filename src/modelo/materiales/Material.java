package modelo.materiales;
import modelo.estados.Estado;
import modelo.herramientas.Herramienta;
import modelo.juego.ObjetoUbicable;
import modelo.juego.Ubicable;

public abstract class Material extends ObjetoUbicable implements Desgastable {

    protected Estado estado;

    public Material desgastarCon(Herramienta herramienta){ return this; }
    public void reducirDurabilidad(int fuerza) {
        estado = estado.desgastar(fuerza);
    }
    public int getDurabilidad() {
        return this.estado.getDurabilidad();
    }

}
