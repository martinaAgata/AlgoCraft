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
        try {
            this.estado = estrategia.desgastar(fuerza, estado);
        } catch (NoSePuedeDesgastarUnElementoConEstadoMuertoException e) {
            throw new HerramientaRotaNoPuedeDesgastarseException("La herramienta se ha roto y ya no puede usarse");
        }
        this.desgastarContra(material);
    }

    public int getDurabilidad() {
        return estado.getDurabilidad();
    }

    public int getFuerza() {
        return fuerza;
    }

    public boolean esIgualA(Herramienta herramienta){
        if(this == herramienta) return true;
        if(this.getClass() != herramienta.getClass()) return false;
        if(this.getDurabilidad() != herramienta.getDurabilidad() || this.getFuerza() != herramienta.getFuerza()) return  false;
        return true;
    }
}