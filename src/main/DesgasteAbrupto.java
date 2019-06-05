package main;

public class DesgasteAbrupto implements EstrategiaDesgaste {

    private int cantidadUsos = 0;

    @Override
    public int calcularDesgaste(int fuerza, int durabilidad) {
        cantidadUsos++;
        if (cantidadUsos > 10) return 0;
        return fuerza;
    }
}
