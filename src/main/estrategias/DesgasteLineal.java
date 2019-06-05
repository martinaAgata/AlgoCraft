package main.estrategias;

import main.Estado;

public class DesgasteLineal implements EstrategiaDesgaste {

    @Override
    public Estado desgastar(int fuerza, Estado estado) {
        return estado.desgastar(fuerza);
    }
}