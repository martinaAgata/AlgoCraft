package main;

import main.estrategias.DesgasteLineal;
import main.herramientas.HachaMadera;
import main.herramientas.Herramienta;
import main.materiales.Material;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    //Atributos
    //private List<Material> inventario;
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