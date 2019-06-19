package modelo.herramientas;

public class ConstructorHacha extends ConstructorHerramientaAbstracto {

    @Override
    public Hacha construir() {
        return new Hacha(desgaste, durabilidad, fuerza, material);
    }
}
