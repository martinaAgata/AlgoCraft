package test;

import main.estrategias.DesgasteLineal;
import main.estrategias.DesgasteLinealFactor;
import main.herramientas.PicoMadera;
import main.herramientas.PicoPiedra;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoPiedraTests {

    @Test
    public void test01CrearPicoDePiedraConDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra();
        assertThat(picoPiedra.getDurabilidad(), is(200));
    }
    @Test
    public void test02CrearPicoDePiedraConFuerza() {
        PicoPiedra picoPiedra = new PicoPiedra();
        assertThat(picoPiedra.getFuerza(), is(4));
    }
    @Test
    public void test03PicoDePiedraSeUsaContraMaderaReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra();
        Madera madera = new Madera();
        picoPiedra.usar(madera);
        assertThat(picoPiedra.getDurabilidad(), is(picoPiedra.DURABILIDAD_PICO_PIEDRA - ((int)(picoPiedra.getFuerza()/1.5))));

    }
    @Test
    public void test04PicoDePiedraSeUsaContraPiedraReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra();
        Piedra piedra = new Piedra();
        picoPiedra.usar(piedra);
        assertThat(picoPiedra.getDurabilidad(), is(picoPiedra.DURABILIDAD_PICO_PIEDRA - ((int)(picoPiedra.getFuerza()/1.5))));

    }

    @Test
    public void test05PicoDePiedraSeUsaContraMetalReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra();
        Metal metal = new Metal();
        picoPiedra.usar(metal);
        assertThat(picoPiedra.getDurabilidad(), is(picoPiedra.DURABILIDAD_PICO_PIEDRA - ((int)(picoPiedra.getFuerza()/1.5))));

    }
}
