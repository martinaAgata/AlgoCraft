package main.herramientas;

import main.estados.EstadoVivo;
import main.estrategias.EstrategiaDesgaste;
import main.materiales.Desgastable;
import main.materiales.Madera;
import main.materiales.Material;

import java.util.Optional;

public class Hacha extends Herramienta {

    public Hacha(EstrategiaDesgaste estrategia, int durabilidad, int fuerza, Material material) {
        this.estrategia = estrategia;
        this.estado = new EstadoVivo(durabilidad);
        this.fuerza = fuerza;
        this.material = material;
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

}
