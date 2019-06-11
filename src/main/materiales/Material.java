package main.materiales;
import main.Estado;
import main.Ubicable;

public abstract class Material implements Desgastable, Ubicable {

    protected Estado estado;

    protected void reducirDurabilidad(int fuerza) {
        estado = estado.desgastar(fuerza);
    }

    public int getDurabilidad() {
        return this.estado.getDurabilidad();
    }
}
