package main.estrategias;

import main.Estado;

public interface EstrategiaDesgaste {

    Estado desgastar(int fuerza, Estado estado);


}
