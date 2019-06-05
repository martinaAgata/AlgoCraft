package test;

import main.estrategias.DesgasteLineal;
import main.herramientas.HachaPiedra;
import main.materiales.Madera;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HachaPiedraTests {

    @Test
    public void test08HachaPiedraSeUsaContraMaderaReduceSuDurabilidad() {
        DesgasteLineal desgasteLineal = new DesgasteLineal();
        HachaPiedra hachaPiedra = new HachaPiedra(200, 5, desgasteLineal );
        Madera madera = new Madera();
        hachaPiedra.usar(madera);
        assertThat(hachaPiedra.getDurabilidad(), is(195));
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
