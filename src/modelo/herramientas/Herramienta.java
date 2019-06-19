package modelo.herramientas;

import modelo.estados.Estado;
import modelo.materiales.*;
import modelo.estrategias.EstrategiaDesgaste;

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

}