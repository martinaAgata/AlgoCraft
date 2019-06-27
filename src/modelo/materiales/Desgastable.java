package modelo.materiales;

import modelo.herramientas.*;
import java.util.Optional;

public interface Desgastable {

    default Optional<Desgastable> desgastarContra(Desgastable desgastable) {
        return Optional.empty();
    }
    default Optional<Desgastable> desgastarContra(Pico pico) {
        return Optional.empty();
    }
    default Optional<Desgastable> desgastarContra(Hacha hacha) {
        return Optional.empty();
    }
    default Optional<Desgastable> desgastarContra(PicoFino picoFino) {
        return Optional.empty();
    }
    default Optional<Desgastable> desgastarContra(Madera madera) {
        return Optional.empty();
    }
    default Optional<Desgastable> desgastarContra(Piedra piedra) {
        return Optional.empty();
    }
    default Optional<Desgastable> desgastarContra(Metal metal) {
        return Optional.empty();
    }
    default Optional<Desgastable> desgastarContra(Diamante diamante) { return Optional.empty();
    }
}
