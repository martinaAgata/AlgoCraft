package main.patrones;

import main.herramientas.ConstructorHerramienta;
import main.herramientas.Hacha;
import main.materiales.Material;
import java.lang.reflect.Constructor;

public class DetectorPatronHacha extends DetectorPatron {
    private final Material materialParteSuperior; CHEQUEAR SI SE USA

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
