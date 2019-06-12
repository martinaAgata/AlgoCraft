package main.mapa;
import main.Ubicable;
import main.exceptions.CasilleroEstaOcupadoException;

import java.util.Optional;

public class Casillero {
    private Optional<Ubicable> ubicableOptional = Optional.empty();
    public void guardarUbicable(Ubicable u) {
        if (this.ubicableOptional.isEmpty()) { throw new CasilleroEstaOcupadoException("No es posible guardar, el casillero se encuentra ocupado");
        this.ubicableOptional = Optional.of(u);
    }
}
