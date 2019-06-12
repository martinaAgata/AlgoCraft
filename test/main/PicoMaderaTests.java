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
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
        assertThat(picoMadera.getDurabilidad(), is(100));
    }

    @Test
    public void test02CrearPicoDeMaderaConFuerza() {
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
        assertThat(picoMadera.getFuerza() , is(2));
    }

    @Test
    public void test03PicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
        Madera madera = new Madera();
        picoMadera.usar(madera);
        assertThat(picoMadera.getDurabilidad(), is (98));
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
        Piedra piedra = new Piedra();
        picoMadera.usar(piedra);
        assertThat(picoMadera.getDurabilidad(), is (98));


    }
    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
        Metal metal = new Metal();
        picoMadera.usar(metal);
        assertThat(picoMadera.getDurabilidad(), is (98));

    }
}
