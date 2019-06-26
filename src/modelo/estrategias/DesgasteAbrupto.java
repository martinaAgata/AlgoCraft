package modelo.estrategias;

import modelo.estados.Estado;
import modelo.estados.EstadoMuerto;

public class DesgasteAbrupto implements EstrategiaDesgaste {

    private int cantidadUsos = 0;

    @Override
    public Estado desgastar(int fuerza, Estado estado) {
        cantidadUsos++;
        estado.desgastar(0);
        if (cantidadUsos >= 10) return new EstadoMuerto();
        else return estado;
    }
}
