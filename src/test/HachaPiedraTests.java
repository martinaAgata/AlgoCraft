package test;

import org.junit.Test;

public class HachaPiedraTests {

    @Test
    public void test08HachaPiedraSeUsaContraMaderaReduceSuDurabilidad() {
        HachaPiedra hachaPiedra = new HachaPiedra();
        Material madera = Material nuevaMadera();
        Integer durabilidadHachaPiedra = hachaPiedra.getDurabilidad();
        hachaPiedra.usar(madera);
        assertEquals(durabilidadHachaPiedra - 5, hachaPiedra.getDurabilidad());
    }

    @Test
    public void test09HachaPiedraSeUsaContraPiedraReduceSuDurabilidad() {
        HachaPiedra hachaPiedra = new HachaPiedra();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadHachaPiedra = hachaPiedra.getDurabilidad();
        hachaPiedra.usar(piedra);
        assertEquals(durabilidadHachaPiedra - 5, hachaPiedra.getDurabilidad());

    }

    @Test
    public void test10HachaPiedraSeUsaContraMetalReduceSuDurabilidad() {
        HachaPiedra hachaPiedra = new HachaPiedra();
        Material metal = Material nuevoMetal();
        Integer durabilidadHachaPiedra = hachaPiedra.getDurabilidad();
        hachaPiedra.usar(metal);
        assertEquals(durabilidadHachaPiedra - 5, hachaPiedra.getDurabilidad());
    }

    @Tests
    public void test11HachaPiedraSeUsaContraDiamanteReduceSuDurabilidad() {
        HachaPiedra hachaPiedra = new HachaPiedra();
        Material diamante = Material nuevoDiamante();
        Integer durabilidadHachaPiedra = hachaPiedra.getDurabilidad();
        hachaPiedra.usar(diamante);
        assertEquals(durabilidadHachaPiedra - 5, hachaPiedra.getDurabilidad());
    }
}
