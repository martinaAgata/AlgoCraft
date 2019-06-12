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

public class PicoMetalTests {

    private final int DURABILIDAD_PICO_METAL = 400;
    private final int FUERZA_PICO_METAL = 12;
    public void test01CrearPicoDeMetalConDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
        assertThat(picoMetal.getDurabilidad(), is(DURABILIDAD_PICO_METAL));
    }
    @Test
    public void test01CrearPicoDeMetalConFuerza() {
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
        assertThat(picoMetal.getFuerza(), is(FUERZA_PICO_METAL));
    }
    @Test
    public void test02PicoDeMetalSeUsaContraMaderaReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
        Madera madera = new Madera();
        picoMetal.usar(madera);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void test03PicoDeMetalSeUsaContraPiedraReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
        Piedra piedra = new Piedra();
        picoMetal.usar(piedra);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void test04PicoDeMetalSeUsaContraMetalReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
        Metal metal = new Metal();
        picoMetal.usar(metal);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
}
