package test;

import main.herramientas.PicoMetal;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
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
        Madera madera = new Madera();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(madera);
        assertEquals(durabilidadPicoMetal, picoMetal.getDurabilidad());
    }
    @Test
    public void test03PicoDeMetalSeUsaContraPiedraReduceSuDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();
        Piedra piedra = new Piedra();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(piedra);
        assertEquals(durabilidadPicoMetal, picoMetal.getDurabilidad());
    }
    @Test
    public void test04PicoDeMetalSeUsaContraMetalReduceSuDurabilidad() {
        PicoMetal picoMetal = new PicoMetal();
        Metal metal = new Metal();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(metal);
        assertEquals(durabilidadPicoMetal, picoMetal.getDurabilidad());
    }
}
