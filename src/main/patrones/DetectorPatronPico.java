package main.patrones;

import main.ConstructorDeHerramientas;
import main.herramientas.Hacha;
import main.herramientas.Pico;
import main.mapa.Mapa;
import main.materiales.Material;

import java.lang.reflect.Constructor;

public class DetectorPatronPico extends DetectorPatron {
    private final Material materialParteSuperior;
    private Patron mapa;

    public DetectorPatronPico(Material material, Constructor<Pico> constructor) {
        super(constructor);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    public DetectorPatronPico(Material material,Constructor<Pico> constructor, DetectorPatron siguiente) {
        super(constructor, siguiente);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    private void crearMapa(Material material) {
        this.mapa = new PatronPico(material);
    }

    protected Patron getMapaPatron() {
        return mapa;
    }

}