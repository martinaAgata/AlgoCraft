package modelo.estrategias;

import modelo.estados.Estado;

public interface EstrategiaDesgaste {

    Estado desgastar(int fuerza, Estado estado);

}
