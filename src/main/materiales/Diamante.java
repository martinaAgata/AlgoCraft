package main.materiales;

import main.herramientas.PicoFino;

public class Diamante extends Material {
    private static final int DURABILIDAD_DIAMANTE = 100;

    public Diamante(int durabilidad) {
        super(DURABILIDAD_DIAMANTE);
    }
    @Override
    public void desgastar(PicoFino pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }
}
