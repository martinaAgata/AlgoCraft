package main.patrones;

import main.ConstructorDeHerramientas;
import main.mapa.Mapa;
import main.materiales.Material;

public class DetectorPatronPico extends DetectorPatron {
    private final Material materialParteSuperior;
    private final Mapa mapa;

    public DetectorPatronPico(Material material, ConstructorDeHerramientas constructor) {
        super(constructor);
        this.materialParteSuperior = material;
        this.crearMapa();
    }

    public DetectorPatronPico(Material material, ConstructorDeHerramientas constructor, DetectorPatron siguiente) {
        super(constructor, siguiente);
        this.materialParteSuperior = material;
        this.crearMapa(material);
    }

    private void crearMapa(Material material) {
        return new PatronPico(material);
    }

    protected Mapa getMapaPatron() {
        return mapa;
    }

}