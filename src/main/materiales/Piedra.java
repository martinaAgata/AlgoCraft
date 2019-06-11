package main.materiales;

import main.EstadoVivo;

public class Piedra extends Material {

    public static final int DURABILIDAD_PIEDRA = 30;
    public Piedra() {
        this.estado = new EstadoVivo(DURABILIDAD_PIEDRA);
    }

/*    @Override
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
    }*/
}
