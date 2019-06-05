package main;

public class DesgasteLineal implements EstrategiaDesgaste {

    @Override
    public int calcularDesgaste(int fuerza,int durabilidad) {
        if (fuerza > durabilidad) return 0;
        return durabilidad - fuerza;
    }
}