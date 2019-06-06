package test;

import main.estrategias.DesgasteAbrupto;
import main.herramientas.PicoMadera;
import main.herramientas.PicoMetal;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoMetalTests {
    public void test01CrearPicoDeMetalConDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();
        assertThat(picoMetal.getDurabilidad(), is(400));
    }
    @Test
    public void test01CrearPicoDeMetalConFuerza() {
        PicoMetal picoMetal = new PicoMetal();
        assertThat(picoMetal.getFuerza(), is(12));
    }
    @Test
    public void test02PicoDeMetalSeUsaContraMaderaReduceSuDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();
        Madera madera = new Madera();
        picoMetal.usar(madera);
        assertThat(picoMetal.getDurabilidad(), is (390));
    }
    @Test
    public void test03PicoDeMetalSeUsaContraPiedraReduceSuDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();
        Piedra piedra = new Piedra();
        picoMetal.usar(piedra);
        assertThat(picoMetal.getDurabilidad(), is (390));
    }
    @Test
    public void test04PicoDeMetalSeUsaContraMetalReduceSuDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();
        Metal metal = new Metal();
        picoMetal.usar(metal);
        assertThat(picoMetal.getDurabilidad(), is (390));
    }
}
