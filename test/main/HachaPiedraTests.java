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

public class HachaPiedraTests {

    private final int DURABILIDAD_HACHA_PIEDRA = 200;
    private final int FUERZA_HACHA_PIEDRA = 5;

    @Test
    public void test08HachaPiedraSeUsaContraMaderaReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construirHachaPiedra();        Madera madera = new Madera();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
        Madera madera = new Madera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaPiedra.usar(madera);
        assertThat(hachaPiedra.getDurabilidad(), is(195));
    }

    @Test
    public void test09HachaPiedraSeUsaContraPiedraReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Piedra piedra = new Piedra();
        hachaPiedra.usar(piedra);
        assertThat(hachaPiedra.getDurabilidad(), is(195));
    }

    @Test
    public void test10HachaPiedraSeUsaContraMetalReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Metal metal = new Metal();
        hachaPiedra.usar(metal);
        assertThat(hachaPiedra.getDurabilidad(), is(195));
    }

    @Test
    public void test11HachaPiedraSeUsaContraDiamanteReduceSuDurabilidad() {
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Diamante diamante = new Diamante();
        hachaPiedra.usar(diamante);
        assertThat(hachaPiedra.getDurabilidad(), is(195));
    }

    @Test
    public void test05SeUsaContraMaderaReduceSuDurabilidadDeManeraCorrecta(){
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Madera madera = new Madera();
        Integer durabilidadHachaPiedra = hachaPiedra.getDurabilidad();
        hachaPiedra.usar(madera);
        assertThat(hachaPiedra.getDurabilidad(), is(DURABILIDAD_HACHA_PIEDRA - FUERZA_HACHA_PIEDRA));
    }

    @Test
    public void test06HachaPiedraSeUsaContraPiedraReduceSuDurabilidadDeManeraCorrecta(){
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Piedra piedra = new Piedra();
        hachaPiedra.usar(piedra);
        assertThat(hachaPiedra.getDurabilidad(), is(DURABILIDAD_HACHA_PIEDRA - FUERZA_HACHA_PIEDRA));

    }

    @Test
    public void test07HachaPiedraSeUsaContraMetalReduceSuDurabilidadDeManeraCorrecta(){
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Metal metal = new Metal();
        Integer durabilidadHachaPiedra = hachaPiedra.getDurabilidad();
        hachaPiedra.usar(metal);
        assertThat(hachaPiedra.getDurabilidad(), is(DURABILIDAD_HACHA_PIEDRA - FUERZA_HACHA_PIEDRA));
    }

    @Test
    public void test08HachaPiedraSeUsaContraDiamanteReduceSuDurabilidadDeManeraCorrecta(){
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Diamante diamante = new Diamante();
        hachaPiedra.usar(diamante);
        assertThat(hachaPiedra.getDurabilidad(), is(DURABILIDAD_HACHA_PIEDRA - FUERZA_HACHA_PIEDRA));
    }
}
