package test;

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
        Material madera = Material nuevaMadera();
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(madera);
        assertEquals(4/1.5, picoPiedra.getDurabilidad());
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(piedra);
        assertEquals(4/1.5, picoPiedra.getDurabilidad());
    }

    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra();
        Material metal = Material nuevoMetal();
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(metal);
        assertEquals(4/1.5, picoPiedra.getDurabilidad());
    }
}
