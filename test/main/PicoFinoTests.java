package main;

import main.herramientas.PicoFino;
import main.materiales.Diamante;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PicoFinoTests {
    @Test
    public void test01CrearPicoFinoConDurabilidad() {
        PicoFino picoFino = new PicoFino();
        assertThat(picoFino.getDurabilidad(), is(1000));
    }
    @Test
    public void test02CrearPicoFinoConFuerza() {
        PicoFino picoFino = new PicoFino();
        assertThat(picoFino.getFuerza(), is(20));
    }
    @Test
    public void test03PicoFinoSeUsaContraDiamanteYSeReduceSuDurabilidad(){
        PicoFino picoFino = new PicoFino();
        Diamante diamante = new Diamante();
        picoFino.usar(diamante);
        assertThat(picoFino.getDurabilidad(), is(picoFino.DURABILIDAD_PICO_FINO - ((int)(picoFino.getFuerza()*0.1))));
    }

    @Test
    public void test04PicoFinoSeUsaContraMaderaYNoReduceSuDurabilidad(){
        PicoFino picoFino = new PicoFino();
        Madera madera = new Madera();
        picoFino.usar(madera);
        assertThat(picoFino.getDurabilidad(), is(picoFino.DURABILIDAD_PICO_FINO - ((int)(picoFino.getFuerza()*0.1))));
    }

    @Test
    public void test05PicoFinoSeUsaContraMetalYNoReduceSuDurabilidad(){
        PicoFino picoFino = new PicoFino();
        Metal metal = new Metal();
        picoFino.usar(metal);
        assertThat(picoFino.getDurabilidad(), is(picoFino.DURABILIDAD_PICO_FINO - ((int)(picoFino.getFuerza()*0.1))));
    }

    @Test
    public void test06PicoFinoSeUsaContraPiedraYNoReduceSuDurabilidad(){
        PicoFino picoFino = new PicoFino();
        Piedra piedra = new Piedra();
        picoFino.usar(piedra);
        assertThat(picoFino.getDurabilidad(), is(picoFino.DURABILIDAD_PICO_FINO - ((int)(picoFino.getFuerza()*0.1))));
    }
}
