package main;

public class DesgasteLinealFactor {
    @Override
    public int calcularDesgaste(int fuerza,int durabilidad) {
        if (fuerza > durabilidad) return 0;
        double fuerza_final = ((double) fuerza) / 1.5;
        return durabilidad - (int) fuerza_final;
    }
}

