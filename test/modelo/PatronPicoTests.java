package modelo;

import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import modelo.patrones.PatronPico;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PatronPicoTests {
    @Test
    public void testPatronPicoMaderaInicializaTableroCorrectamente(){
        //    1        2       3
        // Madera | Madera | Madera  1
        //        | Madera |         2
        //        | Madera |         3

        Mapa tableroPicoMadera = new Mapa(3,3);
        tableroPicoMadera.ubicarEnCasillero((new Madera()),(new Ubicacion(1,1)));
        tableroPicoMadera.ubicarEnCasillero((new Madera()),(new Ubicacion(2,1)));
        tableroPicoMadera.ubicarEnCasillero((new Madera()),(new Ubicacion(3,1)));
        tableroPicoMadera.ubicarEnCasillero((new Madera()),(new Ubicacion(2,2)));
        tableroPicoMadera.ubicarEnCasillero((new Madera()),(new Ubicacion(2,3)));
        PatronPico patronPicoMadera = new PatronPico((new Madera()));
        assertTrue(tableroPicoMadera.esIgualA(patronPicoMadera.getMapa()));

    }
    @Test
    public void testPatronPicoPiedraInicializaTableroCorrectamente(){
        //    1        2       3
        // Piedra | Piedra | Piedra  1
        //        | Madera |         2
        //        | Madera |         3

        Mapa tableroPicoPiedra = new Mapa(3,3);
        tableroPicoPiedra.ubicarEnCasillero((new Piedra()),(new Ubicacion(1,1)));
        tableroPicoPiedra.ubicarEnCasillero((new Piedra()),(new Ubicacion(2,1)));
        tableroPicoPiedra.ubicarEnCasillero((new Piedra()),(new Ubicacion(3,1)));
        tableroPicoPiedra.ubicarEnCasillero((new Madera()),(new Ubicacion(2,2)));
        tableroPicoPiedra.ubicarEnCasillero((new Madera()),(new Ubicacion(2,3)));
        PatronPico patronPicoPiedra = new PatronPico((new Piedra()));
        assertTrue(tableroPicoPiedra.esIgualA(patronPicoPiedra.getMapa()));

    }

    @Test
    public void testPatronPicoMetalInicializaTableroCorrectamente(){
        //    1        2       3
        //  Metal | Metal  | Metal   1
        //        | Madera |         2
        //        | Madera |         3

        Mapa tableroPicoMetal = new Mapa(3,3);
        tableroPicoMetal.ubicarEnCasillero((new Metal()),(new Ubicacion(1,1)));
        tableroPicoMetal.ubicarEnCasillero((new Metal()),(new Ubicacion(2,1)));
        tableroPicoMetal.ubicarEnCasillero((new Metal()),(new Ubicacion(3,1)));
        tableroPicoMetal.ubicarEnCasillero((new Madera()),(new Ubicacion(2,2)));
        tableroPicoMetal.ubicarEnCasillero((new Madera()),(new Ubicacion(2,3)));
        PatronPico patronPicoMetal = new PatronPico((new Metal()));
        assertTrue(tableroPicoMetal.esIgualA(patronPicoMetal.getMapa()));

    }

}
