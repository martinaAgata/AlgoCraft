package main.estrategias;

import main.estados.Estado;

public interface EstrategiaDesgaste {

    Estado desgastar(int fuerza, Estado estado);

}
