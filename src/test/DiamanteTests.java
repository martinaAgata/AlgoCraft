package test;

import org.junit.Test;

public class DiamanteTests {
    @Test
    public void test01CrearDiamante() {
        Material diamante = Material nuevoDiamante();
        assertEquals(100, diamante.getDurabilidad());
    }
}
