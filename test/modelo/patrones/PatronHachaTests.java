package modelo.patrones;

import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import modelo.patrones.PatronHacha;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PatronHachaTests {

    @Test
    public void testPatronHachaMaderaInicializaTableroCorrectamente(){
        //    1        2       3
        // Madera | Madera |         1
        // Madera | Madera |         2
        //        | Madera |         3

        Mapa tableroHachaMadera = new Mapa(3,3);
        tableroHachaMadera.ubicarEnCasillero((new Madera()),(new Ubicacion(1,1)));
        tableroHachaMadera.ubicarEnCasillero((new Madera()),(new Ubicacion(2,1)));
        tableroHachaMadera.ubicarEnCasillero((new Madera()),(new Ubicacion(1,2)));
        tableroHachaMadera.ubicarEnCasillero((new Madera()),(new Ubicacion(2,2)));
        tableroHachaMadera.ubicarEnCasillero((new Madera()),(new Ubicacion(2,3)));
        PatronHacha patronHachaMadera = new PatronHacha((new Madera()));
        assertTrue(tableroHachaMadera.esIgualA(patronHachaMadera.getMapa()));

    }
    @Test
    public void testPatronHachaPiedraInicializaTableroCorrectamente(){
        //    1        2       3
        // Piedra | Piedra |         1
        // Piedra | Madera |         2
        //        | Madera |         3

        Mapa tableroHachaPiedra = new Mapa(3,3);
        tableroHachaPiedra.ubicarEnCasillero((new Piedra()),(new Ubicacion(1,1)));
        tableroHachaPiedra.ubicarEnCasillero((new Piedra()),(new Ubicacion(2,1)));
        tableroHachaPiedra.ubicarEnCasillero((new Piedra()),(new Ubicacion(1,2)));
        tableroHachaPiedra.ubicarEnCasillero((new Madera()),(new Ubicacion(2,2)));
        tableroHachaPiedra.ubicarEnCasillero((new Madera()),(new Ubicacion(2,3)));
        PatronHacha patronHachaPiedra = new PatronHacha((new Piedra()));
        assertTrue(tableroHachaPiedra.esIgualA(patronHachaPiedra.getMapa()));

    }

    @Test
    public void testPatronHachaMetalInicializaTableroCorrectamente(){
        //    1        2       3
        //  Metal | Metal  |         1
        //  Metal | Madera |         2
        //        | Madera |         3

        Mapa tableroHachaMetal = new Mapa(3,3);
        tableroHachaMetal.ubicarEnCasillero((new Metal()),(new Ubicacion(1,1)));
        tableroHachaMetal.ubicarEnCasillero((new Metal()),(new Ubicacion(2,1)));
        tableroHachaMetal.ubicarEnCasillero((new Metal()),(new Ubicacion(1,2)));
        tableroHachaMetal.ubicarEnCasillero((new Madera()),(new Ubicacion(2,2)));
        tableroHachaMetal.ubicarEnCasillero((new Madera()),(new Ubicacion(2,3)));
        PatronHacha patronHachaMetal = new PatronHacha((new Metal()));
        assertTrue(tableroHachaMetal.esIgualA(patronHachaMetal.getMapa()));

    }


}
