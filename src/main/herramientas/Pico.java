package main.herramientas;

import main.estados.EstadoVivo;
import main.estrategias.EstrategiaDesgaste;
import main.materiales.*;

import java.util.Objects;
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

    @Override
    public int hashCode() {
        //Verificar que esto no rompa el inventario QUITAR
        return Objects.hash(this.getClass(),this.estrategia.getClass(),this.material.getClass(),this.fuerza);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Pico unPico = (Pico) obj;
        if (this.getDurabilidad() != unPico.getDurabilidad() || this.getFuerza() != unPico.getFuerza()) return false;
        return true;
    }
}
