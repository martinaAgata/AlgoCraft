package main;

import main.estrategias.DesgasteLineal;
import main.herramientas.HachaMadera;
import main.herramientas.Herramienta;
import main.materiales.Material;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    //Atributos
    private List<Material> inventario;
    private Herramienta herramientaActual;

    //Constructor
    public Jugador(){
        this.inventario = new ArrayList<>();
        HachaMadera hachaMadera = new HachaMadera(10, 10, new DesgasteLineal());
        this.herramientaActual = hachaMadera;
    }

}