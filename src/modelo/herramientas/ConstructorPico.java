package modelo.herramientas;

public class ConstructorPico extends ConstructorHerramientaAbstracto {

    @Override
    public Pico construir() {
        return new Pico(desgaste, durabilidad, fuerza, material);
    }
}
