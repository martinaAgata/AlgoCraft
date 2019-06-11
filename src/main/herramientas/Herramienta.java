package main.herramientas;

import main.Estado;
import main.EstadoVivo;
import main.materiales.*;
import main.estrategias.EstrategiaDesgaste;

public abstract class Herramienta {

    protected Estado estado;
    protected EstrategiaDesgaste estrategia;
    protected int fuerza;
    protected Material material;

    public void usar(Material material) {
        this.estado = estrategia.desgastar(fuerza, estado);
        this.desgastarMaterial(material);
    }

    public int getDurabilidad() {
        return estado.getDurabilidad();
    }

    public int getFuerza() {
        return fuerza;
    }

    protected abstract void desgastarMaterial(Material material);

    public void desgastarPiedra(Piedra piedra) {
    }

    public void desgastarMetal(Metal metal) {
    }

    public void desgastarMadera(Madera madera) {
    }

    public void desgastarDiamante(Diamante diamante) {
    }

}