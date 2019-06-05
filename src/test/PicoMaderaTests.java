package test;

import main.estrategias.DesgasteLineal;
import main.herramientas.PicoMadera;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoMaderaTests {
    @Test
    public void test01CrearPicoDeMaderaConDurabilidad() {
        DesgasteLineal desgaste = new DesgasteLineal();
        PicoMadera picoMadera = new PicoMadera(100,2, desgaste);
        assertThat(picoMadera.getDurabilidad(), is(100));
    }
    @Test
    public void test02CrearPicoDeMaderaConFuerza() {
        PicoMadera picoMadera = new PicoMadera();
    }
    @Test
    public void test03PicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        Madera madera = new Madera();
        Integer durabilidadPicoMadera = picoMadera.getDurabilidad();
        picoMadera.usar(madera);
    }
    @Test
    public void test04PicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        Piedra piedra = new Piedra();
        Integer durabilidadPicoMadera = picoMadera.getDurabilidad();
        picoMadera.usar(piedra);
    }
    @Test
    public void test05PicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        PicoMadera picoMadera = new PicoMadera();
        Metal metal = new Metal();
        Integer durabilidadPicoMadera = picoMadera.getDurabilidad();
        picoMadera.usar(metal);
    }
}
