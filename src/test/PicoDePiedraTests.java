package test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PicoDePiedraTests {

    @Test
    public void test01CrearPicoDePiedraConDurabilidad() {
        Pico picoPiedra = Pico nuevoPicoDePiedra();
        assertThat(pico.getDurabilidad(), is(200));
    }
    @Test
    public void test02CrearPicoDePiedraConFuerza() {
        Pico picoPiedra = Pico nuevoPicoDePiedra();
        assertEquals(4, pico.getFuerza());
    }
    @Test
    public void test03PicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        Pico picoPiedra = Pico nuevoPicoDePiedra();
        Material madera = Material nuevaMadera();
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(madera);
        assertEquals(4/1.5, pico.getDurabilidad());
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        Pico picoPiedra = Pico nuevoPicoDePiedra();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(piedra);
        assertEquals(4/1.5, pico.getDurabilidad());
    }

    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        Pico picoPiedra = Pico nuevoPicoDeMadera();
        Material metal = Material nuevoMetal();
        Integer durabilidadPicoMadera = picoMadera.getDurabilidad();
        picoMadera.usar(metal);
        assertEquals(4/1.5, picoMadera.getDurabilidad());
    }
}
