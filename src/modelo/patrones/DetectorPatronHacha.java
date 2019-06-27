package modelo.patrones;

import modelo.herramientas.ConstructorHerramienta;
import modelo.materiales.Material;

public class DetectorPatronHacha extends DetectorPatron {

    private final Material materialParteSuperior;

    public DetectorPatronHacha(Material material, ConstructorHerramienta constructor) {
        super(constructor);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    public DetectorPatronHacha(Material material, ConstructorHerramienta constructor, DetectorPatron siguiente) {
        super(constructor, siguiente);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    private void crearMapa(Material material) {
        this.patron = new PatronHacha(material);
    }
}
