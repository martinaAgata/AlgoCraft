package main.mapa;
import main.Ubicable;
import main.exceptions.CasilleroEstaOcupadoException;

import java.util.Objects;
import java.util.Optional;

public class Casillero {
    private Optional<Ubicable> ubicableOptional = Optional.empty();
    public void guardarUbicable(Ubicable u) {
        if (this.ubicableOptional.isPresent()) { throw new CasilleroEstaOcupadoException("No es posible guardar, el casillero se encuentra ocupado"); }
        this.ubicableOptional = Optional.of(u);
    }

    public Ubicable eliminarUbicable() {
        if (!this.ubicableOptional.isPresent()) { return null; }
        Ubicable ubicable = this.ubicableOptional.get();
        this.ubicableOptional = Optional.empty();
        return ubicable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casillero casillero = (Casillero) o;
        return Objects.equals(ubicableOptional, casillero.ubicableOptional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ubicableOptional);
    }
}
