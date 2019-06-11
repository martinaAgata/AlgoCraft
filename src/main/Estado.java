package main;

public interface Estado {

    Estado desgastar(int fuerza);

    boolean sePuedeUsar(); // corregir

    int getDurabilidad();


}
