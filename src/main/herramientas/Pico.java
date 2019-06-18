package main.herramientas;

import main.estados.EstadoVivo;
import main.estrategias.EstrategiaDesgaste;
import main.materiales.*;

import java.util.Optional;

public class Pico extends Herramienta {

    public Pico(EstrategiaDesgaste estrategia, int durabilidad, int fuerza, Material material) {
        this.estado = new EstadoVivo(durabilidad);
        this.estrategia = estrategia;
        this.fuerza = fuerza;
        this.material = material;
    }

    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){
        return desgastable.desgastarContra(this);
    }

    @Override
    public Optional<Desgastable> desgastarContra(Piedra piedra){
        piedra.reducirDurabilidad(this.fuerza);
        return Optional.empty();
    }

    @Override
    public Optional<Desgastable> desgastarContra(Metal metal){
        if (this.material.desgastarContra(metal).isPresent()) {
            metal.reducirDurabilidad(this.fuerza);
        }
        return Optional.empty();
    }

}
