package main.mapa;
import main.Ubicable;
import java.util.Optional;

public class Casillero {
    private Optional<Ubicable> ubicableOptional = Optional.empty();
    public void guardarUbicable(Ubicable u) {
        this.ubicableOptional = Optional.of(u);
    }
}
