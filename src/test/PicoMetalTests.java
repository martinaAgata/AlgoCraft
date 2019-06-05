package test;

import main.estrategias.DesgasteAbrupto;
import main.herramientas.PicoMetal;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoMetalTests {
    public void test01CrearPicoDeMetalConDurabilidad() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto();
        PicoMetal picoMetal = new PicoMetal(400, 12, desgaste);
        assertThat(picoMetal.getFuerza(), is(4));
    }
    @Test
    public void test01CrearPicoDeMetalConFuerza() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto();
        PicoMetal picoMetal = new PicoMetal(400, 12, desgaste);
        assertThat(picoMetal.getFuerza(), is(12));
    }
    @Test
    public void test02PicoDeMetalSeUsaContraMaderaReduceSuDurabilidad() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto();
        PicoMetal picoMetal = new PicoMetal(400, 12, desgaste);
        Madera madera = new Madera();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(madera);
    }
    @Test
    public void test03PicoDeMetalSeUsaContraPiedraReduceSuDurabilidad() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto();
        PicoMetal picoMetal = new PicoMetal(400, 12, desgaste);
        Piedra piedra = new Piedra();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(piedra);;
    }
    @Test
    public void test04PicoDeMetalSeUsaContraMetalReduceSuDurabilidad() {
        DesgasteAbrupto desgaste = new DesgasteAbrupto();
        PicoMetal picoMetal = new PicoMetal(400, 12, desgaste);
        Metal metal = new Metal();
        Integer durabilidadPicoMetal = picoMetal.getDurabilidad();
        picoMetal.usar(metal);
    }
}
