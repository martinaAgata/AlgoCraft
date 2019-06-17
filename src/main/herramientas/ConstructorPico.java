package main.herramientas;

public class ConstructorPico extends ConstructorHerramientaAbstracto {

    @Override
    public Herramienta construir() {
        return new Pico(desgaste, durabilidad, fuerza, material);
    }
}
