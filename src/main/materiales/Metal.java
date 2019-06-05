package main.materiales;

import main.herramientas.PicoPiedra;

public class Metal extends Material {
    private static final int DURABILIDAD_METAL = 50;

    public Madera(int durabilidad) {
        super(DURABILIDAD_METAL);
    }
    @Override
    public void desgastar(PicoPiedra pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }
}
