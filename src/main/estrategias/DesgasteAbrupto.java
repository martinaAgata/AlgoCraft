package main.estrategias;

import main.estados.Estado;
import main.estados.EstadoMuerto;

public class DesgasteAbrupto implements EstrategiaDesgaste {

    private int cantidadUsos = 0;

    @Override
    public Estado desgastar(int fuerza, Estado estado) {
        cantidadUsos++;
        if (cantidadUsos > 10) return new EstadoMuerto();
        else return estado;
    }
}
