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
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
        assertThat(picoFino.getDurabilidad(), is(1000));
    }
    @Test
    public void test02CrearPicoFinoConFuerza() {
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
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
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
        Madera madera = new Madera();
        picoFino.usar(madera);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }

    @Test
    public void test05PicoFinoSeUsaContraMetalYNoReduceSuDurabilidad(){
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
        Metal metal = new Metal();
        picoFino.usar(metal);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }

    @Test
    public void test06PicoFinoSeUsaContraPiedraYNoReduceSuDurabilidad(){
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
        Piedra piedra = new Piedra();
        picoFino.usar(piedra);
        assertThat(picoFino.getDurabilidad(), is(DURABILIDAD_PICO_FINO - ((int)(FUERZA_PICO_FINO*0.1))));
    }
}
