package main;

import main.herramientas.ConstructorHacha;
import main.herramientas.Hacha;
import main.herramientas.ConstructorHacha;
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
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construirHachaMetal();
=======
        Hacha hachaMetal = ConstructorHacha.construirHachaMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Madera madera = new Madera();
        hachaMetal.usar(madera);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void test13HachaMetalSeUsaContraPiedraReduceSuDurabilidad(){
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construirHachaMetal();
=======
        Hacha hachaMetal = ConstructorHacha.construirHachaMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Piedra piedra = new Piedra();
        hachaMetal.usar(piedra);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void test14HachaMetalSeUsaContraMetalReduceSuDurabilidad(){
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construirHachaMetal();
=======
        Hacha hachaMetal = ConstructorHacha.construirHachaMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Metal metal = new Metal();
        hachaMetal.usar(metal);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }

    @Test
    public void test15HachaMetalSeUsaContraDiamanteReduceSuDurabilidad(){
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construirHachaMetal();
=======
        Hacha hachaMetal = ConstructorHacha.construirHachaMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Diamante diamante = new Diamante();
        hachaMetal.usar(diamante);
        assertThat(hachaMetal.getDurabilidad(), is(395));
    }


}
