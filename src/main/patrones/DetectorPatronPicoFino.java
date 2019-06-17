package main.patrones;

import main.herramientas.PicoFino;
import main.materiales.Material;
import java.lang.reflect.Constructor;

public class DetectorPatronPicoFino extends DetectorPatron {
    private final Material materialParteSuperior;

    public DetectorPatronPicoFino(Material material, Constructor<PicoFino> constructor) {
        super(constructor);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    public DetectorPatronPicoFino(Material material, Constructor<PicoFino> constructor, DetectorPatron siguiente) {
        super(constructor, siguiente);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    private void crearMapa(Material material) {
        this.patron = new PatronPicoFino(material);
    }
}
