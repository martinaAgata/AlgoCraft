package main;

public class DesgasteLinealMitad {
    @Override
    public int calcularDesgaste(int fuerza,int durabilidad) {
        if (fuerza > durabilidad) return 0;
        return durabilidad - (fuerza /2);
    }
}

