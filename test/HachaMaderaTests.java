package test;

import main.estrategias.DesgasteLineal;
import main.herramientas.HachaMadera;
import main.materiales.Diamante;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class HachaMaderaTests {

    @Test
    public void test01HachaMaderaSeUsaContraMaderaReduceSuDurabilidad(){
        HachaMadera hachaMadera = new HachaMadera();
        Madera madera = new Madera();
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test05HachaMaderaSeUsaContraPiedraReduceSuDurabilidad(){
        HachaMadera hachaMadera = new HachaMadera();
        Piedra piedra = new Piedra();
        hachaMadera.usar(piedra);

        assertThat(hachaMadera.getDurabilidad(), is(98));
   }

    @Test
    public void test06HachaMaderaSeUsaContraMetalReduceSuDurabilidad(){
        HachaMadera hachaMadera = new HachaMadera();
        Metal metal = new Metal();
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test04HachaMaderaSeUsaContraDiamanteReduceSuDurabilidad() {
        HachaMadera hachaMadera = new HachaMadera();
        Diamante diamante = new Diamante();
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test05HachaMaderaSeUsaContraMaderaReduceSuDurabilidadDeADos(){
        HachaMadera hachaMadera = new HachaMadera();
        Madera madera = new Madera();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 2));
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 4));
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 6));
    }

    @Test
    public void test06HachaMaderaSeUsaContraPiedraReduceSuDurabilidadDeADos(){
        HachaMadera hachaMadera = new HachaMadera();
        Piedra piedra = new Piedra();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(piedra);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 2));
        hachaMadera.usar(piedra);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 4));
        hachaMadera.usar(piedra);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 6));
    }

    @Test
    public void test07HachaMaderaSeUsaContraMetalReduceSuDurabilidadDeADos(){
        HachaMadera hachaMadera = new HachaMadera();
        Metal metal = new Metal();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 2));
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 4));
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 6));
    }

    @Test
    public void test08HachaMaderaSeUsaContraDiamanteReduceSuDurabilidadDeADos(){
        HachaMadera hachaMadera = new HachaMadera();
        Diamante diamante = new Diamante();
        Integer durabilidadHachaMadera = hachaMadera.getDurabilidad();
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 2));
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 4));
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(durabilidadHachaMadera - 6));
    }
}