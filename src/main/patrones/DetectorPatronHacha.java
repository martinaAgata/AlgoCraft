package main.patrones;

import main.herramientas.Hacha;
import main.materiales.Material;

public class DetectorPatronHacha extends DetectorPatron {
    private final Material materialParteSuperior;
    private Patron mapa;

    public DetectorPatronHacha(Material material, Constructor<Hacha> constructor) {
        super(constructor);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    public DetectorPatronHacha(Material material, Constructor<Hacha> constructor, DetectorPatron siguiente) {
        super(constructor, siguiente);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    private void crearMapa(Material material) {
        this.mapa = new PatronHacha(material);
    }

    @Override
    protected Patron getMapaPatron() {
        return mapa;
    }
}
