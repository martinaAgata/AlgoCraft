package modelo.herramientas;

import modelo.estados.EstadoVivo;
import modelo.estrategias.EstrategiaDesgaste;
import modelo.materiales.Desgastable;
import modelo.materiales.Madera;
import modelo.materiales.Material;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        //Verificar que esto no rompa el inventario QUITAR
        return Objects.hash(this.getClass(),this.material.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Hacha unHacha = (Hacha) obj;
        if (this.getDurabilidad() != unHacha.getDurabilidad() || this.getFuerza() != unHacha.getFuerza()) return false;
        return true;
    }

}
