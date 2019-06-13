package main.exceptions;

public class NoHayHerramientaParaCrearException extends RuntimeException {
    public NoHayHerramientaParaCrearException(String s) {
        super(s);
    }
}
