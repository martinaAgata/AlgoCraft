package modelo.herramientas;

import modelo.estados.Estado;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.NoSePuedeDesgastarUnElementoConEstadoMuertoException;
import modelo.materiales.*;
import modelo.estrategias.EstrategiaDesgaste;

public abstract class Herramienta implements Desgastable{

    protected Estado estado;
    protected EstrategiaDesgaste estrategia;
    protected int fuerza;
    protected Material material;

    public void usar(Material material) {
        this.desgastarContra(material);
        try {
            this.estado = estrategia.desgastar(fuerza, estado);
        } catch (NoSePuedeDesgastarUnElementoConEstadoMuertoException e) {
            throw new HerramientaRotaNoPuedeDesgastarseException("La herramienta se ha roto y ya no puede usarse");
        }
    }

    public int getDurabilidad() {
        return estado.getDurabilidad();
    }

    public int getFuerza() {
        return fuerza;
    }
}