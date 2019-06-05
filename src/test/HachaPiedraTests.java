package test;

import main.estrategias.DesgasteLineal;
import main.herramientas.HachaPiedra;
import main.materiales.Diamante;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HachaPiedraTests {

    @Test
    public void test08HachaPiedraSeUsaContraMaderaReduceSuDurabilidad() {
        HachaPiedra hachaPiedra = new HachaPiedra();
        Madera madera = new Madera();
        hachaPiedra.usar(madera);
        assertThat(hachaPiedra.getDurabilidad(), is(195));
    }

    @Test
    public void test09HachaPiedraSeUsaContraPiedraReduceSuDurabilidad() {
        HachaPiedra hachaPiedra = new HachaPiedra();
        Piedra piedra = new Piedra();
        hachaPiedra.usar(piedra);
        assertThat(hachaPiedra.getDurabilidad(), is(195));
    }

    @Test
    public void test10HachaPiedraSeUsaContraMetalReduceSuDurabilidad() {
        HachaPiedra hachaPiedra = new HachaPiedra();
        Metal metal = new Metal();
        hachaPiedra.usar(metal);
        assertThat(hachaPiedra.getDurabilidad(), is(195));
    }

    @Test
    public void test11HachaPiedraSeUsaContraDiamanteReduceSuDurabilidad() {
        HachaPiedra hachaPiedra = new HachaPiedra();
        Diamante diamante = new Diamante();
        hachaPiedra.usar(diamante);
        assertThat(hachaPiedra.getDurabilidad(), is(195));
    }
}
