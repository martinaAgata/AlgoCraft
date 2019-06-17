package main.herramientas;

public class ConstructorPicoFino extends ConstructorHerramientaAbstracto {

    @Override
    public Herramienta construir() {
        return new PicoFino(desgaste, durabilidad, fuerza);
    }
}
