package main.materiales;

import main.Estado;
import main.EstadoVivo;

public abstract class Material implements Desgastable {

    private Estado estado;
    private int fuerza;

    public Material(int durabilidad, int fuerza) {
        this.estado = new EstadoVivo(durabilidad);
        this.fuerza = fuerza;
    }

    protected void reducirDurabilidad(int fuerza) {
        estado = estado.desgastar(fuerza);
    }

    public int getDurabilidad() {
        return this.estado.getDurabilidad();
    }
}
