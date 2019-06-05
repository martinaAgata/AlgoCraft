package test;

import main.herramientas.PicoMadera;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class PicoMaderaTests {
    @Test
    public void test01CrearPicoDeMaderaConDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        assertEquals(100, picoMadera.getDurabilidad());
    }
    @Test
    public void test02CrearPicoDeMaderaConFuerza() {
        PicoMadera picoMadera = new PicoMadera();
        assertEquals(2, picoMadera.getFuerza());
    }
    @Test
    public void test03PicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        Madera madera = new Madera();
        Integer durabilidadPicoMadera = picoMadera.getDurabilidad();
        picoMadera.usar(madera);
        assertEquals(durabilidadPicoMadera - 2, picoMadera.getDurabilidad());
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        Piedra piedra = new Piedra();
        Integer durabilidadPicoMadera = picoMadera.getDurabilidad();
        picoMadera.usar(piedra);
        assertEquals(durabilidadPicoMadera - 2, picoMadera.getDurabilidad());
    }
    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        Metal metal = new Metal();
        Integer durabilidadPicoMadera = picoMadera.getDurabilidad();
        picoMadera.usar(metal);
        assertEquals(durabilidadPicoMadera - 2, picoMadera.getDurabilidad());
    }
}
