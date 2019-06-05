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

    @Test
    public void test05SeUsaContraMaderaReduceSuDurabilidadDeManeraCorrecta(){
        HachaPiedra hachaPiedra = new HachaPiedra();
        Madera madera = new Madera();
        Integer durabilidadHachaPiedra = HachaPiedra.getDurabilidad();
        HachaPiedra.usar(madera);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - (4/1.5)));
        HachaPiedra.usar(madera);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - 2*(4/1.5)));
        HachaPiedra.usar(madera);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - 3*(4/1.5)));
    }

    @Test
    public void test06HachaPiedraSeUsaContraPiedraReduceSuDurabilidadDeManeraCorrecta(){
        HachaPiedra hachaPiedra = new HachaPiedra();
        Piedra piedra = new Piedra();
        Integer durabilidadHachaPiedra = hachaPiedra.getDurabilidad();
        hachaPiedra.usar(piedra);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - (4/1.5)));
        hachaPiedra.usar(piedra);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - 2*(4/1.5)));
        hachaPiedra.usar(piedra);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - 3*(4/1.5)));
    }

    @Test
    public void test07HachaPiedraSeUsaContraMetalReduceSuDurabilidadDeManeraCorrecta(){
        HachaPiedra hachaPiedra = new HachaPiedra();
        Metal metal = new Metal();
        Integer durabilidadHachaPiedra = hachaPiedra.getDurabilidad();
        hachaPiedra.usar(metal);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - (4/1.5)));
        hachaPiedra.usar(metal);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - 2*(4/1.5)));
        hachaPiedra.usar(metal);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - 3*(4/1.5)));
    }

    @Test
    public void test08HachaPiedraSeUsaContraDiamanteReduceSuDurabilidadDeManeraCorrecta(){
        HachaPiedra hachaPiedra = new HachaPiedra();
        Diamante diamante = new Diamante();
        Integer durabilidadHachaPiedra = hachaPiedra.getDurabilidad();
        hachaPiedra.usar(diamante);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - (4/1.5)));
        hachaPiedra.usar(diamante);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - 2*(4/1.5)));
        hachaPiedra.usar(diamante);
        assertThat(hachaPiedra.getDurabilidad(), is(durabilidadHachaPiedra - 3*(4/1.5)));
    }
}
