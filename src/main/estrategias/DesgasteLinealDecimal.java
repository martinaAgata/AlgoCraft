package main.estrategias;

import main.Estado;

public class DesgasteLinealDecimal implements EstrategiaDesgaste {
    @Override
    public Estado desgastar(int fuerza, Estado estado) {
        double fuerzaFinal = ((double) fuerza) * 0.1;
        return estado.desgastar((int)fuerzaFinal);
    }
}

