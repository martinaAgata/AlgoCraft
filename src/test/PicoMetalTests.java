package test;

import org.junit.Test;

public class PicoMetalTests {
    public void test01CrearPicoDeMetalConDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();
        assertEquals(400, picoMetal.getDurabilidad());
    }
    @Test
    public void test01CrearPicoDeMetalConFuerza() {
        PicoMetal picoMetal = new PicoMetal();
        assertEquals(12, picoMetal.getFuerza());
    }
    @Test
    public void test02PicoDeMetalSeUsaContraMaderaReduceSuDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();
        Material madera = Material nuevaMadera();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(madera);
        assertEquals(durabilidadPicoMetal, picoMetal.getDurabilidad());
    }
    @Test
    public void test03PicoDeMetalSeUsaContraPiedraReduceSuDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(piedra);
        assertEquals(durabilidadPicoMetal, picoMetal.getDurabilidad());
    }
    @Test
    public void test04PicoDeMetalSeUsaContraMetalReduceSuDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();
        Material metal = Material nuevoMetal();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(metal);
        assertEquals(durabilidadPicoMetal, picoMetal.getDurabilidad());
    }
}
