package main.patrones;

import main.ConstructorDeHerramientas;
import main.herramientas.Pico;
import main.herramientas.PicoFino;
import main.mapa.Mapa;
import main.materiales.Material;

public class DetectorPatronPicoFino extends DetectorPatron {
    private final Material materialParteSuperior;
    private Patron mapa;

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
        this.mapa = new PatronPicoFino(material);
    }

    @Override
    protected Patron getMapaPatron() {
        return mapa;
    }
}