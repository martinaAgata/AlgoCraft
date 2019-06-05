package test;

import org.junit.Test;

public class PicoFinoTests {
    @Test
    public void test01CrearPicoFinoConDurabilidad() {
        Pico picoFino = new PicoFino();
        assertEquals(1000, pico.getDurabilidad());
    }
    @Test
    public void test02CrearPicoFinoConFuerza() {
        Pico picoFino = new PicoFino();
        assertEquals(20, pico.getFuerza());
    }
}
