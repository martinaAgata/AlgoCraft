package modelo.patrones;

import modelo.herramientas.ConstructorHerramienta;
import modelo.materiales.Material;

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