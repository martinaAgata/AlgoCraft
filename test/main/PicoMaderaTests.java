package main;

import main.estrategias.DesgasteLineal;
import main.herramientas.PicoMadera;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoMaderaTests {
    @Test
    public void test01CrearPicoDeMaderaConDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        assertThat(picoMadera.getDurabilidad(), is(100));
    }

    @Test
    public void test02CrearPicoDeMaderaConFuerza() {
        PicoMadera picoMadera = new PicoMadera();
        assertThat(picoMadera.getFuerza() , is(2));
    }

    @Test
    public void test03PicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        Madera madera = new Madera();
        picoMadera.usar(madera);
        assertThat(picoMadera.getDurabilidad(), is (98));
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        Piedra piedra = new Piedra();
        picoMadera.usar(piedra);
        assertThat(picoMadera.getDurabilidad(), is (98));


    }
    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        Metal metal = new Metal();
        picoMadera.usar(metal);
        assertThat(picoMadera.getDurabilidad(), is (98));

    }
}
