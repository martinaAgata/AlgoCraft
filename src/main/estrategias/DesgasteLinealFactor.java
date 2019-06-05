package main.estrategias;

import main.Estado;

public class DesgasteLinealFactor implements EstrategiaDesgaste {
    @Override
    public Estado desgastar(int fuerza, Estado estado) {
        double fuerzaFinal = ((double) fuerza) / 1.5;
        return estado.desgastar((int)fuerzaFinal);
    }
}

