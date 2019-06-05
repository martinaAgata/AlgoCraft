package main.herramientas;

import main.Estado;
import main.EstadoVivo;
import main.materiales.Material;
import main.estrategias.EstrategiaDesgaste;

public abstract class Herramienta {

    private Estado estado;
    private EstrategiaDesgaste estrategia;
    private int fuerza;

    public Herramienta(int durabilidad, int fuerza, EstrategiaDesgaste estrategia) {
        this.estado = new EstadoVivo(durabilidad);
        this.estrategia = estrategia;
        this.fuerza = fuerza;
    }

    public void usar(Material material) {
        this.estado = estrategia.desgastar(fuerza, estado);
        this.desgastarMaterial(material);
    }
    public int getDurabilidad() { return estado.getDurabilidad(); }

    public int getFuerza(){
        return fuerza;
    }

    protected abstract void desgastarMaterial(Material material);
}