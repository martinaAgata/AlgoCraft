package test;

import main.estrategias.DesgasteLinealMitad;
import main.estrategias.EstrategiaDesgaste;
import main.herramientas.HachaMetal;
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
        HachaMetal hachaMetal = new HachaMetal();
        Madera madera = new Madera();
        hachaMetal.usar(madera);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void test13HachaMetalSeUsaContraPiedraReduceSuDurabilidad(){
        HachaMetal hachaMetal = new HachaMetal();
        Piedra piedra = new Piedra();
        hachaMetal.usar(piedra);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void test14HachaMetalSeUsaContraMetalReduceSuDurabilidad(){
        HachaMetal hachaMetal = new HachaMetal();
        Metal metal = new Metal();
        hachaMetal.usar(metal);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void test15HachaMetalSeUsaContraDiamanteReduceSuDurabilidad(){
        HachaMetal hachaMetal = new HachaMetal();
        Diamante diamante = new Diamante();
        hachaMetal.usar(diamante);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }


}
