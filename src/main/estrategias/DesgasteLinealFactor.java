package main.estrategias;

import main.Estado;

public class DesgasteLinealFactor implements EstrategiaDesgaste {
    private double factorDesgaste;

    public DesgasteLinealFactor(double factorDesgaste){
        this.factorDesgaste = factorDesgaste;
    }

    @Override
    public Estado desgastar(int fuerza, Estado estado) {
        double fuerzaFinal = ((double) fuerza) * this.factorDesgaste;
        return estado.desgastar((int)fuerzaFinal);
    }
}

