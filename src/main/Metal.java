package main;

public class Metal extends Material {

    @Override
    public void desgastar(PicoPiedra pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }
}
