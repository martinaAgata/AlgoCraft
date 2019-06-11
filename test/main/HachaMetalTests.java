package main;

import main.herramientas.Hacha;
import main.materiales.Diamante;
import main.materiales.Madera;
import main.materiales.Metal;
import main.materiales.Piedra;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HachaMetalTests {

    @Test
    public void test12HachaMetalSeUsaContraMaderaReduceSuDurabilidad(){
        Hacha hachaMetal = Hacha.nuevaHachaMetal();
        Madera madera = new Madera();
        hachaMetal.usar(madera);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void test13HachaMetalSeUsaContraPiedraReduceSuDurabilidad(){
        Hacha hachaMetal = Hacha.nuevaHachaMetal();
        Piedra piedra = new Piedra();
        hachaMetal.usar(piedra);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void test14HachaMetalSeUsaContraMetalReduceSuDurabilidad(){
        Hacha hachaMetal = Hacha.nuevaHachaMetal();
        Metal metal = new Metal();
        hachaMetal.usar(metal);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void test15HachaMetalSeUsaContraDiamanteReduceSuDurabilidad(){
        Hacha hachaMetal = Hacha.nuevaHachaMetal();
        Diamante diamante = new Diamante();
        hachaMetal.usar(diamante);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }


}
