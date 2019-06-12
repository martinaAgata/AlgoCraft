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
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        assertThat(picoMetal.getDurabilidad(), is(DURABILIDAD_PICO_METAL));
    }
    @Test
    public void test01CrearPicoDeMetalConFuerza() {
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        assertThat(picoMetal.getFuerza(), is(FUERZA_PICO_METAL));
    }
    @Test
    public void test02PicoDeMetalSeUsaContraMaderaReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Madera madera = new Madera();
        picoMetal.usar(madera);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void test03PicoDeMetalSeUsaContraPiedraReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Piedra piedra = new Piedra();
        picoMetal.usar(piedra);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
    @Test
    public void test04PicoDeMetalSeUsaContraMetalReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMetal = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Metal metal = new Metal();
        picoMetal.usar(metal);
        assertThat(picoMetal.getDurabilidad(), is (DURABILIDAD_PICO_METAL));
    }
}
