package main.herramientas;

public class ConstructorPicoFino extends ConstructorHerramientaAbstracto {

    @Override
    public PicoFino construir() { return new PicoFino(desgaste, durabilidad, fuerza); }
}
