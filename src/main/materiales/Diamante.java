package main.materiales;

import main.herramientas.PicoFino;

public class Diamante extends Material {

    @Override
    public void desgastar(PicoFino pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }
}
