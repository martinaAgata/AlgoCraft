package main.materiales;

import main.Desgastable;
import main.Estado;
import main.EstadoVivo;

public abstract class Material implements Desgastable {

    private Estado estado;

    public Material (int durabilidad) {
        this.estado = new EstadoVivo(durabilidad);
    }

    protected void reducirDurabilidad(int fuerza) {
        estado = estado.desgastar(fuerza);
    }

    public int getDurabilidad() {
        return this.estado.getDurabilidad();
    }
}
