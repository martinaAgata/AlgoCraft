package main.estrategias;

import main.estados.Estado;

public class DesgasteLinealFactor implements EstrategiaDesgaste {
    private double factorDesgaste;

    public DesgasteLinealFactor(double factorDesgaste){
        this.factorDesgaste = factorDesgaste;
    }

    @Override
    public Estado desgastar(int fuerza, Estado estado) {
        Double fuerzaFinal = ((double) fuerza) * this.factorDesgaste;
        return estado.desgastar(fuerzaFinal.intValue());
    }
}

