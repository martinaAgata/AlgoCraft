package main.herramientas;

import main.estados.EstadoVivo;
import main.estrategias.EstrategiaDesgaste;
import main.materiales.Desgastable;
import main.materiales.Diamante;

import java.util.Objects;
import java.util.Optional;

public class PicoFino extends Herramienta {

    private static final int DURABILIDAD_PICO_FINO = 1000;
    private static final int FUERZA_PICO_FINO = 20;
    private static final double FACTOR_DESGASTE = 0.1;

    public PicoFino(EstrategiaDesgaste estrategia, int durabilidad, int fuerza) {
        this.estado = new EstadoVivo(durabilidad);
        this.estrategia = estrategia;
        this.fuerza = fuerza;
    }

    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}

    @Override
    public Optional<Desgastable> desgastarContra(Diamante diamante) {
        //if(diamante == null) return null;
        this.desgastarMaterial(diamante);
        return Optional.empty();
    }

    public void desgastarMaterial(Diamante diamante) {
        diamante.reducirDurabilidad(this.fuerza);
    }

    @Override
    public int hashCode() {
        //Verificar que esto no rompa el inventario QUITAR
        return Objects.hash(this.getClass(),this.estrategia.getClass(),this.fuerza);
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