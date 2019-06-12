package main;

import main.herramientas.*;
import main.materiales.Madera;
import org.junit.Test;

import javax.print.attribute.HashAttributeSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MaderaTests {

    private static final int DURABIDAD_INICIAL_MADERA = 10;

    @Test
    public void testMaderaEsDesgastadaPorHachaMaderaYReduceSuDurabilidad(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hacha = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(),is(DURABIDAD_INICIAL_MADERA - hachaMadera.getFuerza()));

    }
    // hay que probar qeu el reducir durabilidad tmb funciona bien

    @Test
    public void test02MaderaEsDesgastadaPorHachaPiedra(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra= constructor.construirHachaPiedra();
=======
        Hacha hacha = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 5));
    }

    @Test
    public void test03MaderaEsDesgastadaPorHachaMetal(){
        Madera madera = new Madera();
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construirHachaMetal();
        Integer durabilidadMadera = madera.getDurabilidad();
<<<<<<< HEAD
=======
        Hacha hacha = ConstructorHacha.construirHachaMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 10));
    }

    @Test
    public void test04MaderaNoEsDesgastadaPorPicoMadera(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMadera = constructor.construirPicoMadera();
=======
        Pico picoMadera = ConstructorPico.construirPicoMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test05MaderaNoEsDesgastadaPorPicoPiedra(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoPiedra = constructor.construirPicoPiedra();
=======
        Pico picoMadera = ConstructorPico.construirPicoPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test06MaderaNoEsDesgastadaPorPicoMetal(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorPico constructor = new ConstructorPico();
        Pico picoMetal = constructor.construirPicoMetal();
=======
        Pico picoMadera = ConstructorPico.construirPicoMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test07MaderaNoEsDesgastadaPorPicoFino(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorPicoFino constructor = new ConstructorPicoFino();
        PicoFino picoFino = constructor.construirPicoFino();
=======
        PicoFino picoFino = ConstructorPicoFino.construirPicoFino();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        picoFino.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA));
    }

    @Test
    public void test08MaderaEsDesgastadaPorHachaMaderaSeReduceVariasVeces(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 2));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 4));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 6));
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 8));
    }

    @Test
    public void test09MaderaEsDesgastadaPorHachaPiedraSeReduceVariasVeces(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra = constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 5));
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(DURABIDAD_INICIAL_MADERA - 10));
    }

    @Test(expected = IllegalStateException.class)
    public void test10MaderaEsDesgastadaPorHachaMaderaLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
    }

    @Test(expected = IllegalStateException.class)
    public void test11MaderaEsDesgastadaPorHachaPiedraLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaPiedra = constructor.construirHachaPiedra();
=======
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaPiedra.usar(madera);
        hachaPiedra.usar(madera);
        hachaPiedra.usar(madera);
    }

    @Test(expected = IllegalStateException.class)
    public void test12MaderaEsDesgastadaPorHachaMetalLanzaExcepcionTrasRomperse(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMetal = constructor.construirHachaMetal();
=======
        Hacha hachaMetal = ConstructorHacha.construirHachaMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMetal.usar(madera);
        hachaMetal.usar(madera);
    }

    @Test
    public void test13MaderaConEstadoMuertoDevuelveDurabilidadCero(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorHacha constructor = new ConstructorHacha();
        Hacha hachaMadera = constructor.construirHachaMadera();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(0));
    }

    @Test
    public void test15MaderaEsDesgastadaConHachaMaderaHachaPiedraHachaMetal(){
        Madera madera = new Madera();
<<<<<<< HEAD
        ConstructorHacha constructorA = new ConstructorHacha();
        Hacha hachaMadera = constructorA.construirHachaMadera();
        ConstructorHacha constructorB = new ConstructorHacha();
        Hacha hachaPiedra = constructorB.construirHachaPiedra();
        ConstructorHacha constructorC = new ConstructorHacha();
        Hacha hachaMetal = constructorC.construirHachaMetal();
=======
        Hacha hachaMadera = ConstructorHacha.construirHachaMadera();
        Hacha hachaPiedra = ConstructorHacha.construirHachaPiedra();
        Hacha hachaMetal = ConstructorHacha.construirHachaMetal();
>>>>>>> a3d961f5c7e117f60d6f0107976ebe64a88fb5a7
        Integer durabilidadMadera = madera.getDurabilidad();
        hachaMadera.usar(madera);
        assertThat(madera.getDurabilidad(), is(durabilidadMadera - 2));
        hachaPiedra.usar(madera);
        assertThat(madera.getDurabilidad(), is(durabilidadMadera - 7));
        hachaMetal.usar(madera);
        assertThat(madera.getDurabilidad(), is(0));//Es cero porque la madera ya estaria rota a este punto.
    }
}
