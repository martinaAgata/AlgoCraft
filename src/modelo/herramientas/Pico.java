package modelo.herramientas;

import modelo.estados.EstadoVivo;
import modelo.estrategias.EstrategiaDesgaste;
import modelo.materiales.*;
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
        return Objects.hash(this.getClass(),this.material.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Pico unPico = (Pico) obj;
        if (this.getFuerza() != unPico.getFuerza()) return false;
        return true;
    }
}
