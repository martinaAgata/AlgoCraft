package modelo.exceptions;

public class NoSePuedeEliminarPorqueEstaVacioException extends RuntimeException {
    public NoSePuedeEliminarPorqueEstaVacioException(String s) {
        super(s);
    }
}
