package main;

import main.herramientas.Pico;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoMetalTests {

    private final int DURABILIDAD_PICO_METAL = 400;
    private final int FUERZA_PICO_METAL = 12;
    public void test01CrearPicoDeMetalConDurabilidad() {
        Pico picoMetal = Pico.nuevoPicoMetal();
        assertThat(picoMetal.getDurabilidad(), is(DURABILIDAD_PICO_METAL));
    }
    @Test
    public void test01CrearPicoDeMetalConFuerza() {
        Pico picoMetal = Pico.nuevoPicoMetal();
        assertThat(picoMetal.getFuerza(), is(FUERZA_PICO_METAL));
    }
    @Test
    public void test02PicoDeMetalSeUsaContraMaderaReduceSuDurabilidad() {
        Pico picoMetal = Pico.nuevoPicoMetal();
        Madera madera = new Madera();
        picoMetal.usar(madera);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void test03PicoDeMetalSeUsaContraPiedraReduceSuDurabilidad() {
        Pico picoMetal = Pico.nuevoPicoMetal();
        Piedra piedra = new Piedra();
        picoMetal.usar(piedra);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void test04PicoDeMetalSeUsaContraMetalReduceSuDurabilidad() {
        Pico picoMetal = Pico.nuevoPicoMetal();
        Metal metal = new Metal();
        picoMetal.usar(metal);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
}
