package main;

public interface Estado {

    Estado desgastar(int fuerza);

    boolean sePuedeUsar();

    int getDurabilidad();


}
