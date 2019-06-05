package test;

import main.estrategias.DesgasteLinealDecimal;
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
        DesgasteLinealDecimal desgaste = new DesgasteLinealDecimal();
        PicoFino picoFino = new PicoFino(1000, 20, desgaste);
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
        Integer durabilidadPicoFino = picoFino.getDurabilidad();
        picoFino.usar(diamante);
        assertThat(picoFino.getDurabilidad(), is(durabilidadPicoFino -(1000 * 0.1)));
    }

    @Test
    public void test04PicoFinoSeUsaContraMaderaYNoReduceSuDurabilidad(){
        PicoFino picoFino = new PicoFino();
        Madera madera = new Madera();
        Integer durabilidadPicoFino = picoFino.getDurabilidad();
        picoFino.usar(madera);
        assertThat(picoFino.getDurabilidad(), is(durabilidadPicoFino));
    }

    @Test
    public void test05PicoFinoSeUsaContraMetalYNoReduceSuDurabilidad(){
        PicoFino picoFino = new PicoFino();
        Metal metal = new Metal();
        Integer durabilidadPicoFino = picoFino.getDurabilidad();
        picoFino.usar(metal);
        assertThat(picoFino.getDurabilidad(), is(durabilidadPicoFino));
    }

    @Test
    public void test06PicoFinoSeUsaContraPiedraYNoReduceSuDurabilidad(){
        PicoFino picoFino = new PicoFino();
        Piedra piedra = new Piedra();
        Integer durabilidadPicoFino = picoFino.getDurabilidad();
        picoFino.usar(piedra);
        assertThat(picoFino.getDurabilidad(), is(durabilidadPicoFino));
    }
}
