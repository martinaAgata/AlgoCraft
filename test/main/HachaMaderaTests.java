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


public class HachaMaderaTests {

    @Test
    public void test01HachaMaderaSeUsaContraMaderaReduceSuDurabilidad(){
<<<<<<< HEAD

        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Madera madera = new Madera();
        hachaMadera.usar(madera);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test05HachaMaderaSeUsaContraPiedraReduceSuDurabilidad(){
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Piedra piedra = new Piedra();
        hachaMadera.usar(piedra);

        assertThat(hachaMadera.getDurabilidad(), is(98));
   }

    @Test
    public void test06HachaMaderaSeUsaContraMetalReduceSuDurabilidad(){
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Metal metal = new Metal();
        hachaMadera.usar(metal);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test04HachaMaderaSeUsaContraDiamanteReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Diamante diamante = new Diamante();
        hachaMadera.usar(diamante);
        assertThat(hachaMadera.getDurabilidad(), is(98));
    }

    @Test
    public void test05HachaMaderaSeUsaContraMaderaReduceSuDurabilidadDeADos(){
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
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
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
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
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
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
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
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