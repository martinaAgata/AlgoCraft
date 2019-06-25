package modelo.exceptions;

public class NoSePuedeUbicarPorqueEstaOcupadoException extends RuntimeException {
    public NoSePuedeUbicarPorqueEstaOcupadoException(String s) {
        super(s);
    }
}
