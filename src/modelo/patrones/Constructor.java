package modelo.patrones;

import modelo.herramientas.Herramienta;

public interface Constructor<T extends Herramienta> {

    T construir();

}
