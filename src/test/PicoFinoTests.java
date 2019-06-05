package test;

import main.estrategias.DesgasteLinealDecimal;
import main.herramientas.PicoFino;
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
}
