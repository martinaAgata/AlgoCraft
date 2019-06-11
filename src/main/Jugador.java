package main;
import main.herramientas.Hacha;
import main.herramientas.Herramienta;

public class Jugador implements Ubicable {
    //Atributos
    private Herramienta herramientaActual;

    //Constructor
    public Jugador() {
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
        this.herramientaActual = hachaMadera;
    }
    public Herramienta obtenerHerramientaActual() {
        return herramientaActual;
    }
}