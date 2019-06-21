package modelo.detectorPatrones;

import modelo.herramientas.*;
import modelo.mapa.Mapa;
import modelo.mapa.Ubicacion;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import modelo.patrones.DetectorPatron;
import modelo.patrones.DetectorPatronPicoFino;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class DetectorPatronPicoFinoTest {

    //    1        2       3
    //  Metal | Metal  | Metal   1
    // Piedra | Madera |         2
    //        | Madera |         3

        @Test
        public void testSeCreaUnPicoFinoYSeReconocePatron() {
            Madera madera = new Madera();
            Mapa tableroPicoFino = new Mapa(3, 3);
            tableroPicoFino.ubicarEnCasillero((new Metal()),(new Ubicacion(1,1)));
            tableroPicoFino.ubicarEnCasillero((new Metal()),(new Ubicacion(2,1)));
            tableroPicoFino.ubicarEnCasillero((new Metal()),(new Ubicacion(3,1)));
            tableroPicoFino.ubicarEnCasillero(new Piedra(), new Ubicacion(1,2));
            tableroPicoFino.ubicarEnCasillero((new Madera()),(new Ubicacion(2,2)));
            tableroPicoFino.ubicarEnCasillero((new Madera()),(new Ubicacion(2,3)));
            DetectorPatron dp = new DetectorPatronPicoFino(new Metal(), () -> new ConstructorPicoFino().construir());
            Optional<Herramienta> resultado = dp.resolverPatron(tableroPicoFino);
            assertThat(resultado.get(), instanceOf(PicoFino.class));
        }
}
