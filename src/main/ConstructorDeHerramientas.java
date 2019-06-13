package main;

import main.exceptions.NoHayHerramientaParaCrearException;
import main.herramientas.Herramienta;
import main.mapa.Mapa;
import main.mapa.Ubicacion;
import main.materiales.Material;
import main.patrones.DetectorPatron;
import java.util.Optional;

public class ConstructorDeHerramientas {
    private Mapa tablero;
    private DetectorPatron detectorPatron;
    private Optional<Herramienta> herramientaCreada;

    public ConstructorDeHerramientas() {
        this.tablero = new Mapa(3, 3);
    }

    public void insertarMaterial(Material material, Ubicacion ubicacion) {
        this.tablero.ubicarEnCasillero(material, ubicacion);
        this.identificarPatron();
    }

    public Material quitarMaterial(Ubicacion ubicacion) {
        Material material = (Material) this.tablero.eliminarDeCasillero(ubicacion);
        this.identificarPatron();
        return material;
    }

    private void identificarPatron() {
        this.herramientaCreada = this.detectorPatron.resolver(this.tablero);
    }

    public Herramienta crearHerramienta() {
        if(!herramientaCreada.isPresent()) throw new NoHayHerramientaParaCrearException("No se puede crear una herramienta con lo dispuesto en el tablero");
        return this.herramientaCreada.get();
    }
}