package main;

import main.mapa.Mapa;
import main.mapa.Ubicacion;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import main.patrones.PatronPicoFino;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PatronPicoFinoTests {
    @Test
    public void testPatronPicoMetalInicializaTableroCorrectamente(){
        //    1        2       3
        //  Metal | Metal  | Metal   1
        // Piedra | Madera |         2
        //        | Madera |         3

        Mapa tableroPicoFinco = new Mapa(3,3);
        tableroPicoFinco.ubicarEnCasillero((new Metal()),(new Ubicacion(1,1)));
        tableroPicoFinco.ubicarEnCasillero((new Metal()),(new Ubicacion(2,1)));
        tableroPicoFinco.ubicarEnCasillero((new Metal()),(new Ubicacion(3,1)));
        tableroPicoFinco.ubicarEnCasillero(new Piedra(), new Ubicacion(1,2));
        tableroPicoFinco.ubicarEnCasillero((new Madera()),(new Ubicacion(2,2)));
        tableroPicoFinco.ubicarEnCasillero((new Madera()),(new Ubicacion(2,3)));
        PatronPicoFino patronPicoFino = new PatronPicoFino((new Metal()));
        assertTrue(tableroPicoFinco.esIgualA(patronPicoFino.getMapa()));

    }
}
