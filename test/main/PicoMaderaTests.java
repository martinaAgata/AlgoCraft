package main;

import main.herramientas.ConstructorPico;
import main.herramientas.Pico;
import main.herramientas.ConstructorPico;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoMaderaTests {
    @Test
    public void test01CrearPicoDeMaderaConDurabilidad() {
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        assertThat(picoMadera.getDurabilidad(), is(100));
    }

    @Test
    public void test02CrearPicoDeMaderaConFuerza() {
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        assertThat(picoMadera.getFuerza() , is(2));
    }

    @Test
    public void test03PicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Madera madera = new Madera();
        picoMadera.usar(madera);
        assertThat(picoMadera.getDurabilidad(), is (98));
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Piedra piedra = new Piedra();
        picoMadera.usar(piedra);
        assertThat(picoMadera.getDurabilidad(), is (98));


    }
    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Metal metal = new Metal();
        picoMadera.usar(metal);
        assertThat(picoMadera.getDurabilidad(), is (98));

    }
}
