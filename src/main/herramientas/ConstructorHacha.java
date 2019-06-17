package main.herramientas;

public class ConstructorHacha extends ConstructorHerramientaAbstracto {

    @Override
    public Herramienta construir() {
        return new Hacha(desgaste, durabilidad, fuerza);
    }
}
