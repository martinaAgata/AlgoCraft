package test;

import main.estrategias.DesgasteLinealFactor;
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
        DesgasteLinealFactor desgaste = new DesgasteLinealFactor();
        PicoPiedra picoPiedra = new PicoPiedra(200, 4, desgaste);
        assertThat(picoPiedra.getDurabilidad(), is(200));
    }
    @Test
    public void test02CrearPicoDePiedraConFuerza() {
        DesgasteLinealFactor desgaste = new DesgasteLinealFactor();
        PicoPiedra picoPiedra = new PicoPiedra(200,4, desgaste);
        assertThat(picoPiedra.getFuerza(), is(4));
    }
    @Test
    public void test03PicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra(200,4);
        Madera madera = new Madera(10);
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(madera);
        assertEquals(4/1.5, picoPiedra.getDurabilidad());
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra(200,4);
        Piedra piedra = new Piedra(30);
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(piedra);
        assertEquals(4/1.5, picoPiedra.getDurabilidad());
    }

    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        PicoPiedra picoPiedra = new PicoPiedra(200,4);
        Metal metal = new Metal(50);
        Integer durabilidadPicoPiedra = picoPiedra.getDurabilidad();
        picoPiedra.usar(metal);
        assertEquals(4/1.5, picoPiedra.getDurabilidad());
    }
}
