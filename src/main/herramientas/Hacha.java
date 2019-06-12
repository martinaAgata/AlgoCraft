package main.herramientas;

import main.EstadoVivo;
import main.estrategias.DesgasteLinealFactor;
import main.estrategias.EstrategiaDesgaste;
import main.materiales.Desgastable;
import main.materiales.Madera;
import main.materiales.Material;
import main.materiales.Piedra;

import java.util.Optional;

public class Hacha extends Herramienta {

    public Hacha(EstrategiaDesgaste estrategia, int durabilidad, int fuerza) {
        this.estrategia = estrategia;
        this.estado = new EstadoVivo(durabilidad);
        this.fuerza = fuerza;
    }

    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){
        return desgastable.desgastarContra(this);
    }

    @Override
    public Optional<Desgastable> desgastarContra(Madera madera){
        madera.reducirDurabilidad(this.fuerza);
        return Optional.empty();
    }

    /*public void desgastarMaterial(Madera madera) {
        madera.reducirDurabilidad(this.fuerza);
    }*/
}
