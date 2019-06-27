package modelo.herramientas;

import modelo.estados.EstadoVivo;
import modelo.estrategias.EstrategiaDesgaste;
import modelo.materiales.Desgastable;
import modelo.materiales.Diamante;
import java.util.Objects;
import java.util.Optional;

public class PicoFino extends Herramienta {

    public PicoFino(EstrategiaDesgaste estrategia, int durabilidad, int fuerza) {
        this.estado = new EstadoVivo(durabilidad);
        this.estrategia = estrategia;
        this.fuerza = fuerza;
    }

    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);
    }

    @Override
    public Optional<Desgastable> desgastarContra(Diamante diamante) {
        diamante.reducirDurabilidad(this.fuerza);
        return Optional.empty();
    }

    @Override
    public int hashCode() {
        //Verificar que esto no rompa el inventario QUITAR
        return Objects.hash(this.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        PicoFino unPico = (PicoFino) obj;
        if (this.getDurabilidad() != unPico.getDurabilidad() || this.getFuerza() != unPico.getFuerza()) return false;
        return true;
    }
}