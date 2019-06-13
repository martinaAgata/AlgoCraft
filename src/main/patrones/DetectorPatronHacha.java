package main.patrones;

package main.patrones;

import main.ConstructorDeHerramientas;
import main.mapa.Mapa;
import main.materiales.Material;

public class DetectorPatronHacha extends DetectorPatron {
    private final Material materialParteSuperior;
    private final Mapa mapa;

    public DetectorPatronHacha(Material material, ConstructorDeHerramientas constructor) {
        super(constructor);
        this.materialParteSuperior = material;
        this.crearMapa();
    }

    public DetectorPatronHacha(Material material, ConstructorDeHerramientas constructor, DetectorPatron siguiente) {
        super(constructor, siguiente);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    private void crearMapa(Material material) {
        return new PatronHacha(material);
    }
}
