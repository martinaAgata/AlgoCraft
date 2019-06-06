package main;

import main.herramientas.HachaMadera;
import main.herramientas.Herramienta;


public class Jugador {
    //Atributos
    private Herramienta herramientaActual;

    //Constructor
    public Jugador() {
        HachaMadera hachaMadera = new HachaMadera();
        this.herramientaActual = hachaMadera;
    }
    public Herramienta obtenerHerramientaActual() {
        return herramientaActual;
    }
}