package test;

import org.junit.Test;

public class PicoDeMetalTests {
    public void test01CrearPicoDeMetalConDurabilidad() {
        Pico picoMetal = Pico nuevoPicoDeMetal();
        assertEquals(400, pico.getDurabilidad());
    }
    @Test
    public void test01CrearPicoDeMetalConFuerza() {
        Pico picoMetal = Pico nuevoPicoDeMetal();
        assertEquals(12, pico.getFuerza());
    }
    @Test
    public void test02PicoDeMetalSeUsaContraMaderaReduceSuDurabilidad() {
        Pico picoMetal = Pico nuevoPicoDeMetal();
        Material madera = Material nuevaMadera();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(madera);
        assertEquals(durabilidadPicoMetal, pico.getDurabilidad());
    }
    @Test
    public void test03PicoDeMetalSeUsaContraPiedraReduceSuDurabilidad() {
        Pico picoMetal = Pico nuevoPicoDeMetal();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(piedra);
        assertEquals(durabilidadPicoMetal, pico.getDurabilidad());
    }
    @Test
    public void test04PicoDeMetalSeUsaContraMetalReduceSuDurabilidad() {
        Pico picoMetal = Pico nuevoPicoDeMetal();
        Material metal = Material nuevoMetal();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(metal);
        assertEquals(durabilidadPicoMetal, picoMetal.getDurabilidad());
    }
}
