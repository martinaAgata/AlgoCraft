package main;

public interface Desgastable {

    default void desgastar(Pico p) {};
    default void desgastar(PicoFino p) {};
    default void desgastar(Hacha h) {};
}
