package main.patrones;

import main.herramientas.Herramienta;

public interface Constructor<T extends Herramienta> {

    T construir();

}
