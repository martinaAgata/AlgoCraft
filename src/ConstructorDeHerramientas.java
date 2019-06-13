import main.exceptions.NoHayHerramientaParaCrearException;
import main.herramientas.Herramienta;
import main.mapa.Mapa;
import main.mapa.Ubicacion;
import main.materiales.Material;
import main.patrones.DetectorPatron;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
import java.util.Optional;

public class ConstructorDeHerramientas {
    private Mapa tablero;
    private DetectorPatron detectorPatron;
    private Optional<Herramienta> herramientaCreada;

    public ConstructorDeHerramientas() {
        this.tablero = new Mapa(3, 3);
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    }

    public void insertarMaterial(Material material, Ubicacion ubicacion){
        this.tablero.ubicarEnCasillero(material, ubicacion);
        this.identificarPatron();
        //Que this.detectorPatron = new DetectorPatron();hacer en base a si el Patron reconoce o no QUITAR
    }
<<<<<<< Updated upstream
    public Material quitarMaterial(Ubicacion ubicacion){
        Material material = this.tablero.quitarDeCasillero(ubicacion);
=======
    public Material quitarMaterial(Ubicacion ubicacion) {
        Material material = this.tablero.eliminarDeCasillero(ubicacion);
>>>>>>> Stashed changes
        this.identificarPatron();
        return material;
    }

<<<<<<< Updated upstream
    private void identificarPatron(){
        this.herramientaCreada = this.detectorPatron.compararPatron(this.tablero);
    }

    public Herramienta crearHerramienta(){
        if(herramientaCreada.isEmpty()) throw new NoHayHerramientaParaCrearException("No se puede crear una herramienta con lo dispuesto en el tablero");
        return this.herramientaCreada.get();
    }
}
=======
    private void identificarPatron() {
        this.herramientaCreada = this.detectorPatron.compararPatron(this.tablero);
    }

    public Herramienta crearHerramienta() {
        if(herramientaCreada.isEmpty()) throw new NoHayHerramientaParaCrearException("No se puede crear una herramienta con lo dispuesto en el tablero");
        return this.herramientaCreada.get();
    }
}
>>>>>>> Stashed changes
