package main.patrones;

import main.herramientas.ConstructorHerramienta;
import main.herramientas.Pico;
import main.materiales.Material;
import java.lang.reflect.Constructor;

public class DetectorPatronPico extends DetectorPatron {
    private final Material materialParteSuperior;

    public DetectorPatronPico(Material material, ConstructorHerramienta constructor) {
        super(constructor);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    public DetectorPatronPico(Material material, ConstructorHerramienta constructor, DetectorPatron siguiente) {
        super(constructor, siguiente);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    private void crearMapa(Material material) {
        this.patron = new PatronPico(material);
    }
}