package test;

import org.junit.Test;

import static junit.framework.TestCase.fail;

public class PicoMaderaTests {
    @Test
    public void test01CrearPicoDeMaderaConDurabilidad() {
        Pico picoMadera = Pico nuevoPicoDeMadera();
        assertEquals(100, pico.getDurabilidad());
    }
    @Test
    public void test02CrearPicoDeMaderaConFuerza() {
        Pico picoMadera = Pico nuevoPicoDeMadera();
        assertEquals(2, pico.getFuerza());
    }
    @Test
    public void test03PicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        Pico picoMadera = Pico nuevoPicoDeMadera();
        Material madera = Material nuevaMadera();
        Integer durabilidadPicoMadera = picoMadera.getDurabilidad();
        picoMadera.usar(madera);
        assertEquals(durabilidadPicoMadera - 2, pico.getDurabilidad());
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        Pico picoMadera = Pico nuevoPicoDeMadera();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadPicoMadera = picoMadera.getDurabilidad();
        picoMadera.usar(piedra);
        assertEquals(durabilidadPicoMadera - 2, pico.getDurabilidad());
    }
    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        Pico picoMadera = Pico nuevoPicoDeMadera();
        Material metal = Material nuevoMetal();
        Integer durabilidadPicoMadera = picoMadera.getDurabilidad();
        picoMadera.usar(metal);
        assertEquals(durabilidadPicoMadera - 2, picoMadera.getDurabilidad());
    }
}
