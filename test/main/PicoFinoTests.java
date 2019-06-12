package main;

import main.herramientas.ConstructorPicoFino;
import main.herramientas.PicoFino;
import main.herramientas.ConstructorPicoFino;
import main.materiales.Diamante;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PicoFinoTests {

    private final int DURABILIDAD_PICO_FINO = 1000;
    private final int FUERZA_PICO_FINO = 20;

    @Test
    public void test01CrearPicoFinoConDurabilidad() {
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        assertThat(picoFino.getDurabilidad(), is(1000));
    }
    @Test
    public void test02CrearPicoFinoConFuerza() {
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        assertThat(picoFino.getFuerza(), is(20));
    }
    @Test
    public void test03PicoFinoSeUsaContraDiamanteYSeReduceSuDurabilidad(){
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
        Diamante diamante = new Diamante();
        picoFino.usar(diamante);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }

    @Test
    public void test04PicoFinoSeUsaContraMaderaYNoReduceSuDurabilidad(){
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Madera madera = new Madera();
        picoFino.usar(madera);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }

    @Test
    public void test05PicoFinoSeUsaContraMetalYNoReduceSuDurabilidad(){
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Metal metal = new Metal();
        picoFino.usar(metal);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }

    @Test
    public void test06PicoFinoSeUsaContraPiedraYNoReduceSuDurabilidad(){
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Piedra piedra = new Piedra();
        picoFino.usar(piedra);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }
}
