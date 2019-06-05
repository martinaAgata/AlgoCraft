package main.materiales;

import main.herramientas.HachaMadera;
import main.herramientas.HachaMetal;
import main.herramientas.HachaPiedra;

public class Madera extends Material {

    private static final int DURABILIDAD_MADERA = 10;

    public Madera(int durabilidad) {
        super(DURABILIDAD_MADERA);
    }

    @Override
    public void desgastar(HachaMadera hacha) {
        int fuerza = hacha.getFuerza();
        this.reducirDurabilidad(fuerza);
    }

    @Override
    public void desgastar(HachaMetal hacha) {
        int fuerza = hacha.getFuerza();
        this.reducirDurabilidad(fuerza);
    }

    @Override
    public void desgastar(HachaPiedra hacha) {
        int fuerza = hacha.getFuerza();
        this.reducirDurabilidad(fuerza);
    }

}
