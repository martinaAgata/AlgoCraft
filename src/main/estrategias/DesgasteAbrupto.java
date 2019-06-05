package main.estrategias;

import main.Estado;
import main.EstadoMuerto;

public class DesgasteAbrupto implements EstrategiaDesgaste {

    private int cantidadUsos = 0;

    @Override
    public Estado desgastar(int fuerza, Estado estado) {
        cantidadUsos++;
        if (cantidadUsos > 10) return new EstadoMuerto();
        else return estado;
    }
}
