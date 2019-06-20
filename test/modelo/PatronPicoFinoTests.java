package modelo;

import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import modelo.patrones.PatronPicoFino;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PatronPicoFinoTests {
    @Test
    public void testPatronPicoMetalInicializaTableroCorrectamente(){
        //    1        2       3
        //  Metal | Metal  | Metal   1
        // Piedra | Madera |         2
        //        | Madera |         3

        Mapa tableroPicoFino = new Mapa(3,3);
        tableroPicoFino.ubicarEnCasillero((new Metal()),(new Ubicacion(1,1)));
        tableroPicoFino.ubicarEnCasillero((new Metal()),(new Ubicacion(2,1)));
        tableroPicoFino.ubicarEnCasillero((new Metal()),(new Ubicacion(3,1)));
        tableroPicoFino.ubicarEnCasillero(new Piedra(), new Ubicacion(1,2));
        tableroPicoFino.ubicarEnCasillero((new Madera()),(new Ubicacion(2,2)));
        tableroPicoFino.ubicarEnCasillero((new Madera()),(new Ubicacion(2,3)));
        PatronPicoFino patronPicoFino = new PatronPicoFino((new Metal()));
        assertTrue(tableroPicoFino.esIgualA(patronPicoFino.getMapa()));

    }
}
