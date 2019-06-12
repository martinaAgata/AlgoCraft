package main;

import main.herramientas.Pico;
import main.herramientas.ConstructorPico;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoPiedraTests {

    private final int DURABILIDAD_PICO_PIEDRA = 200;
    private final int FUERZA_PICO_PIEDRA = 4;
    @Test
    public void test01CrearPicoDePiedraConDurabilidad() {
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
        assertThat(picoPiedra.getDurabilidad(), is(DURABILIDAD_PICO_PIEDRA));
    }
    @Test
    public void test02CrearPicoDePiedraConFuerza() {
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
        assertThat(picoPiedra.getFuerza(), is(FUERZA_PICO_PIEDRA));
    }
    @Test
    public void test03PicoDePiedraSeUsaContraMaderaReduceSuDurabilidad() {
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
        Madera madera = new Madera();
        picoPiedra.usar(madera);
        assertThat(picoPiedra.getDurabilidad(), is(DURABILIDAD_PICO_PIEDRA - ((int)(FUERZA_PICO_PIEDRA/1.5))));

    }
    @Test
    public void test04PicoDePiedraSeUsaContraPiedraReduceSuDurabilidad() {
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
        Piedra piedra = new Piedra();
        picoPiedra.usar(piedra);
        assertThat(picoPiedra.getDurabilidad(), is(DURABILIDAD_PICO_PIEDRA - ((int)(FUERZA_PICO_PIEDRA/1.5))));

    }

    @Test
    public void test05PicoDePiedraSeUsaContraMetalReduceSuDurabilidad() {
        Pico picoPiedra = ConstructorPico.construirPicoPiedra();
        Metal metal = new Metal();
        picoPiedra.usar(metal);
        assertThat(picoPiedra.getDurabilidad(), is(DURABILIDAD_PICO_PIEDRA - ((int)(FUERZA_PICO_PIEDRA/1.5))));

    }
}
