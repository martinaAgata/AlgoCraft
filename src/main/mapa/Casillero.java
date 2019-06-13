package main.mapa;
import main.exceptions.CasilleroVacioException;
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

    public void eliminarUbicable() {
        if (this.ubicableOptional.isEmpty()) { throw new CasilleroVacioException("No se puede eliminar nada de un casillero vacio"); }
        this.ubicableOptional = Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casillero casillero = (Casillero) o;
        if (ubicableOptional.isEmpty() && casillero.ubicableOptional.isEmpty())
            return true;
        if (ubicableOptional.isEmpty() || casillero.ubicableOptional.isEmpty())
            return false;
        return ubicableOptional.get().equals(casillero.ubicableOptional.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ubicableOptional);
    }
}
