/*package modelo.mapaCrafteo;

<<<<<<< Updated upstream
public class MapaCrafteoTests {}
=======
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Madera;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class MapaCrafteoTests {

    Mapa tableroCrafteo;
    Juego juego;
    Mapa tableroCrafteoTest;

    @Before
    public void setUp() {
        juego = new Juego();
        tableroCrafteo = juego.obtenerTableroCrafteo();
        tableroCrafteoTest =  new Mapa(3,3);
    }

    @Test
    public void testSeCreaElMapaCorrectamenteEnJuego(){
        assertTrue((tableroCrafteo.esIgualA(tableroCrafteoTest)));
    }

    @Test
    public void testSeAgregaUnMaterialCorrectamente(){
        Madera madera = new Madera();
        juego.ubicarMaterialTableroCrafteo(new Ubicacion(1,1), madera);
        tableroCrafteoTest.ubicarEnCasillero(madera, new Ubicacion(1,1));
        assertTrue(tableroCrafteo.esIgualA(tableroCrafteoTest));
    }
}
>>>>>>> Stashed changes
*/