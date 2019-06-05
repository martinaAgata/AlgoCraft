package test;

import org.junit.Test;

public class PicoDeMetalTests {
    public void test01CrearPicoDeMetalConDurabilidad() {
        PicoMetal picoMetal = PicoMetal nuevoPicoDeMetal();
        assertEquals(400, picoMetal.getDurabilidad());
    }
    @Test
    public void test01CrearPicoDeMetalConFuerza() {
        PicoMetal picoMetal = PicoMetal nuevoPicoDeMetal();
        assertEquals(12, picoMetal.getFuerza());
    }
    @Test
    public void test02PicoDeMetalSeUsaContraMaderaReduceSuDurabilidad() {
        PicoMetal picoMetal = PicoMetal nuevoPicoDeMetal();
        Material madera = Material nuevaMadera();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(madera);
        assertEquals(durabilidadPicoMetal, picoMetal.getDurabilidad());
    }
    @Test
    public void test03PicoDeMetalSeUsaContraPiedraReduceSuDurabilidad() {
        PicoMetal picoMetal = PicoMetal nuevoPicoDeMetal();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(piedra);
        assertEquals(durabilidadPicoMetal, picoMetal.getDurabilidad());
    }
    @Test
    public void test04PicoDeMetalSeUsaContraMetalReduceSuDurabilidad() {
        PicoMetal picoMetal = PicoMetal nuevoPicoDeMetal();
        Material metal = Material nuevoMetal();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(metal);
        assertEquals(durabilidadPicoMetal, picoMetal.getDurabilidad());
    }
}
