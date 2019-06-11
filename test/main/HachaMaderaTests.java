package main;

import main.herramientas.Hacha;
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
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
        Madera madera = new Madera();
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test05HachaMaderaSeUsaContraPiedraReduceSuDurabilidad(){
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
        Piedra piedra = new Piedra();
        hachaMadera.usar(piedra);

        assertThat(hachaMadera.getDurabilidad(), is(98));
   }

    @Test
    public void test06HachaMaderaSeUsaContraMetalReduceSuDurabilidad(){
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
        Metal metal = new Metal();
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test04HachaMaderaSeUsaContraDiamanteReduceSuDurabilidad() {
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
        Diamante diamante = new Diamante();
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test05HachaMaderaSeUsaContraMaderaReduceSuDurabilidadDeADos(){
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
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
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
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
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
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
        Hacha hachaMadera = Hacha.nuevaHachaMadera();
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