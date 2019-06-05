package test;

import main.estrategias.DesgasteLineal;
import main.herramientas.HachaMadera;
import main.materiales.Madera;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class HachaMaderaTests {

    @Test
    public void test04HachaMaderaSeUsaContraMaderaReduceSuDurabilidad(){
        HachaMadera hachaMadera = new HachaMadera();
        Madera madera = new Madera();
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test05HachaMaderaSeUsaContraPiedraReduceSuDurabilidad(){
        HachaMadera hachaMadera = HachaMadera nuevaHachaMadera();
        Material piedra = Material nuevaPiedra();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(piedra);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());
    }

    @Test
    public void test06HachaMaderaSeUsaContraMetalReduceSuDurabilidad(){
        HachaMadera hachaMadera = HachaMadera nuevaHachaMadera();
        Material metal = Material nuevoMetal();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(metal);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());
    }

    @Test
    public void test07HachaMaderaSeUsaContraDiamanteReduceSuDurabilidad() {
        HachaMadera hachaMadera = HachaMadera nuevaHachaMadera();
        Material diamante = Material nuevoDiamante();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(diamante);
        assertEquals(durabilidadHachaMadera - 2, hachaMadera.getDurabilidad());
    }
}

