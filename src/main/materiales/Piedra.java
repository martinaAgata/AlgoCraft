package main.materiales;

import main.EstadoVivo;
import main.herramientas.PicoMadera;
import main.herramientas.PicoMetal;
import main.herramientas.PicoPiedra;

public class Piedra extends Material {

    private static final int DURABILIDAD_PIEDRA = 30;
    public Piedra() {
        this.estado = new EstadoVivo(DURABILIDAD_PIEDRA);
    }

    @Override
    public void desgastar(PicoMadera pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }

    @Override
    public void desgastar(PicoMetal pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }

    @Override
    public void desgastar(PicoPiedra pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }
}
