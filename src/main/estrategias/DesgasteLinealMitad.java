package main.estrategias;

import main.Estado;

public class DesgasteLinealMitad implements EstrategiaDesgaste {
    @Override
    public Estado desgastar(int fuerza, Estado estado) {
        return estado.desgastar(fuerza/2);
    }
}

