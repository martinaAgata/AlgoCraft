package main;

public class Piedra extends Material {

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
