package test;

import main.herramientas.PicoPiedra;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
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
        assertEquals(4, picoPiedra.getFuerza());
    }
    @Test
    public void test03PicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra();
        Madera madera = new Madera();
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(madera);
        assertEquals(4/1.5, picoPiedra.getDurabilidad());
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra();
        Piedra piedra = new Piedra();
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(piedra);
        assertEquals(4/1.5, picoPiedra.getDurabilidad());
    }

    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra();
        Metal metal = new Metal();
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(metal);
        assertEquals(4/1.5, picoPiedra.getDurabilidad());
    }
}
